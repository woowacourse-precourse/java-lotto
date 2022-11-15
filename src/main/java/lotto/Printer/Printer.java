package lotto.Printer;

import java.util.List;

public class Printer {
    private static final String PURCHASE_AMOUNT_REQUEST_MESSAGE = "구매금액을 입력해 주세요.";
    private static final String PURCHASE_MESSAGE = "%개를 구매했습니다.";
    private static final String LOTTO_NUMBER_REQUEST_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_REQUEST_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String DIVIDING_LINE = "---";
    private static final String FIFTH_PLACE_MESSAGE = "3개 일치 (5,000원) - %d개";
    private static final String FOURTH_PLACE_MESSAGE = "4개 일치 (50,000원) - %d개";
    private static final String THIRD_PLACE_MESSAGE = "5개 일치 (1,500,000원) - %d개";
    private static final String SECOND_PLACE_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    private static final String FIRST_PLACE_MESSAGE = "6개 일치 (2,000,000,000원) - %d개";
    private static final String EARNING_RATE_MESSAGE = "총 수익률은 %f%%입니다.";

    public void requestPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_REQUEST_MESSAGE);
    }

    public void printPurchaseMessage(int numberOfLottos) {
        System.out.printf(PURCHASE_MESSAGE, numberOfLottos);
    }

    public void printIssuedLottoNumber(List<Integer> LottoNumber) {
        System.out.println(LottoNumber);
    }

    public void requestLottoNumber() {
        System.out.println(LOTTO_NUMBER_REQUEST_MESSAGE);
    }

    public void requestBonusNumber() {
        System.out.println(BONUS_NUMBER_REQUEST_MESSAGE);
    }

    public void printWinningStatistics() {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(DIVIDING_LINE);
        System.out.println(FIFTH_PLACE_MESSAGE);
        System.out.println(FOURTH_PLACE_MESSAGE);
        System.out.println(THIRD_PLACE_MESSAGE);
        System.out.println(SECOND_PLACE_MESSAGE);
        System.out.println(FIRST_PLACE_MESSAGE);
        System.out.println(EARNING_RATE_MESSAGE);
    }

}
