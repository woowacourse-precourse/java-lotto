package lotto.validation;

import java.util.List;

public class Validator {

    public static void validateStringIsNumeric(String input) {
        if (!input.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new IllegalArgumentException("[ERROR] input이 숫자가 아닙니다.");
        }
    }

    public static void validatePriceRange(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("[ERROR] 음수값은 입력하실 수 없습니다.");
        }
    }

    public static void validateUnit(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위의 값을 입력해야합니다.");
        }
    }

    public static void validateSize(List<Integer> list, int size) {
        if (list.size() != size) {
            throw new IllegalArgumentException(String.format("[ERROR] 사이즈가 {}이 아닙니다.", size));
        }
    }

    public static void validateNumbersRange(List<Integer> numbers, int startRange, int endRange) {
        for (Integer number : numbers) {
            validateNumberRange(number, startRange, endRange);
        }
    }

    public static void validateNumberRange(int number, int startRange, int endRange) {
        if (number < startRange || number > endRange) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] {} ~ {} 사이의 입력이 아닙니다.", startRange, endRange));
        }
    }

    public static void validateNonDuplicatedList(List<Integer> lst){
        if(lst.size() != lst.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] 로또 번호 내에 중복된 값이 있습니다.");
        }
    }

    public static void validateNonDuplicatedBonusNumber(WinningLotto winningLotto, int bonus) {
        if (winningLotto.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복된 보너스 번호를 입력하였습니다.");
        }
    }
}
