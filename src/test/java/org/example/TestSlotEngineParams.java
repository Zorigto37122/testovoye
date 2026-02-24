package org.example;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class TestSlotEngineParams {
    private static Object[] testPaylinesValues() {
        return new Object[] {
                new Object[] {new int[][]{
                        {4, 9, 9},
                        {4, 9, 9},
                        {4, 9, 9}
                }, 8, "Payline #1 got wrong"},
                new Object[] {new int[][]{
                        {9, 7, 9},
                        {9, 7, 9},
                        {9, 7, 9}
                }, 2, "Payline #2 got wrong"},
                new Object[] {new int[][]{
                        {9, 9, 6},
                        {9, 9, 6},
                        {9, 9, 6}
                }, 3, "Payline #3 got wrong"},
                new Object[] {new int[][]{
                        {9, 9, 0},
                        {9, 0, 9},
                        {0, 9, 9}
                }, 50, "Payline #4 got wrong"},
                new Object[] {new int[][]{
                        {1, 9, 9},
                        {9, 1, 9},
                        {9, 9, 1}
                }, 26, "Payline #5 got wrong"},

        };
    }

    @Test
    @Parameters(method = "testPaylinesValues")
    public void testPaylines(int[][] slot, int exp, String message) {
        SlotEngine engine = new SlotEngine();
        Assert.assertEquals(message, exp, engine.calcPaylines(slot));
    }



}
