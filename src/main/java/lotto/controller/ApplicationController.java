package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Player;
import lotto.model.Seller;
import lotto.model.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class ApplicationController {
    Seller seller = new Seller();
    Player player = new Player();
    InputValidator inputValidator = new InputValidator();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void startApplication() {
        String input_purchaseAmount = inputView.inputPurchaseAmount();
        int purchaseAmount = inputValidator.convertStringIntoInt(input_purchaseAmount);
        inputValidator.validatePurchaseAmount(purchaseAmount);
        player.setPurchaseAmount(purchaseAmount);

        control_CountIssueingLotto();
    }

    public void control_CountIssueingLotto() {
        int lottocount = seller.countIssueingLotto(player.getPurchaseAmount());
        player.setLottoCount(lottocount);
        outputView.printLottoCount(player.getLottoCount());

        control_IssueingLotto();
    }

    public void control_IssueingLotto() {
        List<Lotto> lottoNumbers = seller.issueLotto(player.getLottoCount());
        player.setLottoNumbers(lottoNumbers);
        outputView.printLottoNumber(player.getLottoNumbers());

        control_WinningNumber();
    }

    public void control_WinningNumber() {
        String input_WinningNumber = inputView.inputWinningNumber();
        List<Integer> winningNumber = inputValidator.convertStringIntoList(input_WinningNumber);
        inputValidator.validateWinningNumber(winningNumber);
        player.setWinningNumber(winningNumber);

        control_BonusNumber();
    }

    public void control_BonusNumber() {
        String input_BonusNumber = inputView.inputBonusNumber();
        int bonusNumber = inputValidator.convertStringIntoInt(input_BonusNumber);
        inputValidator.validateBonusNumberBetween1And45(bonusNumber);
        player.setBonusNumber(bonusNumber);

        control_WinningResult();
    }

    public void control_WinningResult() {
        //TODO
        //  - [ ] 당첨 결과 계산
        //  - [ ] 당첨 내역 저장
        //  - [ ] 당첨 내역 출력

        //TODO: 수익률 계산 과정 제어 기능 호출
    }
}
