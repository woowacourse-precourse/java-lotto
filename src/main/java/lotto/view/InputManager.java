package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputManager {
    private static final String INPUT_MESSAGE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_MESSAGE_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_MESSAGE_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String ERROR_MESSAGE_NOT_PROPER_AMOUNT = "[ERROR] 구입 금액은 1000원 단위로 입력할 수 있습니다.";

    private static final String ERROR_MESSAGE_NOT_PROPER_WINNING_NUMBER_COUNT = "[ERROR] 6개의 숫자를 입력해야 합니다.";


    private InputManager() {
    }

    public int readPurchaseAmount() {
        printInputMessagePurchaseAmount();

        String inputAmount = Console.readLine();
        int intAmount = convertIntoIntAmount(inputAmount);
        validateInputAmount(intAmount);
        return intAmount;
    }

    public List<Integer> readWinningNumber() {
        printInputMessageWinningNumber();

        String inputFormat = Console.readLine();
        validateInputWinningNumber(inputFormat);

        List<Integer> winningNums = ConvertToIntegerList(inputFormat);

        return winningNums;
    }

    private List<Integer> ConvertToIntegerList(String inputFormat) {
        String[] inputNums = inputFormat.split(",");

        List<Integer> winningNums = new ArrayList<>();
        for (String num : inputNums) {
            winningNums.add(Integer.parseInt(num));
        }
        return winningNums;
    }

    private void validateInputWinningNumber(String input) {
        validateStringContainFiveComma(input);
    }
    private void validateStringContainFiveComma(String input) {
        final int expectCommaCount = 5;

        int commaCount = input.length() - input.replace(String.valueOf(','), "").length();

        if (expectCommaCount != commaCount) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_PROPER_WINNING_NUMBER_COUNT);
        }
    }

    public static int countChar(String str, char ch) {
        return str.length() - str.replace(String.valueOf(ch), "").length();
    }

    private int convertIntoIntAmount(String inputAmount) {
        int intAmount;
        try {
            intAmount = Integer.parseInt(inputAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return intAmount;
    }

    private void validateInputAmount(int inputAmount) {
        if (inputAmount < 1000) {
            throw new IllegalArgumentException();
        }
        if (inputAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void printInputMessagePurchaseAmount() {
        System.out.println(INPUT_MESSAGE_PURCHASE_AMOUNT);
    }
    private void printInputMessageWinningNumber() {
        System.out.println(INPUT_MESSAGE_WINNING_NUMBER);
    }
    private void printInputMessageBonusNumber() {
        System.out.println(INPUT_MESSAGE_BONUS_NUMBER);
    }


}
