package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BonusNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public int inputBonusNumber() {
        int input = Integer.parseInt(Console.readLine());
        validateNumber(input);
        return input;
    }

    private void validateNumber(int number) {
        if ((number < MIN_NUMBER) || (number > MAX_NUMBER)) {
            throw new IllegalArgumentException("[ERROR] 입력된 로또 보너스 번호가 1 ~ 45 사이가 아닙니다.");
        }
    }

}