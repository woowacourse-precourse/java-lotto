package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoInput;
import lotto.model.LottoResult;
import lotto.util.InputValidator;

import java.util.List;

public class InputController {
    LottoInput lottoInput;

    public InputController(LottoInput lottoInput) {
        this.lottoInput = lottoInput;
    }

    public void getPurchaseAmount(){
        int purchaseAmount = lottoInput.inputPurchaseAmount();
        InputValidator.validatePurchaseAmount(purchaseAmount);

        LottoResult.purchaseAmount = purchaseAmount;
        LottoResult.count = purchaseAmount/LottoInput.LOTTO_COST;

        LottoResult.showPurchaseCount(LottoResult.count);
    }

    public void inputWinNumber(){
        List<Integer> winNumbers = lottoInput.inputWinNumber();
        InputValidator.validateLotto(winNumbers);
        LottoResult.winNumber = new Lotto(winNumbers);
    }

    public void inputBonusNumber(){
        int bonusNumber = lottoInput.inputBonusNumber();
        InputValidator.validateLottoNumberRange(bonusNumber);
        LottoResult.bonusNumber = bonusNumber;
    }
}
