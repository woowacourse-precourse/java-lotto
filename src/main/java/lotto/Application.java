package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MakeLottoNumber makeLottoNumber = new MakeLottoNumber();
        makeLottoNumber.returnLottoNumber();
        WinningNumber winningNumber = new WinningNumber();

        System.out.println("구입금액을 입력해 주세요.");
        String inputCash = Console.readLine();
        Cash cash = new Cash();
        cash.Input(inputCash);

        System.out.println("당첨 번호를 입력해 주세요.");
        String winningString = Console.readLine();
        winningNumber.inputWinningNum(winningString);

        System.out.println("보너스 번호를 입력해 주세요.");
        String BonusStr = Console.readLine();
        winningNumber.inputBonusNum(BonusStr);
    }
}
