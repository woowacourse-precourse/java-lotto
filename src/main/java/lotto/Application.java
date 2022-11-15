package lotto;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int numberOfLotto = getTheNumberOfLotto();

    }

    public static int getTheNumberOfLotto() {
        String money = Console.readLine();
        validate(money);
        int numberOfLotto = Integer.parseInt(money) / 1000;

        return numberOfLotto;
    }

    public static void validate(String money) {
        if (validateMoneyType(money) || validateMoneyRange(money)) {
            System.out.println("[ERROR] 구매 금액은 1000원 단위로 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static boolean validateMoneyType(String money) {
        // 오류가 있으면 true
        for (char c : money.toCharArray()) {
            if (!Character.isDigit(c)) {
                return true;
            }
        }

        return false;
    }

    public static boolean validateMoneyRange(String money) {
        // 오류가 있으면 true
        if(Integer.parseInt(money) % 1000 != 0) {
            return true;
        }

        return false;
    }

}
