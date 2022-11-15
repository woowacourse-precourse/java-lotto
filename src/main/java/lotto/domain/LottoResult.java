package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final int userMoney;
    private final Map<Rank, Integer> lottoRanks;

    public LottoResult(int userMoney, UserLotto userLotto, WinningLotto winningLotto) {
        this.userMoney = userMoney;
        this.lottoRanks = createLottoRanks(userLotto,winningLotto);
    }

    private Map<Rank, Integer> createLottoRanks(UserLotto userLotto, WinningLotto winningLotto) {
        List<Lotto> userLottos = userLotto.getUserLottos();
        Map<Rank, Integer> lottoRanks = new HashMap<>();

        for (Lotto lotto : userLottos) {
            Rank rank = winningLotto.getRankOf(lotto);
            addLottoRanks(rank, lottoRanks);
        }
        return lottoRanks;
    }

    private void addLottoRanks(Rank rank, Map<Rank, Integer> lottoRanks) {
        if (rank == Rank.MISS) {
            return;
        }
        int winningCount = lottoRanks.getOrDefault(rank, 0);
        lottoRanks.put(rank, winningCount + 1);
    }

    public String getLottoResultString() {
        StringBuilder lottoResultMessage = new StringBuilder();

        for (Rank rank : Rank.values()) {
            if (rank == Rank.MISS) {
                continue;
            }
            int count = lottoRanks.getOrDefault(rank, 0);
            lottoResultMessage.append(String.format(rank.getWinningMessage() + "\n", count));
        }

        return lottoResultMessage.toString();
    }
}
