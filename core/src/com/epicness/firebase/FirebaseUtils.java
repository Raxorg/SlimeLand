package com.epicness.firebase;

import java.util.ArrayList;
import java.util.Arrays;

public class FirebaseUtils {

    // Tettinger: Tetty salmon-teal
    // DQ: purple-gray
    // Zebra: white-purple
    // Lyze: red-teal

    public static void work() {
        String result = "";
        String[] colors = new String[]{
                "white", "red", "purple", "salmon", "orange", "yellow", "olive",
                "chartreuse", "forest", "teal", "cyan", "blue", "brown", "magenta", "gray"
        };
        int count = 0;
        for (int i = 0; i < colors.length; i++) {
            for (int j = i + 1; j < colors.length; j++) {
                if (i != 0 || j != 1) {
                    result = result.concat(",");
                }
                result = result.concat(colors[i] + "-" + colors[j]);
                count++;
            }
        }
        System.out.println(result);
        System.out.println(count);
    }

    public static String extractColorPair(String pair, String colorPairs) {
        String[] pairs = colorPairs.split(",");
        ArrayList<String> pairsArray = new ArrayList<>(Arrays.asList(pairs));
        pairsArray.remove(pair);
        String newColorPairs = "";
        for (int i = 0; i < pairsArray.size(); i++) {
            if (i != 0) {
                newColorPairs = newColorPairs.concat(",");
            }
            newColorPairs = newColorPairs.concat(pairsArray.get(i));
        }
        return newColorPairs;
    }
}