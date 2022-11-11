package lotto.controller;

import lotto.service.Service;

public class Controller {
    Service service = new Service();

    public void run(){
        startLottoGame();
    }

    public void startLottoGame(){
        service.initBuyer();
        service.buyAllLotto();
        service.showBuyingResult();
    }
}
