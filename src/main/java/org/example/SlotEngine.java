package org.example;

public class SlotEngine {
    static final int[][] REELS = {
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

    public static int[][] spin() {
        int[][] arr = new int[3][3];
        int reelLen = REELS[0].length;

        for (int i = 0; i < 3; i++) {
            int R = (int) (Math.random() * (reelLen - 1));

            arr[i][1] = REELS[i][R];

            if (R > 0 && R < reelLen - 1) {
                arr[i][0] = REELS[i][R - 1];
                arr[i][2] = REELS[i][R + 1];
            } else if (R == 0) {
                arr[i][0] = REELS[i][reelLen - 1];
                arr[i][2] = REELS[i][R + 1];
            } else {
                arr[i][0] = REELS[i][R - 1];
                arr[i][2] = REELS[i][0];
            }
        }

        return arr;
    }

    public static int checkPaylines() {

    }
}
