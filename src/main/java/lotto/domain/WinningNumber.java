package lotto.domain;

import lotto.setting.Setting;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    private Lotto lotto;

    // 당첨 번호 생성 기능
    public void inputWinningNumber(String input) throws IllegalArgumentException {
        validateInput(input);
        List<Integer> numbers = stringToWinningNumber(input);
        this.lotto = new Lotto(numbers);
    }

    // 올바른 당첨 번호 입력값인지 검증하는 기능
    private void validateInput(String input) throws IllegalArgumentException {
        validateFiveComma(input);
    }

    // 쉼표(,)가 5개인지 확인하는 기능
    private void validateFiveComma(String input) throws IllegalArgumentException {
        int commaCount = 0;
        for (int index = 0; index < input.length(); index++) {
            if (isComma(input.charAt(index))) {
                commaCount += 1;
            }
        }
        if (commaCount != Setting.INPUT_WINNING_NUMBER_COMMA_COUNT) {
            throw new IllegalArgumentException("[ERROR] 6자리 수를 5개의 쉼표(,)로 구분해야 합니다.");
        }
    }

    // 쉼표(,)인지 확인하는 기능
    private boolean isComma(char digit) throws IllegalArgumentException {
        return digit == Setting.SPLIT_CHARACTER;
    }
    
    // 쉼표(,)로 나눈 6개의 문자를 숫자로 변환하는 기능
    private List<Integer> stringToWinningNumber(String input) throws IllegalArgumentException {
        List<Integer> list = new ArrayList<>();
        String[] numbers = input.split(String.valueOf(Setting.SPLIT_CHARACTER));
        for (String number : numbers) {
            checkNumber(number);
            list.add(Integer.parseInt(number));
        }
        return list;
    }

    // 문자열이 숫자인지 검증
    private void checkNumber(String number) throws IllegalArgumentException {
        checkBlank(number);
        for (int index = 0; index < number.length(); index++) {
            if (!Character.isDigit(number.charAt(index))) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
            }
        }
    }

    // 문자열이 공백인지 검증
    private void checkBlank(String number) throws IllegalArgumentException {
        if (number.equals("")) {
            throw new IllegalArgumentException("[ERROR] 공백을 입력할 수 없습니다.");
        }
    }
}
