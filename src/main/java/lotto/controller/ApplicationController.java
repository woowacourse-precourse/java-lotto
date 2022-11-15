package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Player;
import lotto.model.Seller;
import lotto.model.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.enums.Ranking;
import lotto.ConvertUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ApplicationController {
    Seller seller = new Seller();
    Player player = new Player();
    InputValidator inputValidator = new InputValidator();
    ConvertUtil convertUtil = new ConvertUtil();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void startApplication() {
        String input_purchaseAmount = inputView.inputPurchaseAmount();
        int purchaseAmount = convertUtil.StringIntoInt(input_purchaseAmount);
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
        List<Integer> winningNumber = convertUtil.StringIntoList(input_WinningNumber);
        inputValidator.validateWinningNumber(winningNumber);
        player.setWinningNumber(winningNumber);

        control_BonusNumber();
    }

    public void control_BonusNumber() {
        String input_BonusNumber = inputView.inputBonusNumber();
        int bonusNumber = convertUtil.StringIntoInt(input_BonusNumber);
        inputValidator.validateBonusNumber(bonusNumber, player.getWinningNumber());
        player.setBonusNumber(bonusNumber);

        control_WinningResult();
    }

    public void control_WinningResult() {
        player.registerWinningResult();
        List<Ranking> winningResult = Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.getMatchingNumbers() > Ranking.NOTHING.getMatchingNumbers())
                .collect(Collectors.toList());
        outputView.printWinningResult(winningResult);

        control_LottoYield();
    }

    public void control_LottoYield() {
        //TODO
        //  - [x] 총 당첨금 계산
        //  - [x] 수익률 계산
        //  - [ ] 수익률 출력
        player.registerTotalPrize();
        player.registerLottoYield();
    }
}
