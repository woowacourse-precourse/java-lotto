package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static lotto.Rank.*;

public class LottoMatcher {

    private final Map<Rank, Integer> prize = Map.of(
            FIRST_SIX_MATCHED, 2_000_000_000,
            SECOND_FIVE_WITH_BONUS, 30_000_000,
            THIRD_FIVE_MATCHED, 1_500_000,
            FOURTH_FOUR_MATCHED, 50_000,
            FIFTH_THREE_MATCHED, 5_000);

    private List<Lotto> publishedLottos;
    private WinningLotto winningLotto;
    private List<Rank> results;

    public LottoMatcher(List<Lotto> publishedLottos, WinningLotto winningLotto) {
        this.publishedLottos = publishedLottos;
        this.winningLotto = winningLotto;
        results = new ArrayList<>();
        matchAllLottos();
    }

    private void matchAllLottos() {
        // 각각의 lotto 와 winning lotto 의 일치율을 확인
    }

    private void matchLotto(Lotto lotto) {
        // Lotto 번호들이 몇개의 winning lotto 번호를 가지는지 확인
        // 5개가 맞으면 보너스 번호도 확인
        // 결과값을 저장
    }

    private int countWinningLottoNumbers(List<Integer> lottoNumbers) {
        // Lotto 번호들에서 winning lotto 번호의 개수 count
        return 0;
    }

    private boolean checkIfBonusNumberMatch(List<Integer> lottoNumbers) {
        // Lotto 번호들에서 보너스 번호가 있는지 확인
        return false;
    }

    private void saveResult(int numberOfMatchedLottoNumber) {
        // 일치하는 lotto 개수에 따라 결과를 판별하고 저장
    }

    public List<Rank> getResults() {
        return results;
    }
}
