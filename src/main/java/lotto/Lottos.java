package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Lottos {
    private static final String LOTTO_TICKET_SIZE_IS_NOT_LOTTO_AMOUNT = "[ERROR] 랜덤으로 생성된 로또 티켓의 로또 개수가 구입한 로또 개수와 다릅니다.";

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private void validateLottos(List<Lotto> lottos, int lottoAmount) {
        if (lottos.size() != lottoAmount) {
            throw new IllegalArgumentException(LOTTO_TICKET_SIZE_IS_NOT_LOTTO_AMOUNT);
        }
    }

    public static Lottos generateLottos(int lottoAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            lottos.add(Lotto.generateRandomLotto());
        }
        return new Lottos(lottos);
    }

    public Map<Rank, Integer> compareWithWinningLotto(Map<Rank, Integer> statistics, Lotto winningLotto, int bonusNumber) {
        for (int i = 0; i < lottos.size(); i++) {
            int matchCount = lottos.get(i).match(winningLotto);
            boolean isBonusMatch = lottos.get(i).isBonusMatch(bonusNumber);
            Rank rank = Rank.of(matchCount, isBonusMatch);
            statistics.put(rank, statistics.getOrDefault(rank, 0) + 1);
        }
        return statistics;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}