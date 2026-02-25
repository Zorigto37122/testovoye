package org.example;

import org.junit.Test;

public class MathTest {
    public static void mathTest(int iterations) {
        long totalBet = 0;
        long totalWin = 0;
        long totalWinCount = 0;
        double averageRTP = 0;
        double RTPm2 = 0;
        long count = 0;
        SlotEngine eng = new SlotEngine();

        for (int i = 0; i < iterations; i++) {
            count += 1;
            totalBet += 5;
            int currWin = eng.calculatePay(eng.spin());

            if (currWin > 0) {
                totalWinCount += 1;
                totalWin += currWin;

                averageRTP += ((double) totalWin / totalBet * 100 - averageRTP) / count;
                RTPm2 += Math.pow((double) totalWin / totalBet * 100 - averageRTP, 2);
            }
        }

        System.out.println("Total Bet: " + totalBet);
        System.out.println("Total Win: " + totalWin);
        System.out.println("Hit Rate: " + String.format("%.4f", (double) totalWinCount / iterations * 100) + "%");
        System.out.println("Return to Player (RTP): " + String.format("%.4f", averageRTP) + "%");
        System.out.println("SD of RTP: " + String.format("%.4f", Math.sqrt(RTPm2 / (count - 1))) + "%");
    }

    @Test
    public void runMathTest(){
        mathTest(10000000);
    }
}
