package org.example;

import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            int[][] slot = SlotEngine.spin();
            SlotEngine.printSlot(slot);
            System.out.println("Pay: " + SlotEngine.checkPaylines(slot) + "\n");
        }

    }
}