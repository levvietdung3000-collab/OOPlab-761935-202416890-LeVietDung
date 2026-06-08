package hust.soict.hedspi.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class GarbageCreator {
    public static void main(String[] args) {
        // Cậu chủ có thể đổi đường dẫn tới một file bất kỳ có dung lượng khoảng 1-2MB trên máy
        String filename = "test.txt"; 
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        startTime = System.currentTimeMillis();
        String outputString = "";
        for (byte b : inputBytes) {
            outputString += (char) b; // Code này sẽ chạy cực kỳ chậm
        }
        endTime = System.currentTimeMillis();
        System.out.println("GarbageCreator time: " + (endTime - startTime) + " ms");
    }
}
