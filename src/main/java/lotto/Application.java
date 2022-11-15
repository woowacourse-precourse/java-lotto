package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final LottoStore lottoStore = new LottoStore();

    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해주세요.";
    private static final String AMOUNT_OUTPUT_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.2f%%입니다.\n";


    public static void main(String[] args) {
        try {
            Integer amount = getAmountInput(PURCHASE_AMOUNT_INPUT_MESSAGE);

            Integer numOfLotto = lottoStore.calcLottoNumbers(amount);
            // 출력
            System.out.printf(AMOUNT_OUTPUT_MESSAGE, numOfLotto);

            List<Lotto> lottos = lottoStore.issueLottos(numOfLotto);
            // 출력
            for (Lotto lotto : lottos) {
                System.out.println(lotto);
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // TODO: 프로그램 구현
    }


    private static Lotto noticeWinningLottoInputMessage() {
        String input = Console.readLine();
        String[] winningLottoInput = input.split(",");

        List<Integer> winingLottoNumbers = new ArrayList<>();

        for (int i = 0; i < 6; i++) { // 수정해야함.
            Integer number = Integer.parseInt(winningLottoInput[i]);
            winingLottoNumbers.add(number);
        }

        return new Lotto(winingLottoNumbers);
    }

    private static Integer getAmountInput(String message) throws IllegalArgumentException {
        printNotifyMessage(message);
        String amountInput = Console.readLine();

        Integer amount = validateAmountInput(amountInput);

        return amount;
    }

    private static void printNotifyMessage(String message) {
        System.out.println(message);
    }

    private static Integer validateAmountInput(String amountInput) throws IllegalArgumentException {

        try {
            Integer amount = Integer.parseInt(amountInput);
            return amount;

        } catch (NumberFormatException e) {

            throw new IllegalArgumentException("[ERROR]");
        }

    }
}
