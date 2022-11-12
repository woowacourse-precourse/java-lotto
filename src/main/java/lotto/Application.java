package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        WinningNumber winningNumber = new WinningNumber();
        Cash cash = new Cash();
        PrintLotto printLotto = new PrintLotto();

        System.out.println("구입금액을 입력해 주세요.");
        String inputCash = Console.readLine();
        System.out.println("");

        cash.Input(inputCash);
        printLotto.issuance(cash.cnt);
        System.out.println("");

        System.out.println("당첨 번호를 입력해 주세요.");
        String winningString = Console.readLine();
        winningNumber.inputWinningNum(winningString);

        System.out.println("보너스 번호를 입력해 주세요.");
        String BonusStr = Console.readLine();
        winningNumber.inputBonusNum(BonusStr);


    }
}
