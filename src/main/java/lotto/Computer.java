package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Computer {

    public List<Integer> getLottoNumber() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumber;
    }

    public Double getEarningRate(Integer pay, HashMap<Integer, Integer> checkWin) {
        Integer totalWinMoney = checkWin.get(3) * 5000 +
                checkWin.get(4) * 50000 +
                checkWin.get(5) * 1500000 +
                checkWin.get(1) * 30000000 +
                checkWin.get(6) * 2000000000;
        Double totalEarning = totalWinMoney*1.0/pay*100;
        System.out.println(totalEarning);
        return totalEarning;
    }
}
