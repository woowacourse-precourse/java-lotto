package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.buyer.Buyer;
import lotto.domain.buyer.User;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoGenerator;
import lotto.domain.lotto.LottoRanking;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.seller.LottoMachine;
import lotto.domain.seller.Seller;
import lotto.dto.LottoCount;
import lotto.dto.LottoGameResult;

public class LottoGame {


    public void start() {
        List<Lotto> lottos =  buyLottos();
        Buyer buyer = new User(lottos);

        WinningLotto winningLotto = LottoGenerator.createWinningLottoWithEnterNumbers();
        Seller seller = new LottoMachine(winningLotto);
        LottoGameResult lottoGameResult = findLottoGameResult(lottos, seller);

        
    }

    private List<Lotto> buyLottos() {
        int money = LottoGenerator.enterToBuyLottoForMoney();
        int lottoCount = LottoGenerator.findLottoCountByMoney(money);
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            buyLotto(lottos);
        }
        return lottos;
    }

    private void buyLotto(List<Lotto> lottos) {
        Lotto lotto = LottoGenerator.createLottoWithRandomNumbers();
        lottos.add(lotto);
        System.out.println(lotto.getNumbers());
    }

    private LottoGameResult findLottoGameResult(List<Lotto> lottos, Seller seller) {
        List<LottoRanking> lottoRankings = new ArrayList<>();
        Map<LottoRanking, Integer> lottoRankingCount = new HashMap<>();
        for (Lotto lotto: lottos) {
            int hits = seller.compareNumbers(lotto.getNumbers());
            boolean bonus = seller.compareBonusNumber(lotto.getNumbers());
            LottoRanking lottoRanking = LottoRanking.of(new LottoCount(hits, bonus));
            lottoRankingCount.put(lottoRanking, lottoRankingCount.getOrDefault(lottoRanking, 0) + 1);
            lottoRankings.add(lottoRanking);
        }
        return new LottoGameResult(lottoRankings, lottoRankingCount);
    }
}
