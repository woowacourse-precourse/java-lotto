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

        List<Lotto> lottos = makeLottoList(lottoInfo);

        PrintUtil.printPurchaseLottoStatus(lottos);

        WinningLotto winningLotto = makeWinningLotto();

        PrintUtil.printWinningLottoStatus();

        LottoResult lottoResult = makeLottoResult(lottos, winningLotto);

        PrintUtil.printLottoResult(lottoResult, lottoInfo);
    }

    private List<Lotto> makeLottoList(LottoInfo lottoInfo) {

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoInfo.getBuyingLottoCount(); i++) {
            lottos.add(RandomLottoGenerator.makeLotto());
        }

        return lottos;
    }

    private WinningLotto makeWinningLotto() {
        return new WinningLotto(InputUtil.inputWinningLottoNumber(),
                                InputUtil.inputBounsLottoNumber());
    }

    private LottoResult makeLottoResult(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<LottoRank, Integer> lottoScore = initLottoScore();

        for (Lotto lotto : lottos) {
            LottoRank lottoRank = lotto.getCorrectLottoCount(winningLotto.getLotto(),
                                                             winningLotto.getBounsNumber());

            lottoScore.put(lottoRank, lottoScore.get(lottoRank) + 1);
        }

        return new LottoResult(lottoScore);
    }

    private Map<LottoRank, Integer> initLottoScore() {
        Map<LottoRank, Integer> lottoScore = new HashMap<>();

        lottoScore.put(LottoRank.FIFTH, 0);
        lottoScore.put(LottoRank.FOURTH, 0);
        lottoScore.put(LottoRank.THIRD, 0);
        lottoScore.put(LottoRank.SECOND, 0);
        lottoScore.put(LottoRank.FIRST, 0);
        lottoScore.put(LottoRank.NONE, 0);

        return lottoScore;
    }
}
