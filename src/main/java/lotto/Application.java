package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.presentation.LottoController;
import lotto.presentation.dto.PurchaseAmount;
import lotto.presentation.dto.WinnerNumber;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            LottoController lottoController=LottoController.getInstance();
            //앱 실행
            lottoController.run();
            //구매 금액 저장
            lottoController.saveCountLotto(new PurchaseAmount(Console.readLine()));
            //구매 개수 출력
            lottoController.printCountLotto();
            //구매 개수 만큼의 로또 발행
            lottoController.purchasedLotto();
            //로또 발행 내역 출력
            lottoController.printPurchasedLotto();
            //당첨 번호 저장
            lottoController.saveWinnerNumber(new WinnerNumber(Console.readLine()));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
