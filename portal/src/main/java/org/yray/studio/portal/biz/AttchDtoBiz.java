package org.yray.studio.portal.biz;

import org.springframework.stereotype.Service;
import org.yray.studio.portal.dao.AttchDtoMapper;
import org.yray.studio.portal.dto.AttchDto;

@Service
public class AttchDtoBiz extends BaseBiz<AttchDtoMapper,AttchDto> {

    public void  insertByFileName(AttchDto attchDto)
    {
        AttchDto search=new AttchDto();
        search.setFileName(attchDto.getFileName());
        search= mapper.selectOne(search);
        if(search==null) {
            mapper.insert(attchDto);
        }
        else
        {
            search.setContent(attchDto.getContent());
            mapper.updateByPrimaryKey(search);
        }
    }
}
