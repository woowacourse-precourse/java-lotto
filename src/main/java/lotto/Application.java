package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        WinningNumber winningNumber = new WinningNumber();
        Cash cash = new Cash();
        PrintLotto printLotto = new PrintLotto();

        int[] winningLotto;
        int bnsNumber = 0;

        System.out.println("구입금액을 입력해 주세요.");
        String inputCash = Console.readLine();
        System.out.println("");

        cash.Input(inputCash);
        printLotto.issuance(cash.cnt); // 투입된 현금만큼 복권 발행
        System.out.println("");

        System.out.println("당첨 번호를 입력해 주세요.");
        String winningString = Console.readLine();
        winningLotto = winningNumber.inputWinningNum(winningString);
        System.out.println("");

        System.out.println("보너스 번호를 입력해 주세요.");
        String BonusStr = Console.readLine();
        bnsNumber = winningNumber.inputBonusNum(BonusStr);
        System.out.println("");

        printLotto.startPrintList(cash.money, winningLotto, bnsNumber);

    }
}
