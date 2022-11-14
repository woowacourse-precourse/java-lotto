package lotto;

public class PrintInputMoneyGenerator {
    public static int printInputMoney() {
        int inputMoney = InputUserMoney.InputMoney();
        boolean divideBoolean = DivideInputMoneyGenerator.divideInputMoney(inputMoney);
        if(!divideBoolean) {
            throw new IllegalArgumentException();
        }
        inputMoney /= 1000;
        System.out.printf("%d개를 구매했습니다.\n", inputMoney);

        return inputMoney;
    }
}
