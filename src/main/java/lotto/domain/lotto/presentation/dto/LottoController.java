package lotto.domain.lotto.presentation.dto;

import lotto.domain.view.InputView;

public class LottoController {

    public String inputPrice() {
        return InputView.getInputPrice();
    }

}
