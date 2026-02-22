package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class SlotEngineTest {

    @Test
    public void checkPaylines() {
        int[][] slot1 = {
            {4, 9, 9},
            {4, 0, 9},
            {4, 9, 9}
        };

        int expPay = 8;
        int actPay = SlotEngine.checkPaylines(slot1);

        assertEquals("Payline #1 wrong ", expPay, actPay);

        int[][] slot2 = {
                {9, 7, 3},
                {9, 7, 5},
                {9, 7, 3}
        };

        expPay = 2;
        actPay = SlotEngine.checkPaylines(slot2);

        assertEquals("Payline #2 wrong ", expPay, actPay);

        int[][] slot3 = {
                {9, 3, 6},
                {4, 7, 6},
                {8, 2, 6}
        };

        expPay = 3;
        actPay = SlotEngine.checkPaylines(slot3);

        assertEquals("Payline #3 wrong ", expPay, actPay);

        int[][] slot4 = {
                {9, 2, 0},
                {4, 0, 6},
                {0, 9, 9}
        };

        expPay = 50;
        actPay = SlotEngine.checkPaylines(slot4);

        assertEquals("Payline #4 wrong ", expPay, actPay);

        int[][] slot5 = {
                {1, 9, 9},
                {9, 1, 9},
                {9, 9, 1}
        };

        expPay = 27;
        actPay = SlotEngine.checkPaylines(slot5);

        assertEquals("Payline #5 wrong ", expPay, actPay);

    }
}