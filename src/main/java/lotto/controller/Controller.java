package lotto.controller;

import lotto.service.Service;

public class Controller {

    public static void lottoStart() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Service.getMoney();
        int volume = Service.getVolume(money);
        System.out.println(volume + "개를 구매했습니다.");
    }
}
