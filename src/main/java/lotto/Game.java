package lotto;

import lotto.console.InputUtil;
import lotto.console.PrintUtil;
import lotto.generator.RandomLottoGenerator;
import lotto.model.Lotto;
import lotto.model.LottoInfo;
import lotto.model.LottoRank;
import lotto.model.LottoResult;
import lotto.model.WinningLotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    public void start() {
        LottoInfo lottoInfo = new LottoInfo(InputUtil.inputLottoPurchaseAmount());

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoInfo.getBuyingLottoCount(); i++) {
            lottos.add(RandomLottoGenerator.makeLotto());
        }

        PrintUtil.printPurchaseLottoStatus(lottos);

        WinningLotto winningLotto = new WinningLotto(InputUtil.inputWinningLottoNumber(),
                                                     InputUtil.inputBounsLottoNumber());

        PrintUtil.printWinningLottoStatus();

        Map<LottoRank, Integer> lottoScore = new HashMap<>();

        lottoScore.put(LottoRank.FIFTH, 0);
        lottoScore.put(LottoRank.FOURTH, 0);
        lottoScore.put(LottoRank.THIRD, 0);
        lottoScore.put(LottoRank.SECOND, 0);
        lottoScore.put(LottoRank.FIRST, 0);
        lottoScore.put(LottoRank.NONE, 0);

        for (Lotto lotto : lottos) {
            LottoRank lottoRank = lotto.getCorrectLottoCount(winningLotto.getLotto(),
                                                             winningLotto.getBounsNumber());

            lottoScore.put(lottoRank, lottoScore.get(lottoRank) + 1);
        }

        LottoResult lottoResult = new LottoResult(lottoScore);

        PrintUtil.printLottoResult(lottoResult, lottoInfo);
    }
}
