package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class BonusNumber {

    public int inputBonusNumber() {
        String input = Console.readLine();
        validateNumber(input);
        validateNumberRange(Integer.parseInt(input));
        return Integer.parseInt(input);
    }

    private void validateNumberRange(int number) {
        if ((number < Constant.MIN_NUMBER) || (number > Constant.MAX_NUMBER)) {
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