package lotto.repository;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Money;

import java.util.List;

public class LottoRepository {
    private static final LottoRepository lottoRepository = new LottoRepository();

    private LottoRepository() {
    }

    public static LottoRepository getInstance() {
        return lottoRepository;
    }

    private List<Integer> compareResult;
    private Money userMoney;
    private List<Lotto> userLottoGroup;
    private Lotto winningLotto;
    private BonusNumber bonusNumber;

    public void saveUserLotto(List<Lotto> userLottoGroup) {
        this.userLottoGroup = userLottoGroup;
    }

    public void saveWinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void saveBonusNumber(BonusNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void saveWinningResult(List<Integer> winningResult) {
        compareResult = winningResult;
    }

    public void saveUserMoney(Money userMoney) {
        this.userMoney = userMoney;
    }

    public Money getUserMoney() {
        return userMoney;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public List<Lotto> getUserLottoGroup() {
        return userLottoGroup;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinningResult() {
        return compareResult;
    }
}
