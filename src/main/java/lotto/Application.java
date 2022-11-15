package lotto;

import java.util.*;

public class Application {
        // TODO: 프로그램 구현

        public static void main(String[] args) { // 로또 번호 6개 랜덤 추출하기

            // 로또 번호 6개를 배열에 넣기
    
            int[] arr = new int[6];
            for (int i = 0; i < 6; i++) {
                arr[i] = (int) (Math.random() * 45 + 1);
    
                System.out.println(i + 1 + "번째 번호 : " + arr[i]);
            }
    
            System.out.println();
    
            // 중복 없애기
    
            if (arr[1] == arr[0]) {
                arr[1] = (int) (Math.random() * 45 + 1);
    
            }
    
            if (arr[2] == arr[1] || arr[2] == arr[0]) {
                arr[2] = (int) (Math.random() * 45 + 1);
    
            }
    
            if (arr[3] == arr[2] || arr[3] == arr[1] || arr[3] == arr[0]) {
                arr[3] = (int) (Math.random() * 45 + 1);
    
            }
    
            if (arr[4] == arr[3] || arr[4] == arr[2] || arr[4] == arr[1] || arr[4] == arr[0]) {
                arr[4] = (int) (Math.random() * 45 + 1);
    
            }
    
            if (arr[5] == arr[4] || arr[5] == arr[3] || arr[5] == arr[2] || arr[5] == arr[1] || arr[5] == arr[0]) {
                arr[5] = (int) (Math.random() * 45 + 1);
    
            }
    
            for (int i = 0; i < 6; i++)
                System.out.println(i + 1 + "번째 번호 : " + arr[i]);
    
        }
    }
}
