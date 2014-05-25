package org.mowitnow;

import com.google.common.collect.Lists;
import org.mowitnow.bean.Mower;
import org.mowitnow.bean.Orientation;
import org.mowitnow.bean.Position;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * Created by home on 10/05/2014.
 */
public class ProgrammerUTest {

    private Programmer programmer;


    @Test
    public void execute_withNominalCase_shouldReturnExpectedPositions() throws Exception{
        // Given
        List<String> instructions = Lists.newArrayList(
                "5 5",
                "1 2 N",
                "GAGAGAGAA",
                "3 3 E",
                "AADAADADDA"
        );
        programmer = new Programmer(instructions);

        // When
        programmer.execute();

        // Then
        List<Mower> mowers = programmer.getMowers();

        Assert.assertEquals(new Position(1, 3, Orientation.N), mowers.get(0).getPosition());
        Assert.assertEquals(new Position(5, 1, Orientation.E), mowers.get(1).getPosition());

    }
}
