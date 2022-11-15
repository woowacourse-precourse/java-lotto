package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final LottoStore lottoStore = new LottoStore();
    private static List<Lotto> lottos = new ArrayList();
    private static WinningLotto winningLotto;

    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해주세요.";
    private static final String NUMBER_OF_LOTTOS_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.2f%%입니다.\n";
    private static final String WINNING_STAT_MESSAGE = "당첨 통계\n---";

    public static void main(String[] args) {
        try {
            Integer amount = getAmountInput(PURCHASE_AMOUNT_INPUT_MESSAGE);

            Integer numOfLotto = getNumberOfLotto(amount);

            purchaseLottos(numOfLotto);

            createWinningLotto();

            printNotifyMessage(WINNING_STAT_MESSAGE);

        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    private static Integer getBonusNumber() {
        printNotifyMessage(BONUS_NUMBER_INPUT_MESSAGE);
        String bonusNumberInput = Console.readLine();

        Integer bonusNum = convertibleInputToInt(bonusNumberInput);
        validateNumRange(bonusNum);
        return bonusNum;
    }

    private static Integer getAmountInput(String message) throws IllegalArgumentException {
        printNotifyMessage(message);
        String amountInput = Console.readLine();

        Integer amount = convertibleInputToInt(amountInput);
        System.out.println();
        return amount;
    }

    private static Integer getNumberOfLotto(Integer amount) {
        Integer numOfLotto = lottoStore.calcLottoNumbers(amount);
        printNotifyMessage(NUMBER_OF_LOTTOS_MESSAGE, numOfLotto);

        return numOfLotto;
    }

    private static void purchaseLottos(Integer numOfLotto) {
        lottos = lottoStore.issueLottos(numOfLotto);
        printLottos(lottos);
    }

    private static WinningLotto createWinningLotto() {

        String winningNumberInput = getWinningNumberInput();

        String[] splitNumbers = splitNumberInput(winningNumberInput);

        List<Integer> lottoNumbers = convertToLottoNumbers(splitNumbers);
        Integer bonusNumber = getBonusNumber();

        return new WinningLotto(lottoNumbers, bonusNumber);
    }

    private static String getWinningNumberInput() {
        printNotifyMessage(WINNING_NUMBER_INPUT_MESSAGE);
        String winningNumberInput = Console.readLine();

        validateWinningNumberInput(winningNumberInput);

        return winningNumberInput;
    }

    private static String[] splitNumberInput(String winningNumberInput) {
        String[] splitNumbers = winningNumberInput.split(",");
        validateSplitNumber(splitNumbers);
        return splitNumbers;
    }

    private static List<Integer> convertToLottoNumbers(String[] splitNumbers) {
        List<Integer> numbers = new ArrayList();
        for (String eachNum : splitNumbers) {
            Integer number = convertibleInputToInt(eachNum);
            validateNumRange(number);

            numbers.add(number);
        }

        return numbers;
    }


    private static void validateSplitNumber(String[] splitNumbers) {
        if (splitNumbers.length != 6) {
            throw new IllegalArgumentException("당첨 번호 6개를 정확히 입력해주세요.");
        }
    }


    private static void validateNumRange(Integer num) {
        if (num <= 0) {
            throw new IllegalArgumentException("0이하의 숫자는 당첨번호가 될 수 없습니다.");
        }

        if (num > 45) {
            throw new IllegalArgumentException("45보다 큰 숫자는 당첨번호가 될 수 없습니다.");
        }
    }

    private static Integer convertibleInputToInt(String amountInput) throws IllegalArgumentException {

        try {
            Integer amount = Integer.parseInt(amountInput);
            return amount;

        } catch (NumberFormatException e) {

            throw new IllegalArgumentException("숫자를 입력하세요.");
        }
    }

    private static void validateWinningNumberInput(String winningNumberInput) {
        if (winningNumberInput.isBlank()) {
            throw new IllegalArgumentException("올바른 당첨 번호를 입력해주세요.");
        }

        if (winningNumberInput.length() > 17) {
            throw new IllegalArgumentException("당첨 번호 입력길이를 초과했습니다.");
        }
    }

    private static void printNotifyMessage(String message) {
        System.out.println(message);
    }

    private static void printNotifyMessage(String message, Integer numOfLotto) {
        System.out.printf(message, numOfLotto);
    }

    private static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
