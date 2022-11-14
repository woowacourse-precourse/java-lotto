package lotto.domain.model;

import lotto.domain.model.request.LottoNumberRequest;
import lotto.domain.model.request.LottoRequest;

public class WinningLotto {

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(LottoRequest lottoRequest, LottoNumberRequest numberRequest) {
        numberValidation(numberRequest);
        this.lotto = new Lotto(lottoRequest.getNumbers());
        this.bonusNumber = numberRequest.getNumber();
    }

    private void numberValidation(LottoNumberRequest numberRequest) {
    }

}
