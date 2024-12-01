package fashion.service;


import java.util.Random;

public class Helper {
    public static String randomString(int len) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        String pattern = "1234567890qwertyuiopasdfghjklzxcvbnm";
        for (int i = 0; i < len; i++) {
            sb.append(pattern.charAt(random.nextInt(pattern.length())));
        }
        return sb.toString();
    }
}
