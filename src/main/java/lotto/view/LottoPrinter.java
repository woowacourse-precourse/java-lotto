package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import lotto.domain.LottoRank;

public class LottoPrinter {
    public static final String INVALID_PURCHASE_AMOUNT_ERROR = "[ERROR] 구매 금액은 1,000원 단위로 입력해주세요.";
    public static final String INVALID_PURCHASE_PATTERN_ERROR = "[ERROR] 구매 금액에 숫자만 입력해주세요.";
    public static final String WINNING_NUMBERS_REPETITION_ERROR = "[ERROR] 중복되지 않는 번호를 입력해주세요.";
    public static final String WINNING_NUMBERS_PATTERN_ERROR = "[ERROR] 입력 형식에 맞게 숫자를 입력해주세요.";
    public static final String WINNING_NUMBER_RANGE_ERROR = "[ERROR] 1~45 범위 내의 숫자를 입력해주세요.";

    public static final int PERCENT_CONSTANT = 100;

    public void printPurchaseAmountMessage() {
        final String inputAmountMessage = "구입금액을 입력해 주세요.";
        System.out.println(inputAmountMessage);
    }

    public void printLottoNumbers(List<Integer> lottoNumber) {
        System.out.println(lottoNumber);
    }

    public void printPurchaseCompletionMessage(int lottoCount) {
        final String purchaseMessage = "개를 구매했습니다.";
        System.out.println(lottoCount + purchaseMessage);
    }

    public void printGetWinningNumberMessage() {
        final String inputWinningNumberMessage = "당첨 번호를 입력해 주세요.";
        System.out.println();
        System.out.println(inputWinningNumberMessage);
    }

    public void printGetBonusNumberMessage() {
        final String inputBonusNumberMessage = "보너스 번호를 입력해 주세요.";
        System.out.println();
        System.out.println(inputBonusNumberMessage);
    }

    public void printStatisticMessage() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void printWinningResult(LottoRank lottoRank) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        System.out.print(lottoRank.getNormalCount() + "개 일치");
        if (lottoRank.name() == "SECOND") {
            System.out.print(", 보너스 볼 일치");
        }
        String winningPriceFormatted = decimalFormat.format(lottoRank.getWinningPrice());
        System.out.print(" (" + winningPriceFormatted + "원)");
        System.out.print(" - " + lottoRank.getWinningCount() + "개");
        System.out.println();
    }

    public void printProfit(double totalProfit) {
        double totalProfitPercent = totalProfit * PERCENT_CONSTANT;
        System.out.print("총 수익률은 ");
        System.out.print(String.format("%.1f", totalProfitPercent));
        System.out.print("%입니다.");
    }



    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }




}
