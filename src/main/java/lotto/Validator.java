package lotto;

import static lotto.NumberType.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Validator {

    public static boolean isValidatePurchaseMoney(String string) {
        try {
            checkEmpty(string);
            isValidateInteger(string);
            checkThousandsDivided(string);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException(e);
        }
        return true;
    }

    public static boolean isValidateWinningMoney(String Input) {
        checkEmpty(Input);
        String WinningMoneys[] = Input.split(",");
        ArrayList<Integer> moneys = new ArrayList<>();
        try {
            for (String WinningMoney : WinningMoneys) {
                isValidateInteger(WinningMoney);
                isValidateNumberRange(Integer.parseInt(WinningMoney));
                moneys.add(Integer.parseInt(WinningMoney));
            }
            isDuplicated(moneys);
            isValidateNumberLength(moneys);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException(e);
        }
        return true;
    }

    public static boolean isValidateBonusMoney(String Input) {
        try {
            checkEmpty(Input);
            isValidateInteger(Input);
            isValidateNumberRange(Integer.parseInt(Input));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
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
    public static void checkEmpty(String Input) throws IllegalArgumentException {
        if (Input.isEmpty())
        {
            throw new IllegalArgumentException("[ERROR] 입력한 값이 공백입니다.");
        }
    }
    public static void isValidateInteger(String Input) throws IllegalArgumentException {
        try {
            Integer.parseInt(Input);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 입력한 값이 올바른 숫자가 아닙니다.");
        }
    }

    public static void isValidateNumberRange(int number) throws IllegalArgumentException{
        if (!(NUMBER_START.getNumber() <= number && number <= NUMBER_END.getNumber())) {
            throw new IllegalArgumentException("[ERROR] 숫자 범위가 유효하지 않습니다.");
        }
    }

    public static void isValidateNumberLength(List<Integer> Input) throws IllegalArgumentException {
        if (Input.size() < NUMBER_COUNT.getNumber()) {
            throw new IllegalArgumentException("[ERROR] 숫자 개수가 적습니다.");
        }
        if (Input.size() > NUMBER_COUNT.getNumber()) {
            throw new IllegalArgumentException("[ERROR] 숫자 개수가 많습니다.");
        }
    }

    public static void isDuplicated(List<Integer> Input) throws IllegalArgumentException {
        HashSet<Integer> duplicateTest = new HashSet<>();
        for (int i = 0; i < Input.size(); i++) {
            duplicateTest.add(Input.get(i));
        }
        if (duplicateTest.size() != Input.size()) {
            throw new IllegalArgumentException("[ERROR] 숫자가 중복되었습니다.");
        }
    }
}
