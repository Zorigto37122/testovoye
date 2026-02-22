package org.example;

public class MathTest {
    public static void run(int iterations) {
        int totalBet = 0;
        int totalWin = 0;
        int totalWinTimes = 0;

        for (int i = 0; i < iterations; i++) {
            totalBet += 5;
            int[][] slot = SlotEngine.spin();
            int currWin = SlotEngine.checkPaylines(slot);

            if (currWin > 0) {
                totalWinTimes += 1;
                totalWin += currWin;
            }
        }

        System.out.println("Total Bet: " + totalBet);
        System.out.println("Total Win: " + totalWin);
        System.out.println("Total Win: " + String.format("%.4f", (double) totalWinTimes / iterations));
        System.out.println("Return to Player (RTP): " + String.format("%.4f", (double) totalWin / totalBet));
    }
}
