package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {


    static long purchaseAmount = 0;
    static int numberOfTickets = 0;


    public static void enterPurchaseAmount() {

        String strAmount = Console.readLine();
        long amount = Long.parseLong(strAmount);

        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("1000의 배수만 입력 가능합니다.");
        }
        purchaseAmount = amount;
        numberOfTickets = (int) amount / 1000;
    }


    public static void printNumberOfTickets() {
        System.out.println(numberOfTickets + "개를 구매했습니다.");
    }


    public static int[] enterTheWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String strWinningNums = Console.readLine();
        String[] tmpArr = strWinningNums.split(",");
        int[] winningNums = new int[tmpArr.length];

        for (int i = 0; i < tmpArr.length; ++i) {
            winningNums[i] = Integer.parseInt(tmpArr[i]);
        }
        return winningNums;

    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현

        enterPurchaseAmount();
        printNumberOfTickets();

        int[] winningNums = enterTheWinningNumber();


    }
}
