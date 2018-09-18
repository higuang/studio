package org.yray.studio.portal.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.yray.studio.portal.dto.MainDocDto;

import java.io.File;

public class MainDocDtoServiceTest extends BaseTest {

    @Autowired
    MainDocDtoService mainDocDtoService;

   @Test
    public void testInitDoc()
    {
        mainDocDtoService.initDoc();
    }


    //@Test
    public void testDoDetail()
    {
        File file=new File("D:\\yray_studio\\yray_doc\\jenkins.doc");
        mainDocDtoService.doDetail(file);
    }
}
