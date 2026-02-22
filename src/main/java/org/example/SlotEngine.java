package org.example;

import java.util.HashMap;
import java.util.Map;

public class SlotEngine {
    static private final int[][] REELS = {
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

    static private Map<Integer, String> symbolsMap = new HashMap<Integer, String>() {{
        put(0, "WI");
        put(1, "H1");
        put(2, "M1");
        put(3, "M2");
        put(4, "M3");
        put(5, "L1");
        put(6, "L2");
        put(7, "L3");
        put(8, "L4");
        put(9, "EM");
    }};

    static private final int[][] payLines = {
            {0, 0, 0},
            {1, 1, 1},
            {2, 2, 2},
            {0, 1, 2},
            {2, 1, 0}
    };

    static private Map<Integer, int[]> payTable = new HashMap<Integer, int[]>() {{
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

    public static void printSlot(int[][] slot) {
        for (int i = 0; i < slot.length; i++) {
            System.out.print("Reel " + i + ": ");
            for (int j = 0; j < slot.length; j++) {
                System.out.print(slot[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int threeOfKind(int a, int b, int c) {
        if (a == b && b == c) {
            return a;
        } else if (a == 0 && b == c) {
            return b;
        } else if (a == b && c == 0) {
            return a;
        } else if (a == c && b == 0) {
            return a;
        } else if (a == 0 && b == 0) {
            return c;
        } else if (a == 0 && c == 0) {
            return b;
        } else if (b == 0 && c == 0) {
            return a;
        } else {
            return -1;
        }
    }

    public static int[][] spin() {
        int[][] slot = new int[3][3];
        int reelLen = REELS[0].length;

        for (int i = 0; i < 3; i++) {
            int R = (int) (Math.random() * (reelLen - 1));

            slot[i][1] = REELS[i][R];

            if (R > 0 && R < reelLen - 1) {
                slot[i][0] = REELS[i][R - 1];
                slot[i][2] = REELS[i][R + 1];
            } else if (R == 0) {
                slot[i][0] = REELS[i][reelLen - 1];
                slot[i][2] = REELS[i][R + 1];
            } else {
                slot[i][0] = REELS[i][R - 1];
                slot[i][2] = REELS[i][0];
            }
        }

        return slot;
    }

    public static int checkPaylines(int[][] slot) {
        int pay = 0;

        for (int[] payLine : payLines) {
            int[] line = new int[3];

            line[0] = slot[0][payLine[0]];
            line[1] = slot[1][payLine[1]];
            line[2] = slot[2][payLine[2]];

            System.out.println(line[0] + " " + line[1] + " " + line[2]);

            int currPay = 0;

            int three = threeOfKind(line[0], line[1], line[2]);

            if (three >= 0) { // тройки
                currPay += payTable.get(three)[2];
            } else if (line[0] == line[1]) { // пары
                currPay += payTable.get(line[0])[1];
            } else if (line[1] == line[2]) { // пары
                currPay += payTable.get(line[1])[1];
            } else {
                for (int l : line) { // одиночные
                    pay += payTable.get(l)[0];
                }
            }

            pay += currPay;
        }

        return pay;
    }
}
