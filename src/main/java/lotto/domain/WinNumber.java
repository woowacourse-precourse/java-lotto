package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class WinNumber {

    private List<Integer> winNumbers = new ArrayList<>();
    private Integer bonusNumber = 0;
    // 겹치는 숫자를 입력했을 때, 예외 발생시키기!
    public void enterWinNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        inputWinNumbers(Console.readLine());
    }

    public void enterBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        inputBonusNumber(Console.readLine());
    }


    public void inputWinNumbers(String input) {
        String[] numbers = input.split(",");
        validateWinNumbers(numbers);
    }

    public void inputBonusNumber(String input) {
        validateBonusNumber(input);
        this.bonusNumber = Integer.valueOf(input);
    }

    void validateWinNumbers(String[] numbers) {
        if (numbers.length != Lotto.WIN_NUMBER_SIZE) {
            throw new IllegalArgumentException(ExceptionHandler.WRONG_WIN_NUMBERS);
        }
        for (String number : numbers) {
            if (isNotNumeric(number) || isNotInRange(number)) {
                throw new IllegalArgumentException(ExceptionHandler.WRONG_WIN_NUMBERS);
            }
            if (winNumbers.contains(Integer.valueOf(number))) {
                throw new IllegalArgumentException(ExceptionHandler.WRONG_WIN_NUMBERS);
            }
            winNumbers.add(Integer.valueOf(number));
        }
    }

    public void validateBonusNumber(String input) {
        if (isNotNumeric(input) || isNotInRange(input) || winNumbers.contains(Integer.valueOf(input))) {
            throw new IllegalArgumentException(ExceptionHandler.WRONG_BONUS_NUMBERS);
        }
    }

    public boolean isNotInRange(String number) {
        int num = Integer.parseInt(number);
        return num < Lotto.MIN_NUMBER || Lotto.MAX_NUMBER < num;
    }

    public boolean isNotNumeric(String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            return true;
        }
        return false;
    }

    public List<Integer> getWinNumbers() {
        return winNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
