package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    static final WinningNumber winningNumber = new WinningNumber();
    static final Cash cash = new Cash();

    public static void main(String[] args) {
        PrintLotto printLotto = new PrintLotto();
        try {
            String inputCash = insertMoney(); // 구입 금액 입력
            cash.Input(inputCash);
            printLotto.issuance(cash.cnt); // 투입된 현금만큼 복권 발행
            System.out.println("");
            Lotto winningLotto = inputWinningNumber(); // 당첨 번호 입력
            int bnsNumber = inputBonusNumber(); // 보너스 번호 입력
            printLotto.startPrintList(cash.money, winningLotto.getNumbers(), bnsNumber); // 당첨 통계
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 잘못된 값을 입력하셨습니다");
        }
    }

    public static String insertMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputCash = Console.readLine();
        System.out.println("");
        return inputCash;
    }

    public static Lotto inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningString = Console.readLine();
        Lotto winningLotto = winningNumber.inputWinningNum(winningString);
        System.out.println("");
        return winningLotto;
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String BonusStr = Console.readLine();
        int bnsNumber = winningNumber.inputBonusNum(BonusStr);
        System.out.println("");
        return bnsNumber;
    }
}
