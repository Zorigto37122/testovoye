package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SlotEngine {
    private static final int REELS = 3;
    private static final int ROWS = 3;
    private static final int WILD_CODE = 0;

    private static final Random RANDOM = new Random();

    private static final int[][] REEL_STRIPS = {
            {
                    1, 8, 6, 9, 5, 6, 1, 8, 6, 7,
                    7, 6, 2, 5, 8, 6, 7, 5, 3, 8,
                    6, 7, 0, 8, 3, 6, 7, 0, 8, 4,
                    7, 9, 8, 5, 2, 0, 7, 6, 0, 7,
                    5, 8, 9, 5, 8, 7, 0, 8, 4, 2,
                    7, 6, 0, 4, 5, 3, 6, 8, 7, 6,
                    9, 5, 3, 5, 4, 0, 2, 5, 7, 4,
                    3, 5, 0, 5, 6, 7, 9
            },
            {
                    6, 4, 5, 5, 6, 3, 6, 8, 5, 9,
                    6, 7, 8, 5, 0, 1, 5, 7, 2, 9,
                    5, 7, 9, 5, 7, 4, 8, 0, 7, 5,
                    3, 8, 0, 7, 8, 4, 5, 7, 9, 6,
                    7, 0, 8, 7, 6, 7, 2, 6, 0, 3,
                    6, 2, 7, 3, 4, 6, 9, 8, 6, 0,
                    8, 7, 5, 0, 1, 8, 3, 7, 5, 9,
                    8, 4, 7, 0, 8, 2, 6
            },
            {
                    8, 4, 5, 9, 6, 8, 3, 4, 7, 5,
                    1, 8, 5, 8, 9, 6, 7, 9, 2, 8,
                    4, 6, 7, 0, 8, 5, 3, 1, 8, 7,
                    0, 6, 8, 3, 0, 6, 5, 8, 0, 7,
                    6, 3, 7, 4, 0, 2, 5, 3, 4, 8,
                    5, 7, 9, 6, 8, 5, 7, 0, 3, 8,
                    2, 5, 7, 6, 9, 8, 4, 6, 0, 7,
                    6, 0, 8, 7, 6, 7, 6
            }
    };

    private static final int[][] payLines = {
            {0, 0, 0},
            {1, 1, 1},
            {2, 2, 2},
            {0, 1, 2},
            {2, 1, 0}
    };

    private Map<Integer, int[]> PAY_TABLE = new HashMap<Integer, int[]>() {{
        put(0, new int[]{0, 0, 50});
        put(1, new int[]{1, 10, 25});
        put(2, new int[]{0, 5, 15});
        put(3, new int[]{0, 2, 10});
        put(4, new int[]{0, 0, 8});
        put(5, new int[]{0, 0, 5});
        put(6, new int[]{0, 0, 3});
        put(7, new int[]{0, 0, 2});
        put(8, new int[]{0, 0, 1});
        put(9, new int[]{0, 0, 0});
    }};

    public void printSlot(int[][] slot) {
        for (int currReel = 0; currReel < REELS; currReel++) {
            System.out.print("Reel " + currReel + ": ");
            for (int j = 0; j < ROWS; j++) {
                System.out.print(slot[currReel][j] + " ");
            }
            System.out.println();
        }
    }

    private int getTargetSymbol(int[] line) {
        for (int symbol : line) {
            if (symbol != WILD_CODE) {
                return symbol;
            }
        }
        return WILD_CODE;
    }

    private int getSequenceLength(int[] line, int targetSymbol) {
        if (targetSymbol == WILD_CODE) {
            return line.length;
        }

        for (int currPos = 0; currPos < line.length; currPos++) {
            if (line[currPos] != WILD_CODE && line[currPos] != targetSymbol) {
                return currPos;
            }
        }
        return line.length;
    }

    public int[][] spin() {
        int[][] slot = new int[REELS][ROWS];

        for (int currReel = 0; currReel < REELS; currReel++) {
            int[] strip = REEL_STRIPS[currReel];
            int len = strip.length;
            int centerPos = RANDOM.nextInt(len);

            for (int offset = 0; offset < ROWS; offset++) {
                int index = (centerPos + offset - 1 + len) % len;
                slot[currReel][offset] = strip[index];
            }
        }

        return slot;
    }

    public int calculatePay(int[][] slot) {
        int pay = 0;

        for (int[] payLine : payLines) {
            int[] line = new int[payLine.length];

            line[0] = slot[0][payLine[0]];
            line[1] = slot[1][payLine[1]];
            line[2] = slot[2][payLine[2]];

            int targetSymbol = getTargetSymbol(line);
            int seqLength = getSequenceLength(line, targetSymbol);

            pay += PAY_TABLE.get(targetSymbol)[seqLength - 1];
        }

        return pay;
    }
}
