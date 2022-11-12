package lotto.controller;

import lotto.domain.User;
import lotto.service.DrawLottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class DrawLottoController {

    DrawLottoService drawLottoService = new DrawLottoService();
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    User user = new User();

    public void startDrawLotto() {
        buyLottoFromMyAmount();
        setWiningLottoNumver();
        drawLotto();
        setWiningCount();
        printWiningCount(drawLottoService.getWiningCount());
        outputView.printRevenue(getRevenue());
    }

    private void buyLottoFromMyAmount() {
        outputView.printBuyAmountMessage();
        user.setBuyAmount(inputView.InputBuyAmount());
        int count = drawLottoService.countBuyingLotto(user.getBuyAmount());
        buyLotto(count);
        outputView.printCountBuyingLotto(count, user.getMyLotto());
    }

}
