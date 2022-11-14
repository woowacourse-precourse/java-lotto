package lotto;

import ui.UserInterface;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        try {
            int payment = UserInterface.readPayment();
            List<Lotto> boughtLotteries = buyLotteries(payment / 1000);
            UserInterface.printBoughtLotteries(boughtLotteries);

            LottoRound lottoRound = makeLottoRound();
            LottoStatistics statistics = makeStatistics(boughtLotteries, lottoRound);

            UserInterface.printStatistics(statistics);
        } catch (IllegalArgumentException e) {
            UserInterface.printError(e);
        }
    }

    /**
     * 입력된 수만큼 로또를 자동으로 구매합니다.
     * @param num 구매할 로또 개수
     * @return 생성된 로또번호 목록
     */
    private static List<Lotto> buyLotteries(int num) {
        List<Lotto> lotteries = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            lotteries.add(Lotto.createRandomLotto());
        }
        return lotteries;
    }

    /**
     * 사용자에게 입력받은 값으로 로또 회차를 생성합니다.
     * UserInterface를 통해 당첨번호, 보너스 번호를 입력받습니다.
     * @return 로또 회차
     * @throws IllegalArgumentException 사용자 입력에 의한 오류
     */
    private static LottoRound makeLottoRound() throws IllegalArgumentException {
        Lotto luckyNumbers = UserInterface.readLuckyNumbers();
        int bonusNumber = UserInterface.readBonusNumber();
        return new LottoRound(luckyNumbers, bonusNumber);
    }

    /**
     * 당첨 통계 결과를 생성합니다.
     * @param boughtLotteries 구매한 로또번호 목록
     * @param lottoRound 로또 회차 정보
     * @return 당첨 통계 정보
     * @throws IllegalArgumentException
     */
    private static LottoStatistics makeStatistics(List<Lotto> boughtLotteries, LottoRound lottoRound) {
        LottoStatistics statistics = new LottoStatistics();
        for (Lotto lotto : boughtLotteries) {
            statistics.add(lottoRound.getRank(lotto));
        }
        return statistics;
    }
}
