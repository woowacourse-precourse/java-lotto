package lotto;

import lotto.controller.LottoGenerator;
import lotto.controller.ValidationException;
import lotto.model.UserLottoNum;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.controller.LottoGenerator.generateLottoNumber;

public class LottoManager {

    UserLottoNum userLottoNum;

    public void userWantLotto() {

        List<Lotto> lottoNumbers;
        String userMoney = InputView.priceInput();

        if (ValidationException.checkValidPrice(userMoney)) {
            lottoNumbers = LottoGenerator.startLottoGenerate(userMoney);
            userLottoNum = new UserLottoNum(lottoNumbers);
            OutputView.printUserLotto(userLottoNum.getUserLottoNumbers());
        }
    }

    /*public void setLottoNumbers() {

    }
*/
}
