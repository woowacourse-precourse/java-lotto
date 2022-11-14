package lotto.view;

public class ValidateView {
    public static int isPossibleNumber(String number) throws IllegalArgumentException {
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
        // 숫자형태가 아닌 로직 처리
        if(money / 1000 == 0) {
            throw new IllegalArgumentException();
        }

        if(money % 1000 != 0) {
            throw new IllegalArgumentException();
        }

        return true;
    }
}
