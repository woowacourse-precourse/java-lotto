package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.WiningNumber;
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
    WiningNumber winingNumber;
    Lotto lotto;

    public void startDrawLotto() {
        buyLottoFromMyAmount();
        setWiningLottoNumber();
        drawLotto();
        setWiningCount();
        printWiningCount(drawLottoService.getWiningCount());
        outputView.printRevenue(getRevenue());
    }

    private void buyLottoFromMyAmount() {
        outputView.printBuyAmountMessage();
        user.setBuyAmount(inputView.InputBuyAmount());
        int buyLottoCount = drawLottoService.countBuyingLotto(user.getBuyAmount());
        buyLotto(buyLottoCount);
        outputView.printCountBuyingLotto(buyLottoCount, user.getMyLotto());
    }

    private void buyLotto(int count) {
        for (int i = 0; i < count; i++) {
            lotto = new Lotto(createLottoNumber.createLottoNumber());
            user.setMyLotto(lotto);
        }
    }

    private void setWiningLottoNumber() {
        outputView.printWiningNumberMessage();
        winingNumber = new WiningNumber(drawLottoService.getListToWiningNumber(inputView.InputWiningNumbers()));
        outputView.printBonusNumberMessage();
        winingNumber.setBonusNumber(inputView.InputBonusNumber());
    }

    private void drawLotto() {
        for (Lotto myLotto : user.getMyLotto()) {
            drawLottoService.compareLottoToWiningLotto(winingNumber.getWiningNumber()
                    , myLotto, winingNumber.getBonusNumber());
        }
    }

    private void setWiningCount() {
        drawLottoService.setWiningCount();
        outputView.printWiningCountStatistics();
    }

    private void printWiningCount(List<Integer> winingCount) {
        outputView.printWiningCount(winingCount);
    }

    private double getRevenue() {
        drawLottoService.setReward();
        return drawLottoService.getRevenue(user.getBuyAmount());
    }
}
