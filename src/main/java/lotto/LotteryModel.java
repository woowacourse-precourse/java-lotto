package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LotteryModel {
    private Lotto winningNumber;
    private int bonusNumber;
    private List<Lotto> purchasedLotto;
    public LotteryModel() {
        purchasedLotto = new ArrayList<Lotto>();
    }

    public void setWinningNumber(List<Integer> numbers) {
        winningNumber = new Lotto(numbers);
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Lotto> getPurchasedLotto() {
        return purchasedLotto;
    }

    public void generateLottoNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        purchasedLotto.add(new Lotto(numbers));
    }
}
