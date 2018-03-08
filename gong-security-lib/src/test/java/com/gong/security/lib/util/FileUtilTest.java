package com.gong.security.lib.util;


import org.junit.Test;

/**
 * Created by SNOW on 2018.02.08.
 */
public class FileUtilTest {
    @Test
    public void getDateAsRelativePath() throws Exception {
        String fileName = FileUtil.getDateAsRelativePath("./01.jpg");
        System.out.println(fileName);
    }

}