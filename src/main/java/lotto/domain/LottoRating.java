package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lotto.resource.Rank;

public class LottoRating {
    private final List<Lotto> lottoBunch;
    private final WinningLotto winningLotto;

    private Map<String, Integer> winningCountRepository = new HashMap<>();

    public LottoRating(List<Lotto> lottoTicket, WinningLotto winningLotto) {
        this.lottoBunch = lottoTicket;
        this.winningLotto = winningLotto;
    }

    public Map<String, Integer> rate() {
        for (Lotto lotto : lottoBunch) {
            int matchingCount = compareLotto(lotto);
            if (isWinning(matchingCount)) {
                saveWinningCount(matchingCount, lotto);
            }
        }
        return winningCountRepository;
    }

    public int compareLotto(Lotto lotto) {
        int matchingCount = 0;
        for (Integer winningNumber : winningLotto.getLotto().getNumbers()) {
            if (lotto.getNumbers().contains(winningNumber)) {
                matchingCount++;
            }
        }
        return matchingCount;
    }

    private boolean isWinning(int matchingCount) {
        return matchingCount >= Rank.FIFTH.getMatchingCount();
    }

    public void saveWinningCount(int matchingCount, Lotto lotto) {
        boolean isSecond = Objects.equals(Rank.SECOND.getMatchingCount(), matchingCount) && hasBonusNumber(lotto);
        if (isSecond) {
            String second = Rank.SECOND.name();
            winningCountRepository.put(second, winningCountRepository.getOrDefault(second, 0) + 1);
        }

        for (Rank value : Rank.values()) {
            if (Objects.equals(value.getMatchingCount(), matchingCount) && !isSecond) {
                String rankName = value.name();
                winningCountRepository.put(rankName, winningCountRepository.getOrDefault(rankName, 0) + 1);
            }
        }
    }

    private boolean hasBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(winningLotto.getBonusNumber());
    }

    public Map<String, Integer> getWinningCountRepository() {
        return winningCountRepository;
    }
}
