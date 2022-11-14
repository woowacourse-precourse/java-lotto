package lotto;

import java.text.DecimalFormat;
import java.util.Map;

public class Notice {
    static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###,###");
    static final String PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    static final String PURCHASE_NUMBER = "개를 구매했습니다.";
    static final String WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    static final String WINNING_ANALYSIS = "당첨 통계";

    public void purchasePrice() {
        System.out.println(PURCHASE_PRICE);
    }

    public void purchaseNumber() {
        User clerk = new User();
        System.out.println(clerk.purchasePrice + PURCHASE_NUMBER);
    }

    public void winningNumber() {
        System.out.println(WINNING_NUMBER);
    }

    public void bonusNumber() {
        System.out.println(BONUS_NUMBER);
    }

    public void winningAnalysis(Map<String, Integer> winningCount) {
        System.out.println(WINNING_ANALYSIS);
        System.out.println("---");
        for(Grade grade : Grade.values()){
            System.out.println(grade.getMatchNumber() + "개 일치" + grade.getBonusBall() + " (" +
                    DECIMAL_FORMAT.format(grade.getPrice()) + "원) - " + winningCount.get(grade.toString()) + "개");
        }
    }

    public void profitRatio(float profitRatio) {
        System.out.print("총 수익률은 " + String.format("%.1f", profitRatio) + "%입니다.");
    }
}
