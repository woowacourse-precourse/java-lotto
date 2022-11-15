package lotto.Validator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.Domain.Lotto;

public class LottoValidator {
    public static boolean checkLottoRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45사이의 숫자여야합니다.");
        }
        return true;
    }

    public static void validateBonusNumber(Lotto winningNumber, int bonusNumber) {
        checkBonusContain(winningNumber, bonusNumber);
        checkBonusRange(bonusNumber);
    }

    public static void checkBonusContain(Lotto winningNumber, int bonusNumber) {
        if (winningNumber.isContain(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR} 보너스 번호는 당첨 번호에 포함되어 있지 않아야 합니다.");
        }
    }

    public static void checkBonusRange(int bonusNumber) {
        if (bonusNumber < 1 || 45 < bonusNumber) {
            throw new IllegalArgumentException("[ERROR} 보너스 번호는 1~45사이의 숫자여야 합니다.");
        }
    }

    public static void validateWinningNumber(String input) {
        checkInputForm(input);
        checkNumberCount(input);
    }

    public static void checkInputForm(String input) {
        for(String s : input.split("\\s*,\\s*")){
            try {
                Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR} 쉼표로 구분하여 숫자만 입력해주세요.");
            }
        }
    }

    public static void checkNumberCount(String input) {
        List<Integer> collect = Stream.of(input.split("\\s*,\\s*"))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        if (collect.size() != 6) {
            throw new IllegalArgumentException("[ERROR} 당첨 번호는 6개를 입력해주세요.");
        }
    }
}
