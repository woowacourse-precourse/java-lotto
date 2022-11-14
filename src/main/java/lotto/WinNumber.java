package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class WinNumber {

    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 45;
    static final int WIN_NUMBER_SIZE = 6;

    private List<Integer> winNumbers = new ArrayList<>();
    private Integer bonusNumber = 0;
    // 겹치는 숫자를 입력했을 때, 예외 발생시키기!
    public void enterWinNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        getWinNumbers(Console.readLine());
    }

    public void enterBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        getBonusNumber(Console.readLine());
    }


    public void getWinNumbers(String input) {
        String[] numbers = input.split(",");
        validateWinNumbers(numbers);
    }

    public void getBonusNumber(String input) {
        validateBonusNumber(input);
        this.bonusNumber = Integer.valueOf(input);
    }

    void validateWinNumbers(String[] numbers) {
        if (numbers.length != WIN_NUMBER_SIZE) {
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
        return num < MIN_NUMBER || MAX_NUMBER < num;
    }

    public boolean isNotNumeric(String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            return true;
        }
        return false;
    }
}
