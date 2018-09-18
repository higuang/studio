package org.yray.studio.portal.dto;

import org.springframework.util.StringUtils;
import org.yray.utils.file.FileUtils;

import javax.persistence.*;
import java.util.Date;

@Table(name = "T_MAIN_DOC")
public class MainDocDto {
    @Id
    private String id;

    private String fileType;

    private String title;

    private Date createTime;

    private Date updateTime;

    private byte[] content;
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }


    public  String getJustTitle()
    {
        if(StringUtils.isEmpty(title))
            return "";
       return FileUtils.clearFileType(title);
    }
}