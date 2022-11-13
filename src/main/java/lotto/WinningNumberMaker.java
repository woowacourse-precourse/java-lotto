package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class WinningNumberMaker {
    private String winningNumberInput;
    private String[] inputSplitByComma;
    private List<Integer> winningNumbers;

    void makeWinningNumbers() {
        requestWinningNumber();
        getWinningNumberInput();
        divideByComma();
        validateInputSplitByComma();
        saveWinningNumbers();
    }

    void requestWinningNumber() {
        System.out.println(Messages.ENTER_WINNING_NUMBER.message);
    }

    void getWinningNumberInput() {
        this.winningNumberInput = Console.readLine();
    }

    void divideByComma() {
        this.inputSplitByComma = this.winningNumberInput.split(",");
    }

    String[] showInputSplitByComma() {
        return this.inputSplitByComma;
    }

    void validateInputSplitByComma() {
        if (this.inputSplitByComma.length != 6) {
            throw new IllegalArgumentException();
        }
        for (String winningNumberStr : inputSplitByComma) {
            validateWinningNumberStr(winningNumberStr);
        }
    }

    void validateWinningNumberStr(String winningNumberStr) {
        for (int i = 0; i < winningNumberStr.length(); i++) {
            if (!Character.isDigit(winningNumberStr.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
        int winningNumber = Integer.parseInt(winningNumberStr);
        if (winningNumber < 1 || winningNumber > 45) {
            throw new IllegalArgumentException();
        }
    }

    void saveWinningNumbers() {
        this.winningNumbers = new ArrayList<>();
        for (String winningNumberStr : inputSplitByComma) {
            this.winningNumbers.add(Integer.parseInt(winningNumberStr));
        }
    }

    List<Integer> showWinningNumbers() {
        return new ArrayList<>(this.winningNumbers);
    }
}
