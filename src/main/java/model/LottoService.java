package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static model.WinningNumberStatus.*;

public class LottoService {
    public List<Lotto> issueLotto(int money) {
        List<Lotto> lotteries = new ArrayList<>();

        for (int i = 0; i < getCount(money); i++) {
            List<Integer> numbers = createLottoNumbers();
            Collections.sort(numbers);
            lotteries.add(new Lotto(numbers));
        }
        return lotteries;
    }

    private List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                        LottoStatus.START.getValue(),
                        LottoStatus.END.getValue(),
                        LottoStatus.SIZE.getValue());
    }

    private int getCount(int money) {
        return money / LottoStatus.PRICE.getValue();
    }

    public double getEarning(HashMap<Integer, Integer> count) {
        double earning = 0;
        for (int rank = FIRST.getOrder(); rank <= FIFTH.getOrder(); rank++) {
            WinningNumberStatus winningNumberStatus = getWinningNumberStatusByOrder(rank);
            earning += count.get(rank) * winningNumberStatus.getMoney();
        }
        return earning;
    }

    public double getEarningRate(int purchasingAmount, double earning) {
        return (earning / purchasingAmount) * 100;
    }
}
