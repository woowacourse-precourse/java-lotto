package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int purchaseNumber;
    private int bonusNumber;
    private Lotto lotto;
    private List<List<Integer>> userLottos = new ArrayList<>();

    public int getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(int purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
        setUserLottos(purchaseNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public void setLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public List<List<Integer>> getUserLottos() {
        return userLottos;
    }

    private void setUserLottos(int purchaseNumber) {
        for (int i = 0; i < purchaseNumber; i++) {
            List<Integer> userLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            userLottos.add(userLotto);
        }
    }
}
