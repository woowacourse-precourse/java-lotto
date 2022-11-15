package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try{
            System.out.println("구입 금액을 입력해주세요.");
            int money = Input.inputMoney();
            System.out.println();

            int count = Judgement.buyLotto(money);
            System.out.printf("%d개를 구매했습니다.\n", count);
            Result result = new Result();
            result.setCount(count);
            result.purchaseLotteries(count);
            result.printPurchasedLotteries();
            System.out.println();

            // 당첨 번호 입력 받기 // 예외 처리 (1~45 자리 수, int가 아닌 경우, 6자리 수, 중복 문자 제거)
            System.out.println("당첨 번호를 입력해 주세요.");
            List<Integer> winningNumber = Input.inputWinningNumber();
            result.setWinningNumber(winningNumber);
            System.out.println();

            // 보너스 번호 입력 받기 // 예외 처리 (1~45 자리 수, int가 아닌 경우 )
            System.out.println("보너스 번호를 입력해 주세요.");
            int bonusNumber = Input.inputBonusNumber(winningNumber);
            result.setBonusNumber(bonusNumber);
            System.out.println();

            result.calculateWinningStatistics();
            // 당첨 내역 출력
            result.printWinningStatistics();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
