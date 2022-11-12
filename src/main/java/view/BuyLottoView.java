package view;

import java.util.List;

public class BuyLottoView {
    public static void ask() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printNumberOfLotto(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLotteryNumbers(List<Integer> lotteryNumbers) {
        System.out.println(lotteryNumbers);
    }
}
