package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;

public class LottoTicket {

    private final List<Lotto> lottoTicket;

    public LottoTicket(List<Lotto> lottoTicket) {
        this.lottoTicket = new ArrayList<>(lottoTicket);
    }

    public List<Lotto> lottoTicket() {
        return Collections.unmodifiableList(lottoTicket);
    }

    private static void addWinningResultCount(EnumMap<LottoRanking, Integer> winningResult, LottoRanking lottoRank) {
        if (lottoRank == LottoRanking.FAIL) {
            return;
        }
        winningResult.put(lottoRank, winningResult.getOrDefault(lottoRank, 0) + 1);
    }
}
