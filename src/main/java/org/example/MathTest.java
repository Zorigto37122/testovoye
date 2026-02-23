package org.example;

public class MathTest {
    public static void run(int iterations) {
        int totalBet = 0;
        int totalWin = 0;
        int totalWinCount = 0;
        SlotEngine eng = new SlotEngine();

        for (int i = 0; i < iterations; i++) {
            totalBet += 5;
            eng.spin();
            int currWin = eng.calcPaylines();

            if (currWin > 0) {
                totalWinCount += 1;
                totalWin += currWin;
            }
        }

        System.out.println("Total Bet: " + totalBet);
        System.out.println("Total Win: " + totalWin);
        System.out.println("Hit Rate: " + String.format("%.4f", (double) totalWinCount / iterations));
        System.out.println("Return to Player (RTP): " + String.format("%.4f", (double) totalWin / totalBet));
    }
}
