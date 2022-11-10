package lotto.controller;

import lotto.Lotto;
import lotto.service.Service;

import java.util.List;

public class Controller {

    public static void lottoStart() {

        int money = Service.getMoney();
        int volume = Service.getVolume(money);

        List<Lotto> lotto = Service.getLotto(volume);
        List<List<Integer>> lottoList = Service.getLottoList(lotto);
        String jackpotNum = Service.getJackpotNumber();
        String[] jackpotNumArr = Service.getJackpotNumberToArr(jackpotNum);
        int bonusNum = Service.getBonusNumber();

        for(int i = 0; i < lottoList.size(); i++) {
            List<Integer> temp = lottoList.get(i);
            Service.checkLotto(temp, jackpotNumArr, bonusNum);
            Service.checkRank();
        }

        int winningPrice = Service.getWinningPrice();
        Service.getEarningsRate(winningPrice, money);
    }
}
