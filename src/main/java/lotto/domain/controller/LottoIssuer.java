package lotto.domain.controller;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constants.RankingInformation;
import lotto.domain.model.Lotto;
import lotto.domain.model.WinningLotto;

public class LottoIssuer {

    private Map<RankingInformation, Integer> statistics;

    public LottoIssuer() {
        initStatistics();
    }

    private void initStatistics() {
        statistics = new HashMap<>();

        for (RankingInformation oneRank : RankingInformation.values()) {
            statistics.put(oneRank, 0);
        }
    }

    public List<Lotto> issueLottos(int numberOfLottos) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLottos; i++) {
            Lotto oneLotto = issueOneLotto();

            lottos.add(oneLotto);
        }

        return lottos;
    }

    private Lotto issueOneLotto() {
        List<Integer> oneLottoNumbers = pickUniqueNumbersInRange(1, 45, 6);
        oneLottoNumbers.sort(Comparator.naturalOrder());

        return new Lotto(oneLottoNumbers);
    }

    public Map<RankingInformation, Integer> makeWinningStatistics(List<Lotto> lottos,
            WinningLotto winningLotto) {
        List<Integer> winningNumbers = winningLotto.getWinningNumbers();
        int bonusNumber = winningLotto.getBonusNumber();

        RankingInformation[] rankingInformations = RankingInformation.values();

        for (Lotto oneLotto : lottos) {
            List<Integer> lottoNumbers = new ArrayList<>();
            lottoNumbers.addAll(oneLotto.getNumbers());
            boolean containsBonus = lottoNumbers.contains(bonusNumber);
            lottoNumbers.retainAll(winningNumbers);

            int rankIndex = lottoNumbers.size() - 3;

            if (rankIndex == 3) {
                rankIndex++;
            }

            if (rankIndex == 2) {
                if (containsBonus) {
                    rankIndex++;
                }
            }

            if (rankIndex >= 0) {
                RankingInformation rank = rankingInformations[rankIndex];
                int count = statistics.get(rank) + 1;
                statistics.put(rank, count);
            }
        }

        return statistics;
    }
}
