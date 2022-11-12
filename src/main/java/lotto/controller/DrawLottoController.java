package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.service.DrawLottoService;
import lotto.util.CreateLottoNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class DrawLottoController {

    DrawLottoService drawLottoService = new DrawLottoService();
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    CreateLottoNumber createLottoNumber = new CreateLottoNumber();
    User user = new User();
    Lotto lotto;
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

    private void buyLotto(int count){
        for (int i =0;i<count;i++){
            lotto = new Lotto(createLottoNumber.createLottoNumber());
            user.setMyLotto(lotto);
        }
    }
}
