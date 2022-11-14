package lotto;

import java.util.List;

public class LottoStore {
    private final List<Lotto> lottos;

    public LottoStore(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    /**
     * 로또게임의 결과를 받아 내 로또의 수익률을 출력
     * @param lottoRankResults : 로또 결과를 담은 정수 리스트
     * @return 내 로또의 수익률 (일분율)
     */
    public double calculateLottoYield(List<Integer> lottoRankResults){
        int investment = getLottoInvestment();
        Long totalPrize = getTotalLottoPrize(lottoRankResults);
        double lottoYield = totalPrize / (double)investment;

        return lottoYield;
    }

    private int getLottoInvestment(){
        return this.lottos.size() * 1000;
    }

    private Long getTotalLottoPrize(List<Integer> lottoRankResults){
        Long totalPrize = 0L;
        for (int ordinal = 0; ordinal < lottoRankResults.size(); ordinal++){
            int ordinalCount = lottoRankResults.get(ordinal);
            Long ordinalPrize = LottoRank.values()[ordinal].getPrize();
            totalPrize += ordinalPrize * ordinalCount;
        }
        return totalPrize;
    }
}
