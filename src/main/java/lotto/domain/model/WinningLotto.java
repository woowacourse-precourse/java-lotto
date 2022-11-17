package lotto.domain.model;

import lotto.domain.model.request.LottoNumberRequest;
import lotto.domain.model.request.LottoRequest;

public class WinningLotto {

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(LottoRequest lottoRequest, LottoNumberRequest numberRequest) {
        this.lotto = new Lotto(lottoRequest.getNumbers());
        bonusNumberValidation(numberRequest.getNumber());
        this.bonusNumber = numberRequest.getNumber();
    }

    private void bonusNumberValidation(int bonusNumber) {
        if (this.lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("로또 번호와 보너스번호와 겹칠 수 없습니다.");
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
