package lotto.service;


import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.repository.RankCountRepository;

public class WinningStatisticService {

    private final RankCountRepository rankCountRepository;

    public WinningStatisticService(RankCountRepository rankCountRepository) {
        this.rankCountRepository = rankCountRepository;
    }

    public void saveRankCount(List<Lotto> lottos, WinningLotto winningLotto) {
        lottos.forEach(lotto -> {
            int matchedNumber = getMatchedNumber(lotto, winningLotto.getLotto().getNumbers());
            boolean hasBonusNumber = hasBonusNumber(lotto, winningLotto.getBonusNumber());
            Rank.of(matchedNumber, hasBonusNumber).ifPresent(rankCountRepository::save);
        });
    }

    private Integer getMatchedNumber(Lotto lotto, List<Integer> winningLottoNumbers) {
        List<Integer> lottoNumbers = new ArrayList<>(lotto.getNumbers());
        lottoNumbers.retainAll(winningLottoNumbers);
        return lottoNumbers.size();
    }

    private boolean hasBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

}
