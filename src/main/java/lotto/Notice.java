package lotto;

import java.util.List;

public class Notice {
    public static final String PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    public static final String PURCHASE_NUMBER = "개를 구매했습니다.";
    public static final String WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String WINNING_ANALYSIS = "당첨 통계";

    public void purchasePrice() {
        System.out.println(PURCHASE_PRICE);
    }

    public void purchaseNumber() {
        System.out.println(PURCHASE_NUMBER);
    }

    public void winningNumber() {
        System.out.println(WINNING_NUMBER);
    }

    public void bonusNumber() {
        System.out.println(BONUS_NUMBER);
    }

    public void winningAnalysis() {
    }

    public void profitRatio(float profitRatio) {
        System.out.print("총 수익률은 " + String.format("%.1f", profitRatio) + "%입니다.");
    }
}
