package lotto.model;

import lotto.Constant;

import java.util.HashSet;
import java.util.List;

public class input_numbers {
    private void check_divisible(int num) {
        if (num % Constant.LOTTO_PRICE.getNum() != 0) {
            throw new IllegalArgumentException("[ERROR] 입력된 금액이 1000원 단위로 떨어지지 않습니다.");
        }
    }

    private void check_Duplicate(List<Integer> numbers) {
        HashSet set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복이 발생하였습니다.");
        }
    }

    private void check_Cnt(List<Integer> numbers) {
        if (numbers.size() != Constant.LOTTO_NUMBER_CNT.getNum()) {
            throw new IllegalArgumentException("[ERROR] 정해진 로또번호의 개수가 입력되지 않았습니다.");
        }
    }

    private void check_Negative(int target) {
        if (target < 0) {
            throw new IllegalArgumentException("[ERROR] 음수가 입력되었습니다.");
        }
    }

    private void check_Range(int target) {
        if (target < 1 || target > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void check_BounsInWinNumber(int bonusNumber, List<Integer> select_Number) {
        if (select_Number.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 입력된 보너스 번호가 당첨 번호와 중복되었습니다.");
        }
    }

    private void check_VoidOrSpace(String num) {
        if (num.equals("") || num.equals(" ")) {
            System.out.println("[ERROR] 정수가 아님");
            throw new IllegalArgumentException("[ERROR] 정수가 아닌 빈 공백이 입력되거나 아무것도 입력되지 않은 것이 존재합니다.");
        }
    }

    private int change_StrToInt(String input_Line) {
        try {
            return Integer.parseInt(input_Line);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수가 아닌 문자 혹은 실수가 입력되었습니다.");
        }
    }
}
