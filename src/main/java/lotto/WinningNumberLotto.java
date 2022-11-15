package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.inputNumber.InputNumber;

import java.util.ArrayList;
import java.util.List;

public class WinningNumberLotto extends Lotto {

    private int bonusNumber;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;


    public WinningNumberLotto() {
        super(InputNumber.createNumber());
        int number = inputBonusNumber();
        setBonusNumber(number);
    }

    public WinningNumberLotto(List<Integer> numbers, int number) {
        super(numbers);
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
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자 하나여야 합니다. -> VALIDATE 조건 추가");
        }
    }

    private void printBonusMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    private boolean checkInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception exception) {
            return false;
        }
        return true;
    }

    private boolean checkSize(String input) {
        int number = Integer.parseInt(input);
        return START_NUMBER <= number && number <= END_NUMBER;
    }
}
