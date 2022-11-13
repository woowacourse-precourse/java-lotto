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
        player.setPurchaseAmount(purchaseAmount);

        inputValidator.validatePurchaseAmount(player.getPurchaseAmount());
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
        // TODO: 당첨 번호 저장
    }
}
