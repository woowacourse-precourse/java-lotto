package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.*;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(int set) {
        initLottos(set);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void initLottos(int set) {
        for (int i = 0; i < set; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lotto.rangeLottoNumbers();
            lottos.add(lotto);
        }
    }

    public Map<LottoRanking, Integer> calculateLottos(List<Integer> lottoWinningNumber){
        Map<LottoRanking, Integer> lottoRankingResult=new EnumMap<LottoRanking, Integer>(LottoRanking.class);
        Arrays.stream(LottoRanking.values()).forEach(lottoRanking -> lottoRankingResult.put(lottoRanking, 0));
        for(Lotto lotto: lottos){
            int matchNumbers=lotto.matchLotto(lottoWinningNumber);
            boolean containsBonus=lotto.contains(new ArrayList<>(lottoWinningNumber.get(6)));

            LottoRanking lottoRanking=LottoRanking.getLottoRanking(matchNumbers, containsBonus);
            lottoRankingResult.put(lottoRanking, lottoRankingResult.get(lottoRanking)+1);
        }
        return lottoRankingResult;
    }
}
