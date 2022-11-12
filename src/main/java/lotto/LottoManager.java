package lotto;

import lotto.controller.LottoGenerator;
import lotto.controller.ValidationException;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.controller.LottoGenerator.generateLottoNumber;

public class LottoManager {

    List<Lotto> lottoNumbers;

    public void userWantLotto() {

        String userMoney = InputView.priceInput();
        if (ValidationException.checkValidPrice(userMoney)) {

        }
    }

}
