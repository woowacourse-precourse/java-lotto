package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.LottoErrorCheck.*;
import static lotto.LottoInput.*;
import static lotto.LottoStatistics.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        runLottoApp();
    }

    public static void runLottoApp() {

        int lottoCount = howMuchLottoBuyInput();

        List<Lotto> lotto = issueLotto(lottoCount);

        List<Integer> winningNumber = winningNumberInput();
        Integer bonusNumber = bonusNumberInput();
        checkBonusNumberIncludedWinningNumber(winningNumber, bonusNumber);

        List<Integer> lottoResult = resultWinningLottery(lotto, winningNumber, bonusNumber);

        double earningRate = calculateLottoEarningsRate(lottoResult, lottoCount);
        winningStatistics(lottoResult, earningRate);
    }

    public static List<Lotto> issueLotto(int lottoCount) {
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");
        List<Lotto> lotto = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lotto.add(new Lotto(lottoNumber));
            lotto.get(i).printSortedLottoNumbers();
        }

        return lotto;
    }
}
