package lotto;

import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 구입 금액 입력
        UserInterface.printPurchaseMoneyMessage();
        int purchaseMoney = 0;
        try {
            purchaseMoney = UserInterface.inputPurchaseMoney();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        // 로또 발행
        List<Lotto> lottoList = LottoGenerator.generateLotto(purchaseMoney / 1000);
        UserInterface.printLottoList(lottoList);

        // 당첨 번호 입력
        UserInterface.printWinNumbersMessage();
        List<Integer> winNumbers = UserInterface.inputWinNumbers();

        // 보너스 번호 입력
        UserInterface.printBonusNumberMessage();
        int bonusNumber = UserInterface.inputBonusNumber();

        // 당첨 로또 생성
        WinLotto winLotto = new WinLotto(winNumbers, bonusNumber);

        // 사용자 생성
        User user = new User(purchaseMoney, lottoList, winLotto);

        // 당첨 통계 출력
        HashMap<LottoRank, Integer> winResult = user.getWinResult();
        UserInterface.printWinResult(winResult);

        // 총 수익률 출력
        UserInterface.printIncomePercent(user.getIncomePercent());
    }
}
