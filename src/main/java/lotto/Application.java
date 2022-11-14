package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            LottoMachine lottoMachine = new LottoMachine(Console.readLine());
            System.out.println();
            System.out.println("당첨 번호를 입력해 주세요.");
            WinningNumber winningNumber = new WinningNumber(Console.readLine());
            System.out.println();
            System.out.println("보너스 번호를 입력해 주세요.");
            winningNumber.setBonusNumber(Console.readLine());
            lottoMachine.setWinningNumber(winningNumber);
            System.out.println();
            lottoMachine.evaluate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
