package lotto;

public class PrintInputMoneyGenerator {
    public static int printInputMoney() {
        int inputMoney;

        try {
            inputMoney = InputUserMoney.InputMoney();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            e.getStackTrace();
            throw e;
        } finally {
            System.out.println("[ERROR] 잘못된 입력");
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
