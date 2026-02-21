package org.example;

import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) {
        int[][] arr = SlotEngine.spin();

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Reel " + i + ": ");
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}