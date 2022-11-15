package lotto;

import java.util.List;

public class Display {
    static void displayLottoPaper (List<List<Integer>> LottoPaper){

        System.out.println(LottoPaper.size() + "개를 구매했습니다.");

        for (int i = 0; i < LottoPaper.size(); i++) {
            System.out.println(LottoPaper.get(i));
        }
    }

    static void displayRank() {
        System.out.println(GameData.FIRST.getPrintWord() +  GameData.FIRST.getCount() + "개");
        System.out.println(GameData.SECOND.getPrintWord() +  GameData.SECOND.getCount() + "개");
        System.out.println(GameData.THIRD.getPrintWord() +  GameData.THIRD.getCount() + "개");
        System.out.println(GameData.FOURTH.getPrintWord() +  GameData.FOURTH.getCount() + "개");
        System.out.println(GameData.FIFTH.getPrintWord() +  GameData.FIFTH.getCount() + "개");
    }
}
