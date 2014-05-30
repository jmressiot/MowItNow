package org.mowitnow.utils;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileUtilsUTest {

    List<String> lines;

    @Test
    public void readFile_withFileNull_shouldReturnNull() throws IOException {

        // when
        lines = FileUtils.readFile(null);

        //then
        Assert.assertNull(lines);
    }

    @Test
    public void readFile_withInputFile_shouldReturnExpectedLines() throws IOException {
        // given
        File inputFile = new File("input.txt");
        List<String> expectedLines = Lists.newArrayList(
                "5 5",
                "1 2 N",
                "GAGAGAGAA",
                "3 3 E",
                "AADAADADDA"
        );

        // when
        lines = FileUtils.readFile(inputFile);

        // then
        Assert.assertNotNull(lines);
        Assert.assertEquals(expectedLines, lines);
    }
}
