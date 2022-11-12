package lotto.controller;

import lotto.service.Service;

public class Controller {
    Service service = new Service();

    public void run(){
        beforeLottoGame();
        playLottoGame();
        showGameResult();
    }

    public void beforeLottoGame(){
        service.initBuyer();
        service.buyAllLotto();
        service.showBuyingResult();
    }

    public void playLottoGame(){
        service.playLottoGame();
    }

    public void showGameResult(){
        service.checkBuyerLotteries();
        service.showGameResult();
    }
}
