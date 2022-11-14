package lotto.service;

import lotto.domain.*;

public class LottoGameService {

    private Lottos lottos;
    private Lotto winningLotto;
    private int bonusNumber;

    public void buyLottos(int inputMoney) {
        Money money = new Money(inputMoney);
        LottoFactory factory = new LottoFactory(new RandomNumbers());
        this.lottos = new Lottos(factory.generateLottos(money));
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public String getLottosToString() {
        return lottos.toString();
    }

    public void setWinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void setBonusNumber(int number) {
        validate(this.winningLotto, number);
        this.bonusNumber = number;
    }

    private void validate(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.contain(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }

}
