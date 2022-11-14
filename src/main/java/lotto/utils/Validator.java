package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Validator {
    public static void checkNumber(String stringLiteral) {
        String isNumberRegularExpression = "^[0-9]+$";
        boolean isNotNumber = !(stringLiteral.matches(isNumberRegularExpression));
        if (isNotNumber) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    public static void checkMoney(String stringLiteral) {
        String isMoneyRegularExpression = "^[1-9]+[0-9]*000$";
        boolean isNotMoney = !(stringLiteral.matches(isMoneyRegularExpression));
        if (isNotMoney) {
            throw new IllegalArgumentException("천 단위(1000)의 금액을 입력해주세요.");
        }
    }

    public static void checkLottoFormat(String stringLiteral) {
        String isLottoFormatRegularExpression =
                "^([1-9]|[1-3][0-9]|4[0-5]),"
                + "(([1-9]|[1-3][0-9]|4[0-5]),){4}"
                + "([1-9]|[1-3][0-9]|4[0-5])$";
        boolean isNotLottoNumbers = !(stringLiteral.matches(isLottoFormatRegularExpression));
        if (isNotLottoNumbers) {
            throw new IllegalArgumentException("1부터 45까지의 6개의 숫자로 이루어져있으며 구분자는 쉼표(,)입니다.");
        }
    }

    public static void checkBonusNumber(String stringLiteral) {
        String isBonusNumberRegularExpression = "^([1-9]|[1-3][0-9]|4[0-5])$";
        boolean isNotBonusNumber = !(stringLiteral.matches(isBonusNumberRegularExpression));
        if (isNotBonusNumber) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45까지의 숫자입니다.");
        }
    }

    public static void checkDuplicate(String rawAnswerInput) {
        String[] numbers = rawAnswerInput.split(",");
        List<String> collect = Arrays.stream(numbers)
                .distinct()
                .collect(Collectors.toList());
        if (collect.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 중복 될 수 없습니다.");
        }
    }
}
