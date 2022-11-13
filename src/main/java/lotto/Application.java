package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static boolean checkInputPurchaseMoney(String inputPurchaseMoney) {
        try {
            Validation.isIncludeNotNumber(inputPurchaseMoney);
            Validation.isMultipleOf1000(inputPurchaseMoney);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    private static boolean checkInputWinNumbers(String inputWinNumbers) {
        try {
            for (String inputWinNumber : inputWinNumbers.split(",")) {
                Validation.isIncludeNotNumber(inputWinNumber);
                Validation.isNumberBetween1And45(Integer.parseInt(inputWinNumber));
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    private static boolean checkWinNumbers(List<Integer> winNumbers) {
        try {
            Validation.isLottoDuplicate(winNumbers);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    private static boolean checkInputBonus(List<Integer> winNumbers, String inputBonus) {
        try {
            Validation.isIncludeNotNumber(inputBonus);
            int bonus = Integer.parseInt(inputBonus);
            Validation.isNumberBetween1And45(bonus);
            Validation.isBonusInLotto(winNumbers, bonus);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}