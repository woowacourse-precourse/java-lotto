package lotto.repository;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Money;

import java.util.List;

public class LottoRepository {

    private List<Integer> compareResult;
    private Money userMoney;
    private List<Lotto> userLottoGroup;
    private Lotto winningLotto;
    private BonusNumber bonusNumber;

    public Money getUserMoney() {
        return userMoney;
    }

    public void saveUserLotto(List<Lotto> userLottoGroup) {
        this.userLottoGroup = userLottoGroup;
    }

    public void saveWinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public List<Lotto> getUserLottoGroup() {
        return userLottoGroup;
    }

    public void saveBonusNumber(BonusNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

    public void saveWinningResult(List<Integer> winningResult) {
        compareResult = winningResult;
    }

    public List<Integer> getWinningResult() {
        return compareResult;
    }

    public void saveUserMoney(Money userMoney) {
        this.userMoney = userMoney;
    }
}
