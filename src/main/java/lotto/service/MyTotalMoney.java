package lotto.service;

import java.util.List;

public class MyTotalMoney {
    WinningMoney winningMoney = new WinningMoney();

    public int totalMoney(List<List<Integer>> myLottos, List<Integer> winningNumbers, int bonusNumber) {
        int myTotal = 0;

        for (int i = 0; i < myLottos.size(); i++) {
            myTotal += winningMoney.getMyMoney(winningNumbers, myLottos.get(i), bonusNumber);
        }

        return myTotal;
    }
}