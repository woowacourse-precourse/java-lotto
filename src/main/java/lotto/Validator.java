package lotto;

import static lotto.NumberType.*;

import java.util.HashSet;

public class Validator {

    public static boolean isValidatePurchaseMoney(String string) {
        try {
            isValidateInteger(string);
            checkThousandsDivided(string);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
        return true;
    }

    public static boolean isValidateWinningMoney(String Input) {
        String WinningMoneys[] = Input.split(",");
        try {
            for (String WinningMoney : WinningMoneys) {
                isValidateInteger(WinningMoney);
                isValidateNumberRange(WinningMoney);
                isValidateNumberLength(WinningMoneys);
                isDuplicated(WinningMoneys);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
        return true;
    }

    public static boolean isValidateBonusMoney(String Input) {
        try {
            isValidateInteger(Input);
            isValidateNumberRange(Input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
        return true;
    }

    public static void checkThousandsDivided(String Input) throws IllegalArgumentException {
        int number = Integer.parseInt(Input);
        if (number % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액이 1000으로 나누어 떨어지지 않습니다");
        }
    }
    public static void isEmpty(String Input) throws IllegalArgumentException {
        if (Input.isEmpty())
            throw new IllegalArgumentException("[ERROR] 입력한 값이 공백입니다.");
    }
    public static void isValidateInteger(String Input) throws IllegalArgumentException {
        try {
            Integer.parseInt(Input);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 입력한 값이 올바른 숫자가 아닙니다.");
        }
    }

    public static void isValidateNumberRange(String Input) throws IllegalArgumentException{
        int number = Integer.parseInt(Input);
        if (!(NUMBER_START.getNumber() <= number && number <= NUMBER_END.getNumber())) {
            throw new IllegalArgumentException("[ERROR] 숫자 범위가 유효하지 않습니다.");
        }
    }

    public static void isValidateNumberLength(String[] Input) throws IllegalArgumentException {
        if (Input.length < NUMBER_COUNT.getNumber()) {
            throw new IllegalArgumentException("[ERROR] 숫자 개수가 적습니다.");
        }
        if (Input.length > NUMBER_COUNT.getNumber()) {
            throw new IllegalArgumentException("[ERROR] 숫자 개수가 많습니다.");
        }
    }

    public static void isDuplicated(String[] Input) throws IllegalArgumentException {
        HashSet<Integer> duplicateTest = new HashSet<>();
        System.out.println(Input.length+ " " + duplicateTest.size());
        for (int i = 0; i < Input.length; i++) {
            duplicateTest.add(Integer.parseInt(Input[i]));
        }
        if (duplicateTest.size() != Input.length) {
            throw new IllegalArgumentException("[ERROR] 숫자가 중복되었습니다.");
        }
    }
}
