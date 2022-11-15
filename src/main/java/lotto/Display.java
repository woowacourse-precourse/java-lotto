package lotto;

import java.util.List;

public class Display {
    static void displayLottoPaper(List<List<Integer>> LottoPaper) {
        System.out.println(LottoPaper.size() + "개를 구매했습니다.");

        for (int i = 0; i < LottoPaper.size(); i++) {
            System.out.println(LottoPaper.get(i));
        }
    }

    static void displayRank() {
        System.out.println(GameData.FIRST.getPrintWord() + GameData.FIRST.getCount() + "개");
        System.out.println(GameData.SECOND.getPrintWord() + GameData.SECOND.getCount() + "개");
        System.out.println(GameData.THIRD.getPrintWord() + GameData.THIRD.getCount() + "개");
        System.out.println(GameData.FOURTH.getPrintWord() + GameData.FOURTH.getCount() + "개");
        System.out.println(GameData.FIFTH.getPrintWord() + GameData.FIFTH.getCount() + "개");
    }

    static void displayRate(String inputMoney) {
        Long totalIncome = 0L;

        totalIncome += GameData.FIRST.getIncome();
        totalIncome += GameData.SECOND.getIncome();
        totalIncome += GameData.THIRD.getIncome();
        totalIncome += GameData.FOURTH.getIncome();
        totalIncome += GameData.FIFTH.getIncome();

        float rate = (float) ((totalIncome / Double.parseDouble(inputMoney)) * 100);

        System.out.println("총 수익률은 " + String.format("%.1f", rate) + "%입니다.");
    }

    static void displayErrorSameNumber() {
        System.out.println("[ERROR] 로또 번호에는 중복이 없어야 합니다.");
    }

    static void displayErrorBound() {
        System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    static void displayErrorOnlyNumber() {
        System.out.println("[ERROR] 로또 번호는 숫자여야 합니다.");
    }

    static void displayErrorMoney() {
        System.out.println("[ERROR] 로또 구매 금액은 1000원 단위여야 합니다,");
    }

}
