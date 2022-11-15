package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoUser;
import lotto.service.LottoAnalyzer;
import lotto.service.LottoObjectManager;

public class Application {

    private final static LottoObjectManager lottoObjectManager = new LottoObjectManager();

    public static void main(String[] args) {
        try {
            lotteryRun();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void lotteryRun() {
        // 로또 구매
        final LottoUser lottoUser = lottoObjectManager.createLottoUser();

        // 당첨 번호 입력
        final Lotto winningLotto = lottoObjectManager.createWinningLotto();
        // 보너스 번호 입력
        final int bonusNumber = lottoObjectManager.createBonusNumber(winningLotto);

        // 유저 로또 번호 출력
        lottoUser.showUserRandomLottos();

        // 당첨 내역 출력
        final LottoAnalyzer lottoAnalyzer =
                lottoObjectManager.createLottoAnalyzer(lottoUser, winningLotto, bonusNumber);
        lottoAnalyzer.showLottoStatistics();
    }
}
