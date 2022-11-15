package lotto.domain;

import java.util.HashMap;
import java.util.List;

public class LottoResult {
    private final HashMap<LottoRank, Integer> result = new HashMap<>();

    public LottoResult(List<LottoRank> lottoRanks) {
        initializationMap();
        for (LottoRank lottoRank : lottoRanks) {
            result.put(lottoRank, result.get(lottoRank) + 1);
        }
    }

    public void initializationMap() {
        for (LottoRank lottoRank : LottoRank.values()) {
            result.put(lottoRank, 0);
        }
    }

    public int totalPrize() {
        int sum = 0;
        for (LottoRank lottoRank : result.keySet()) {
            sum += result.get(lottoRank) * lottoRank.getMoney();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = LottoRank.values().length - 2; i >= 0; i--) {
            sb.append(LottoRank.values()[i].toString());
            sb.append("- ");
            sb.append(result.get(LottoRank.values()[i]));
            sb.append("개\n");
        }
        return sb.toString();
    }

}