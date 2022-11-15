package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;


public class BonusNumber {
    private int bonusNumber;
    static final int SMALLEST_LOTTO_NUMBER = 1;
    static final int BIGGEST_LOTTO_NUMBER = 45;


    public BonusNumber(List<Integer> numbers) {
        System.out.println("보너스 번호를 입력해주세요");
        String userInput = Console.readLine();
        int convertedInputValue = convertToInt(userInput);
        inRangeValidate(convertedInputValue);
        duplicateLottoValidate(numbers, convertedInputValue);
        setBonusNumber(convertedInputValue);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    private int convertToInt(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자가 아닌 값이 입력되었습니다.");
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 입력되었습니다.");
        }
    }

    private void inRangeValidate(int value) {
        if (value < SMALLEST_LOTTO_NUMBER || value > BIGGEST_LOTTO_NUMBER) {
            System.out.println("[ERROR] 보너스 번호는 1~45의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void duplicateLottoValidate(List<Integer> numbers, int value) {
        if (numbers.contains(value)) {
            System.out.println("[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }

}
