package lotto;

import java.util.ArrayList;
import java.util.List;

import lotto.message.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;
import lotto.message.Message;

public class WinningNumberMaker {
    private final int START_NUM = 1;
    private final int END_NUM = 45;

    private String winningNumberInput;
    private String bonusNumberInput;
    private String[] inputSplitByComma;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    void make() throws IllegalArgumentException{
        makeWinningNumbers();
        makeBonusNumber();
    }

    void makeWinningNumbers() throws IllegalArgumentException{
        requestWinningNumber();
        getWinningNumberInput();
        divideByComma();
        validateInputSplitByComma();
        saveWinningNumbers();
    }

    void requestWinningNumber() {
        System.out.println(Message.ENTER_WINNING_NUMBER.message);
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
            throw new IllegalArgumentException(ErrorMessage.NOT_ENOUGH_NUM.message);
        }
        for (String winningNumberStr : inputSplitByComma) {
            validateWinningNumberStr(winningNumberStr);
        }
    }

    void validateWinningNumberStr(String winningNumberStr) {
        for (int i = 0; i < winningNumberStr.length(); i++) {
            if (!Character.isDigit(winningNumberStr.charAt(i))) {
                throw new IllegalArgumentException(ErrorMessage.WINNING_NUM_NOT_A_NUMBER.message);
            }
        }
        int winningNumber = Integer.parseInt(winningNumberStr);
        if (winningNumber < 1 || winningNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE.message);
        }
    }

    void saveWinningNumbers() {
        this.winningNumbers = new ArrayList<>();
        for (String winningNumberStr : inputSplitByComma) {
            this.winningNumbers.add(Integer.parseInt(winningNumberStr));
        }
    }

    List<Integer> getWinningNumbers() {
        return new ArrayList<>(this.winningNumbers);
    }

    void makeBonusNumber() throws IllegalArgumentException {
        requestBonusNumber();
        getBonusNumberInput();
        validateBonusNumberInput();
        saveBonusNumber();
        validateBonusNumber();
    }

    void requestBonusNumber() {
        System.out.println(Message.ENTER_BONUS_NUMBER.message);
    }

    void getBonusNumberInput() {
        this.bonusNumberInput = Console.readLine();
    }

    void validateBonusNumberInput() {
        this.bonusNumberInput.chars().forEach(c -> {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(ErrorMessage.BONUS_NUM_NOT_A_NUMBER.message);
            }
        });
    }

    void saveBonusNumber() {
        this.bonusNumber = Integer.parseInt(this.bonusNumberInput);
    }

    void validateBonusNumber() {
        if (!(START_NUM <= this.bonusNumber && this.bonusNumber <= END_NUM)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE.message);
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUM_CONTAINS_BONUS_NUM.message);
        }
    }

    int getBonusNumber(){
        return bonusNumber;
    }
}
