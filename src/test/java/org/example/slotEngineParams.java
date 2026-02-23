package org.example;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class slotEngineParams {
    private static Object[] testPaylinesValues() {
        return new Object[] {
                new Object[] {new int[][]{
                        {4, 9, 9},
                        {4, 9, 9},
                        {4, 9, 9}
                }, 8},
                new Object[] {new int[][]{
                        {9, 7, 9},
                        {9, 7, 9},
                        {9, 7, 9}
                }, 2},
                new Object[] {new int[][]{
                        {9, 9, 6},
                        {9, 9, 6},
                        {9, 9, 6}
                }, 3},
                new Object[] {new int[][]{
                        {9, 9, 0},
                        {9, 0, 9},
                        {0, 9, 9}
                }, 50},
                new Object[] {new int[][]{
                        {1, 9, 9},
                        {9, 1, 9},
                        {9, 9, 1}
                }, 27},

        };
    }

    @Test
    @Parameters(method = "testPaylinesValues")
    public void testPaylines(int[][] slot, int exp) {
        SlotEngine engine = new SlotEngine();
        engine.setSlot(slot);
        Assert.assertEquals("Paylines got wrong", exp, engine.calcPaylines());
    }



}
