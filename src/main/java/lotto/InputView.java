package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    private final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";

    private ConversionUtility conversionUtility = new ConversionUtility();

    public int inputMoney() {
        System.out.println(MONEY_INPUT_MESSAGE);
        int purchasingAmount = Integer.parseInt(Console.readLine());

        return purchasingAmount;
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);
        String inputWinningNumbers = Console.readLine();
        List<Integer> winningNumbers = conversionUtility.convertStringWinningNumbersToList(inputWinningNumbers);

        return winningNumbers;
    }
}
