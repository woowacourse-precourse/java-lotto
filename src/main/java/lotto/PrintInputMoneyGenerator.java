package lotto;

public class PrintInputMoneyGenerator {
    public static int printInputMoney() {
        int inputMoney = 0;

        try {
            inputMoney = InputUserMoney.InputMoney();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 구매금액은 숫자여야합니다.");
//            throw e;
            /**
             * throw e 의 역할이 예외를 처리? 하는 역할
             * 예외를 발생시키는 것과 강제로 throw를 통해 발생시키는 것은 다른것 ??
             * 예외 발생 시 로그를 남기고, 프로그램이 종료되는 상황을 생각해보라
             */
        }
//        finally { // 이렇게도 시도해봄 ..
//            System.out.println("[ERROR] 구매금액은 숫자여야 합니다.");
//        }

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
