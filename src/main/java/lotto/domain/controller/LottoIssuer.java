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
    private WinningLotto winningLotto;
    private Lotto lottoBeingChecked;

    public LottoIssuer() {
        initStatistics();
    }

    private void initStatistics() {
        statistics = new HashMap<>();

        for (RankingInformation oneRank : RankingInformation.values()) {
            statistics.put(oneRank, 0);
        }
    }

    // ======= 로또 발행 관련 메소드 ======

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

    // ======= 당첨 통계 관련 메소드 ======

    public Map<RankingInformation, Integer> makeWinningStatistics(List<Lotto> lottos,
            WinningLotto winningLotto) {

        this.winningLotto = winningLotto;

        checkEachLottoWithWinningLotto(lottos);

        return statistics;
    }

    private void checkEachLottoWithWinningLotto(List<Lotto> lottos) {
        for (Lotto oneLotto : lottos) {
            lottoBeingChecked = oneLotto;
            compareOneLotto();
        }
    }

    private void compareOneLotto() {
        int numberOfDuplicated = countMatchingNumbers();

        reflectStatistics(numberOfDuplicated);
    }

    private int countMatchingNumbers() {
        List<Integer> matchingNumbers = leaveOnlyDuplicated();

        int numberOfMatchingNumbers = matchingNumbers.size();

        return numberOfMatchingNumbers;
    }

    private List<Integer> leaveOnlyDuplicated() {
        List<Integer> winningNumbers = winningLotto.getWinningNumbers();

        List<Integer> lottoNumbers = new ArrayList<>(lottoBeingChecked.getNumbers());

        lottoNumbers.retainAll(winningNumbers);

        return lottoNumbers;
    }

    private void reflectStatistics(int numberOfDuplicated) {
        RankingInformation[] rankingInformations = RankingInformation.values();

        for (RankingInformation rank : rankingInformations) {
            if (numberOfDuplicated == rank.getNumberOfMatch()) {
                increaseCount(rank);
                break;
            }
        }
    }

    private void increaseCount(RankingInformation rank) {
        if (rank.getNumberOfMatch() == 5) {
            boolean containsBonus = checkBonusNumber();

            if (containsBonus) {
                rank = RankingInformation.SECOND_PLACE;
            }
        }

        int count = statistics.get(rank) + 1;
        statistics.put(rank, count);
    }

    private boolean checkBonusNumber() {
        int bonusNumber = winningLotto.getBonusNumber();

        boolean isContained = lottoBeingChecked.getNumbers().contains(bonusNumber);

        return isContained;
    }
}
