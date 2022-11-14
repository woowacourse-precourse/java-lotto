package lotto.view;

public class ValidateView {
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
}
