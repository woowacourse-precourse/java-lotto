package lotto;

import lotto.controller.LottoGenerator;
import lotto.controller.ValidationException;
import lotto.model.Lotto;
import lotto.model.UserLottoNum;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoManager {

    UserLottoNum userLottoNum;
    Lotto targetLottoNum;
    int bonusNumber;

    public void userWantLotto() {

        List<Lotto> lottoNumbers;
        String userMoney = InputView.priceInput();

        if (ValidationException.checkValidPrice(userMoney)) {
            lottoNumbers = LottoGenerator.startLottoGenerate(userMoney);
            userLottoNum = new UserLottoNum(lottoNumbers);
            OutputView.printUserLotto(userLottoNum.getUserLottoNumbers());
        }
    }

    public void setWinningLottoNum() {

        String winningNumber = InputView.lottoInput();

        if (ValidationException.checkValidTargetNumber(winningNumber)) {
            targetLottoNum = new Lotto(LottoGenerator.splitTargetLotto(winningNumber));
        }
    }

    public void setBonusNumber() {
        String bonusInput = InputView.bonusInput();
        this.bonusNumber = Integer.parseInt(bonusInput);
    }



}
