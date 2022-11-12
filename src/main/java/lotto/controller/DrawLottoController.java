package lotto.controller;

import lotto.service.DrawLottoService;
import lotto.view.OutputView;

public class DrawLottoController {

    DrawLottoService drawLottoService = new DrawLottoService();
    OutputView outputView = new OutputView();

    public void startDrawLotto(){
        buyLottoFromMyAmount();
        setWiningLottoNumver();
        drawLotto();
        setWiningCount();
        printWiningCount(drawLottoService.getWiningCount());
        outputView.printRevenue(getRevenue());
    }
}
