package lotto.service;

import java.util.List;

public class MyTotalMoney {
    BuyLotto buyLotto = new BuyLotto();
    WinningMoney winningMoney = new WinningMoney();

    public int totalMoney(int money, List<Integer> winningNumbers, int bonusNumber) {
        int myTotal = 0;
        List<List<Integer>> myLottos = buyLotto.buyLotto(money);

        for (int i = 0; i < myLottos.size(); i++) {
            myTotal += winningMoney.getMyMoney(winningNumbers, myLottos.get(i), bonusNumber);
        }

        return myTotal;
    }
}