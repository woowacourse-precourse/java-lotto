package lotto;

import java.util.Hashtable;

public enum LottoPrint {
    purchaseAmount("구입금액을 입력해 주세요."),
    winningNumbers("당첨 번호를 입력해 주세요."),
    bonusNumber("보너스 번호를 입력해 주세요."),
    boughtLotto("개를 구매했습니다.");
    private final String description;

    LottoPrint(String description){
        this.description = description;
    }

    public static String profitReturn(double totalProfit){
        return "총 수익률은 "+String.format("%.1f%%입니다.",totalProfit);
    }

    public static String winningStatistics(Hashtable<Integer,Integer> counts){
        return "3개 일치 (5,000원) - " + counts.get(3) + "개\n" +
                "4개 일치 (50,000원) - " + counts.get(4) + "개\n" +
                "5개 일치 (1,500,000원) - " + counts.get(5) + "개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + counts.get(7) + "개\n" +
                "6개 일치 (2,000,000,000원) - " + counts.get(6) + "개\n";
    }

    public String getDescription() {
        return description;
    }
}