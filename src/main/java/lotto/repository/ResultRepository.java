package lotto.repository;

import lotto.Lotto;

public class ResultRepository {
    private static ResultRepository instance;
    private Lotto winningLotto;
    private int bonusNumber;

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
}
