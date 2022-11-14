package lotto;

public class PrintInputMoneyGenerator {
    public static int printInputMoney() {
        int inputMoney;

        try {
            inputMoney = InputUserMoney.InputMoney();
        } catch (IllegalArgumentException e) {
            throw e;
        }

//        boolean divideBoolean = DivideInputMoneyGenerator.divideInputMoney(inputMoney);

        boolean divideBoolean;
        try {
            divideBoolean = DivideInputMoneyGenerator.divideInputMoney(inputMoney);
        } catch (IllegalArgumentException e) {
            throw e;
        }

//        if(!divideBoolean) {
//            throw new IllegalArgumentException("[ERROR] 값을 잘못 입력하셨습니다.");
//        }

        inputMoney /= 1000;
        System.out.printf("%d개를 구매했습니다.\n", inputMoney);

        return inputMoney;
    }
}
