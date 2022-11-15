package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoManager {

    UserInterface ui = new UserInterface();

    public void run() {
        List<Lotto> userLottos;
        LottoJudge lottoJudge;
        try {
            int purchasingAmount = ui.requestPurchaseAmount() / Lotto.PRICE;
            userLottos = makeLottosBy(purchasingAmount);
            ui.showPurchasedResult(userLottos);

            lottoJudge = new LottoJudge(
                    ui.requestWinningNumbers(), ui.requestBonusNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        Map<LottoPlace, Integer> records = new HashMap<>();
        initRecords(records);

        for (Lotto userLotto : userLottos) {
            LottoPlace resultPlace = lottoJudge.judgePlace(userLotto);
            records.put(resultPlace, records.get(resultPlace) + 1);
        }

        ui.showLottoStatistics(records, analyzeMarginRate(records));
    }

    private List<Lotto> makeLottosBy(int purchasingAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int index = 0; index < purchasingAmount; ++index) {
            List<Integer> lottoCandidate =
                    Randoms.pickUniqueNumbersInRange(
                            LottoNumber.LOTTO_MIN_NUMBER, LottoNumber.LOTTO_MAX_NUMBER, Lotto.NUMBERS_COUNT);
            lottos.add(new Lotto(lottoCandidate));
        }
        return lottos;
    }

    private void initRecords(Map<LottoPlace, Integer> records) {
        for (LottoPlace place : LottoPlace.values()) {
            records.put(place, 0);
        }
    }

    public double analyzeMarginRate(Map<LottoPlace, Integer> winningRecords) {
        int countPurchased = winningRecords.entrySet().stream()
                .mapToInt(entry -> entry.getValue() * Lotto.PRICE)
                .sum();
        int countWinning = winningRecords.entrySet().stream()
                .filter(entry -> !entry.getKey().equals(LottoPlace.NONE))
                .mapToInt(entry -> entry.getValue() * entry.getKey().getPrizeMoney())
                .sum();
        System.out.println(countWinning + " : " + countPurchased);
        return 100.0 * (double) countWinning / (double) countPurchased;
    }
}
