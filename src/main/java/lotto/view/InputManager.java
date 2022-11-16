package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import lotto.util.InputValidate;

public class InputManager {
    private static final String INPUT_MESSAGE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_MESSAGE_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_MESSAGE_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private final InputValidate inputValidate = new InputValidate();

    private List<Integer> winningNums;

    public InputManager() {
    }

    public int readPurchaseAmount() {
        printInputMessagePurchaseAmount();

        String inputAmount = Console.readLine();
        inputValidate.validateInputAmount(inputAmount);

        System.out.println();

        return convertToInt(inputAmount);
    }

    public List<Integer> readWinningNumber() {
        printInputMessageWinningNumber();

        String inputFormat = Console.readLine();
        inputValidate.validateInputWinningNumber(inputFormat);

        winningNums = convertToIntegerList(inputFormat);

        System.out.println();

        return winningNums;
    }

    public int readBonusNumber() {
        printInputMessageBonusNumber();

        String inputNumber = Console.readLine();
        inputValidate.validateInputBonusNumber(inputNumber);
        inputValidate.validateBonusNumberNotDuplicate(winningNums, inputNumber);

        System.out.println();

        return convertToInt(inputNumber);
    }

    private List<Integer> convertToIntegerList(String inputFormat) {
        String[] inputNums = inputFormat.split(",");

        List<Integer> winningNums = new ArrayList<>();
        for (String num : inputNums) {
            winningNums.add(Integer.parseInt(num));
        }
        return winningNums;
    }

    private int convertToInt(String inputAmount) {
        return Integer.parseInt(inputAmount);
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
