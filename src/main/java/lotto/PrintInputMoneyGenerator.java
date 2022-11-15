package lotto;

public class PrintInputMoneyGenerator {
    public static int printInputMoney() {
        int inputMoney = 0;

        try {
            inputMoney = InputUserMoney.InputMoney();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 구매금액은 숫자여야합니다.");
        }

        try {
            boolean divideBoolean = DivideInputMoneyGenerator.divideInputMoney(inputMoney);
        } catch (IllegalArgumentException e) {
            throw e;
        }

        inputMoney /= 1000;
        System.out.printf("%d개를 구매했습니다.\n", inputMoney);

        return inputMoney;
    }
}
