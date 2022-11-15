package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Result;

public class Application {
    public static void main(String[] args) {
        // 로또 구입 금액 입력 받기 // 예외 처리 (int가 아닌 경우, 1000원 단위가 아닐 경우)
        System.out.println("구입 금액을 입력해주세요.");
        int money = Input.inputMoney();

        // 로또 구입 금액에 따른 로또 개수 계산
        int count = Judgement.buyLotto(money);
        System.out.println(count);

        // 발행한 로또 수량 및 번호 출력
        System.out.printf("%d개를 구매했습니다. \n", count);
        Result result = new Result();
        result.purchaseLotteries(count);
        result.printPurchasedLotteries();

        // 당첨 번호 입력 받기 // 예외 처리 (1~45 자리 수, int가 아닌 경우, 6자리 수, 중복 문자 제거)
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumber = Input.inputWinningNumber();
        System.out.println(winningNumber);

        // 보너스 번호 입력 받기 // 예외 처리 (1~45 자리 수, int가 아닌 경우 )
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Input.inputBonusNumber(winningNumber);
        System.out.println(bonusNumber);

        // 당첨 내역 출력


        // 수익률 계산 출력
    }
}
