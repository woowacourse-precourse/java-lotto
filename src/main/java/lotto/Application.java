package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {


    static long purchaseAmount = 0;
    static int numberOfTickets = 0;


    public static void inputPurchaseAmount() {

        String strAmount = Console.readLine();
        long amount = Long.parseLong(strAmount);

        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("1000의 배수만 입력 가능합니다.");
        }
        purchaseAmount = amount;
        numberOfTickets = (int) amount / 1000;
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현

        inputPurchaseAmount();

    }
}
