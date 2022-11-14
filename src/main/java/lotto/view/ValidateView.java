package lotto.view;

public class ValidateView {
    // test: test/java/lotto/view/ValidateViewTest
    public static int possibleNumber(String number) throws IllegalArgumentException {
        int num;
        try {
            num = Integer.parseInt(number);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return num;
    }

    // test: test/java/lotto/view/ValidateViewTest
    public static boolean isPossibleMoney(int money) throws IllegalArgumentException {
        if(money / 1000 == 0) {
            throw new IllegalArgumentException();
        }

        if(money % 1000 != 0) {
            throw new IllegalArgumentException();
        }

        return true;
    }

    public static boolean isPossibleBonusNumber(int num) throws IllegalArgumentException {
        if(num < 1 || num > 45) {
            throw new IllegalArgumentException();
        }

        return true;
    }
}
