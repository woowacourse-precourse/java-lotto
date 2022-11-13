package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BonusNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public int inputBonusNumber() {
        String input = Console.readLine();
        validateNumber(input);
        validateNumberRange(Integer.parseInt(input));
        return Integer.parseInt(input);
    }

    private void validateNumberRange(int number) {
        if ((number < MIN_NUMBER) || (number > MAX_NUMBER)) {
            throw new IllegalArgumentException("[ERROR] 입력된 로또 보너스 번호가 1 ~ 45 사이가 아닙니다.");
        }
    }

    private void validateNumber(String price) {
        for (char c : price.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("[ERROR] 입력된 로또 보너스 번호가 숫자가 아닙니다.");
            }
        }
    }

}