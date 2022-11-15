package lotto;

import java.util.List;

public class Display {
    static void displayLottoPaper (List<List<Integer>> LottoPaper){

        System.out.println(LottoPaper.size() + "개를 구매했습니다.");

        for (int i = 0; i < LottoPaper.size(); i++) {
            System.out.println(LottoPaper.get(i));
        }
    }
}
