package lotto.repository;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Money;

import java.util.List;

public class LottoRepository {

    private  List<Integer> lastCompareResult;
    private  Money lastuserMoney;
    private  List<Lotto> lastUserLottoGroup;
    private  Lotto lastWinningLotto;
    private  BonusNumber lastBonusNumber;

    public  Money getUserMoney() {
        return lastuserMoney;
    }

    public  void saveUserLotto(List<Lotto> userLottoGroup) {
        lastUserLottoGroup = userLottoGroup;
    }

    public  void saveWinningLotto(Lotto winningLotto) {
        lastWinningLotto = winningLotto;
    }

    public  Lotto getLastWinningLotto() {
        return lastWinningLotto;
    }

    public  List<Lotto> getLastUserLottoGroup() {
        return lastUserLottoGroup;
    }

    public  void saveBonusNumber(BonusNumber bonusNumber) {
        lastBonusNumber = bonusNumber;
    }

    public  BonusNumber getBonusNumber() {
        return lastBonusNumber;
    }

    public  void saveWinningResult(List<Integer> winningResult) {
        lastCompareResult = winningResult;
    }

    public  List<Integer> getWinningResult() {
        return lastCompareResult;
    }

    public  void saveUserMoney(Money userMoney) {
        lastuserMoney = userMoney;
    }
}
