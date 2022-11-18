package lotto.domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class User {
    List<Integer> answerNumber;
    int bonusNumber;
    int money;
    List<Lotto> myLotto = new ArrayList<>();

    public void SetMoney(int money) {
        this.money = money;
    }

    public void SetAnswerNumber(List<Integer> answerNumber) {
        this.answerNumber = answerNumber;
    }

    public void SetBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int GetMoney() {
        return money;
    }

    public int GetBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> GetLottoAnswer() {
        return answerNumber;
    }

    public List<Lotto> GetMyLotto() {
        return myLotto;
    }


    public void BuyLotto() {
        NumberGenerator numberGenerator = new NumberGenerator();
        for (int i = 0; i < money; i += 1000) {
            Lotto lotto = new Lotto(numberGenerator.getLottoNumber());
            myLotto.add(lotto);
        }
    }
}
