package org.yray.studio.portal.service;

import com.hankcs.hanlp.model.crf.CRFLexicalAnalyzer;
import com.hankcs.hanlp.tokenizer.TraditionalChineseTokenizer;
import com.hankcs.lucene.HanLPAnalyzer;
import com.hankcs.lucene.HanLPIndexAnalyzer;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;
import org.springframework.expression.spel.ast.Indexer;
import org.springframework.stereotype.Service;
import org.yray.studio.portal.dto.MainDocDto;
import org.yray.utils.file.FileUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class IndexerService {
    // 写索引实例
    private IndexWriter writer=null;

    private IndexReader reader=null;
    //索引指定的文档路径
    final static String indexDir = "D:\\yray_studio\\data_index";
    ////被索引数据的路径
    final static String dataDir = "D:\\yray_studio\\yray_doc";
    /**
     * 构造方法 实例化IndexWriter
     * @throws IOException
     */
    public  IndexerService() throws IOException {
        //得到索引所在目录的路径
        Directory directory = FSDirectory.open(Paths.get(indexDir));
        // 标准分词器
        Analyzer analyzer =  new HanLPAnalyzer();
        //保存用于创建IndexWriter的所有配置。
        IndexWriterConfig iwConfig = new IndexWriterConfig(analyzer);
        iwConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
        //实例化IndexWriter
        writer = new IndexWriter(directory, iwConfig);

    }
    /**
     * 重用一些旧的 IndexReader
     * @return
     */
    public IndexSearcher getSearcher() {
        try {
            if(reader==null) {
                Directory dir=FSDirectory.open(new File(indexDir).toPath());
                reader = DirectoryReader.open(dir);
            } else {
                IndexReader tr = DirectoryReader.openIfChanged((DirectoryReader)reader);
                if(tr!=null) {
                    reader.close();
                    reader = tr;
                }
            }
            return new IndexSearcher(reader);
        } catch (CorruptIndexException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 关闭写索引
     *
     * @throws Exception
     * @return 索引了多少个文件
     */
    public void close() throws IOException {
        writer.close();
    }

    public int index() throws Exception {
        File[] files = new File(dataDir).listFiles();
        for (File file : files) {
            if(!FileUtils.getFileType(file.getName()).equals("bak")) {
                indexFile(file);
            }
        }
        //返回索引了多少个文件
        return writer.numDocs();

    }

    /**
     * 索引指定文件
     *
     * @param f
     */
    private void indexFile(File f) throws Exception {
        //输出索引文件的路径
        System.out.println("索引文件：" + f.getCanonicalPath());
        //获取文档，文档里再设置每个字段
        Document doc = getDocument(f);
        //开始写入,就是把文档写进了索引文件里去了；
        writer.addDocument(doc);
    }

    /**
     * 获取文档，文档里再设置每个字段
     *
     * @param f
     * @return document
     */
    private Document getDocument(File f) throws Exception {
        Document doc = new Document();
        //把设置好的索引加到Document里，以便在确定被索引文档
        InputStream stream = Files.newInputStream(f.toPath());
        doc.add(new TextField("contents",new BufferedReader(new InputStreamReader(stream, Charset.forName("GBK")))));
        //Field.Store.YES：把文件名存索引文件里，为NO就说明不需要加到索引文件里去
        doc.add(new TextField("fileName", f.getName(), Field.Store.YES));
        //把完整路径存在索引文件里
        doc.add(new TextField("fullPath", f.getCanonicalPath(), Field.Store.YES));
        return doc;
    }

    public static void main(String[] args) throws IOException {


        IndexerService indexer = null;
        int numIndexed = 0;
        //索引开始时间
        long start = System.currentTimeMillis();
        try {
            indexer = new IndexerService();
            numIndexed = indexer.index();
         //    indexer.searchByTerm("contents","docker",Integer.MAX_VALUE);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                indexer.close();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //索引结束时间
        long end = System.currentTimeMillis();
        System.out.println("索引：" + numIndexed + " 个文件 花费了" + (end - start) + " 毫秒");

    }

    public void searchByTerm(String field,String value,int num){
        // 首先获得 IndexSearcher
        IndexSearcher searcher = getSearcher();
        // 搜索特定的项
        Query query = new TermQuery(new Term(field,value));
        try {
            TopDocs topDocs = searcher.search(query,num);
            System.out.println("实际搜索到的记录数 => " + topDocs.totalHits);
            Document document = null;
            for(ScoreDoc scoreDoc:topDocs.scoreDocs){
                document = searcher.doc(scoreDoc.doc);
/*
                String result = "name => " + document.get("name") + "\t email => "+ document.get("email") +
                        "\t id => " + document.get("id") + "\t attach => " + document.get("attach") + "\t date => " + document.get("date");
*/
                System.out.println("result:"+document.get("fileName"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }


    public List<MainDocDto> searchMainDoc(String keyword){
        List<MainDocDto> list=new ArrayList<>();
        // 首先获得 IndexSearcher
        IndexSearcher searcher = getSearcher();
        // 实例化分析器
        Analyzer analyzer = new HanLPAnalyzer();

        // 搜索特定的项
       // Query query = new TermQuery(new Term("contents",keyword));
        try {
            QueryParser parser = new QueryParser("contents", analyzer);
            // 根据传进来的p查找
            Query query = parser.parse(keyword);
            TopDocs topDocs = searcher.search(query,Integer.MAX_VALUE);
            System.out.println("实际搜索到的记录数 => " + topDocs.totalHits);
            Document document = null;

            for(ScoreDoc scoreDoc:topDocs.scoreDocs){
                document = searcher.doc(scoreDoc.doc);
                MainDocDto item=new MainDocDto();
                item.setTitle(document.get("fileName"));
                item.setFileName(document.get("contents"));
                list.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }
        return  list;
    }
    /**
     *
     * @param field
     * @param start
     * @param end
     * @param num
     */
    public void searchByTermRange(String field,String start,String end,int num){
        IndexSearcher searcher = getSearcher();
        /**
         * 这个 Query 不适用于数字范围查询，数字范围查询请使用 NumericRangeQuery 代替
         */
        Query query = new TermRangeQuery(field,new BytesRef(start.getBytes()),new BytesRef(end.getBytes()),true,true);
        showQueryResult(searcher,query,num);
    }


    /**
     *
     * @param searcher
     * @param query
     * @param num
     */
    private void showQueryResult(IndexSearcher searcher,Query query,Integer num){
        TopDocs topDocs = null;
        try {
            topDocs = searcher.search(query,num);
            System.out.println("实际搜索到的记录数 => " + topDocs.totalHits);
            Document document = null;
            for(ScoreDoc scoreDoc:topDocs.scoreDocs){
                document = searcher.doc(scoreDoc.doc);
                String result = "name => " + document.get("name") + "\t email => "+ document.get("email") +
                        "\t id => " + document.get("id") + "\t attach => " + document.get("attach") + "\t date => " + document.get("date");
                System.out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 前缀匹配查询
     * @param field
     * @param value
     * @param num
     */
    public void searchByPrefix(String field,String value,int num){
        IndexSearcher searcher = getSearcher();
        Query query = new PrefixQuery(new Term(field,value));
        showQueryResult(searcher,query,num);
    }

    /**
     * 通配符查询
     * 通配符： * 表示匹配任意多个字符，? 表示匹配一个字符
     * @param field
     * @param value
     * @param num
     */
    public void searchByWildcard(String field,String value,int num){
        IndexSearcher searcher = getSearcher();
        Query query = new WildcardQuery(new Term(field,value));
        showQueryResult(searcher,query,num);
    }

    /**
     * 多个条件的查询
     * MUST 表示必须要有，即“且，交集”
     * SHOULD 表示可以有，也可以没有，即“或者，并集”
     * @param field1
     * @param value1
     * @param field2
     * @param value2
     * @param num
     */
    public void searchByBoolean(String field1,String value1,String field2,String value2, int num){
        IndexSearcher searcher = getSearcher();
        BooleanQuery.Builder booleanQuery = new BooleanQuery.Builder();
        Query query1 = new TermQuery(new Term(field1,value1));
        Query query2 = new TermQuery(new Term(field2,value2));
        booleanQuery.add(query1,BooleanClause.Occur.MUST);
        booleanQuery.add(query2,BooleanClause.Occur.MUST);
        showQueryResult(searcher,booleanQuery.build(),num);
    }





    /**
     * 模糊查询
     * @param field
     * @param value
     * @param num
     */
    public void searchByFuzzy(String field,String value,int maxEdits, int prefixLength,int num){
        IndexSearcher searcher = getSearcher();
        FuzzyQuery query = new FuzzyQuery(new Term(field,value),maxEdits,prefixLength);
        showQueryResult(searcher,query,num);
    }


    /**
     * 根据一个字符串，实现了上述各种特殊的查询功能
     * 那就要通过 QueryParser 来完成
     * @param query
     * @param num
     */
    public void searchByQueryParser(Query query,int num){
        IndexSearcher searcher = getSearcher();
        showQueryResult(searcher,query,num);
    }

}
