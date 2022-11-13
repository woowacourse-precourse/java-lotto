package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGameResultGenerator {
    public static LottoGameResult generateLottoGameResult(List<Lotto> lottos,
                                                          WinningNumbers winningNumbers,
                                                          BonusNumber bonusNumber) {
        Map<Integer, Integer> winningDetails = new HashMap<>();
        initializeWinningDetails(winningDetails);
        LottoGameResult lottoGameResult = new LottoGameResult();
        return lottoGameResult;
    }

    private static void initializeWinningDetails(Map<Integer, Integer> winningDetails) {
        winningDetails.put(5_000, 0);
        winningDetails.put(50_000, 0);
        winningDetails.put(1_500_000, 0);
        winningDetails.put(30_000_000, 0);
        winningDetails.put(2_000_000_000, 0);
    }
}
