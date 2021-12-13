package com.epicness.firebase;

public class FirebaseUtils {

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
}