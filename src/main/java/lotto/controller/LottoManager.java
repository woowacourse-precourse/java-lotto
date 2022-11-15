package lotto.controller;

import lotto.model.Lotto;
import lotto.model.UserLottoNum;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoManager {

    public UserLottoNum userLottoNum;
    public Lotto targetLottoNum;
    public int bonusNumber;
    public CountRank countRank;
    public Calculator calculator;
    String userMoney;


    public LottoManager() {
        countRank = new CountRank();
        calculator = new Calculator();
    }

    public void startLotto() {
        userWantLotto();
        setWinningLottoNum();
        setBonusNumber();
        countRank.doMatchNumber(userLottoNum, targetLottoNum, bonusNumber);
        calculator.calculatePercent(countRank.scoreBoard, Integer.parseInt(userMoney));

    }

    public void userWantLotto() {

        List<Lotto> lottoNumbers;
        userMoney = InputView.priceInput();

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
