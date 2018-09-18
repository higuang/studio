package org.yray.studio.portal.biz;

import org.springframework.stereotype.Service;
import org.yray.studio.portal.dao.AttchDtoMapper;
import org.yray.studio.portal.dao.MainDocDtoMapper;
import org.yray.studio.portal.dto.AttchDto;
import org.yray.studio.portal.dto.MainDocDto;

@Service
public class MainDocDtoBiz  extends BaseBiz<MainDocDtoMapper,MainDocDto> {
    public MainDocDto  insertByFileName(MainDocDto mainDocDto)
    {
        MainDocDto search=new MainDocDto();
        search.setFileName(mainDocDto.getFileName());
        search= mapper.selectOne(search);
        if(search==null) {
            mapper.insert(mainDocDto);
        }
        else
        {
            search.setContent(mainDocDto.getContent());
            mapper.updateByPrimaryKey(search);
            mainDocDto=search;
        }
        return mainDocDto;
    }
}
