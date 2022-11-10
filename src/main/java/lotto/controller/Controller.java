package lotto.controller;

import lotto.service.Service;

public class Controller {

    public static void lottoStart() {

        int money = Service.getMoney();
        int volume = Service.getVolume(money);

        Service.getLotto(volume);
    }
}
