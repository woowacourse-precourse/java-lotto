package lotto.repository;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.WinningResult;

public class ResultRepository {
    private static ResultRepository instance;
    private Lotto winningLotto;
    private int bonusNumber;
    private Map<WinningResult, Integer> winningResultCount;

    private ResultRepository() {
    }

    public static ResultRepository getInstance() {
        if (instance == null) {
            instance = new ResultRepository();
        }
        return instance;
    }

    public void save(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void save(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public Lotto findWinningLotto() {
        return winningLotto;
    }

    public int findBonusNumber() {
        return bonusNumber;
    }

    public void save(Map<WinningResult, Integer> winningResultCount) {
        this.winningResultCount = winningResultCount;
    }

    public Map<WinningResult, Integer> findLottoResultCount() {
        return winningResultCount;
    }
}
