package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Profit;

import java.util.List;

public class OutputView {
    public final static String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public final static String TICKET_NUMBER_MESSAGE = "개를 구매했습니다.";
    public final static String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    public final static String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    public final static String LOTTO_RESULT_MESSAGE = "당첨 통계\n---";
    public final static String LOTTO_FIFTH_INTRODUCE_MESSAGE = "3개 일치 (5,000원) - ";
    public final static String LOTTO_FOURTH_INTRODUCE_MESSAGE = "4개 일치 (50,000원) - ";
    public final static String LOTTO_THIRD_INTRODUCE_MESSAGE = "5개 일치 (1,500,000원) - ";
    public final static String LOTTO_SECOND_INTRODUCE_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    public final static String LOTTO_FIRST_INTRODUCE_MESSAGE = "6개 일치 (2,000,000,000원) - ";
    public final static String LOTTO_COUNT_MESSAGE = "개";
    public final static String PROFIT_INTRODUCE_MESSAGE = "총 수익률은 ";
    public final static String PROFIT_PERCENT_MESSAGE = "%입니다.";

    private void printlnMessage(String message) {

        System.out.println(message);
    }

    private void printMessage(String message) {

        System.out.print(message);
    }

    public static void printError(String error) {

        System.out.println(error);
    }

    public void printInputPurchaseAmount() {

        printlnMessage(INPUT_PURCHASE_AMOUNT_MESSAGE);
    }

    public void printTicketNumber(int ticketNumber) {

        printlnMessage(ticketNumber + TICKET_NUMBER_MESSAGE);
    }

    public void printInputWinningNumber() {

        printlnMessage(INPUT_WINNING_NUMBER_MESSAGE);
    }

    public void printInputBonusNumber() {
        printlnMessage(INPUT_BONUS_NUMBER_MESSAGE);
    }

    public void printLottoList(List<Lotto> lottoList) {
        for (int i = 0; i < lottoList.size(); i++) {
            printLotto(lottoList.get(i));
        }
    }

    public void printLotto(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        printMessage("[");
        printList(lottoNumbers);
        printMessage("]\n");
    }

    public void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            printMessage(list.get(i).toString());
            if (i != list.size() - 1) {
                printMessage(", ");
            }
        }
    }

    public void printResult(LottoResult lottoResult) {
        printlnMessage(LOTTO_RESULT_MESSAGE);
        printlnMessage(LOTTO_FIFTH_INTRODUCE_MESSAGE + lottoResult.getFifth() + LOTTO_COUNT_MESSAGE);
        printlnMessage(LOTTO_FOURTH_INTRODUCE_MESSAGE + lottoResult.getFourth() + LOTTO_COUNT_MESSAGE);
        printlnMessage(LOTTO_THIRD_INTRODUCE_MESSAGE + lottoResult.getThird() + LOTTO_COUNT_MESSAGE);
        printlnMessage(LOTTO_SECOND_INTRODUCE_MESSAGE + lottoResult.getSecond() + LOTTO_COUNT_MESSAGE);
        printlnMessage(LOTTO_FIRST_INTRODUCE_MESSAGE + lottoResult.getFirst() + LOTTO_COUNT_MESSAGE);
    }

    public void printProfit(Profit profit) {
        printlnMessage(PROFIT_INTRODUCE_MESSAGE + profit.getProfitValue() + PROFIT_PERCENT_MESSAGE);
    }

}
