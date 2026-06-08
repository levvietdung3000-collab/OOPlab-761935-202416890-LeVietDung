package hust.soict.hedspi.garbage;

import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        Random r = new Random(123);
        long start = System.currentTimeMillis();
        String s = "";
        
        // Dùng toán tử + để cộng chuỗi (Tạo ra rất nhiều rác bộ nhớ)
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2);
        }
        System.out.println("Time using + operator: " + (System.currentTimeMillis() - start) + " ms");

        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        
        // Dùng StringBuilder (Tối ưu và siêu nhanh)
        for (int i = 0; i < 65536; i++) {
            sb.append(r.nextInt(2));
        }
        s = sb.toString();
        System.out.println("Time using StringBuilder: " + (System.currentTimeMillis() - start) + " ms");
    }
}