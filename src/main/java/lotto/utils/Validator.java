package lotto.utils;

public class Validator {
    public static void checkNumber(String stringLiteral) {
        String isNumberRegExpression = "^[0-9]+$";
        boolean isNotNumber = !(stringLiteral.matches(isNumberRegExpression));
        if (isNotNumber) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    public static void checkMoney(String stringLiteral) {
        String isMoneyRegExpression = "^[1-9]+[0-9]*000$";
        boolean isNotMoney = !(stringLiteral.matches(isMoneyRegExpression));
        if (isNotMoney) {
            throw new IllegalArgumentException("천 단위(1000)의 금액을 입력해주세요.");
        }
    }
}
