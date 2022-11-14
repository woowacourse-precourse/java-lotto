package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.inputNumber.InputNumber;

import java.util.ArrayList;

public class WinningNumberLotto extends Lotto {

    private int bonusNumber;

    public WinningNumberLotto() {
        super(InputNumber.createNumber());
        int number = inputBonusNumber();
        setBonusNumber(number);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    private int inputBonusNumber() {
        String input = Console.readLine();
        validateBonusNumber(input);
        return Integer.parseInt(input);
    }

    private void validateBonusNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void printBonusMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
