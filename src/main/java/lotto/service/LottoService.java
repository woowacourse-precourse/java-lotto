package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoStatus;
import lotto.domain.WinningNumberStatus;
import lotto.dto.ResultResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {
    public List<Lotto> issueLotto(int money) {
        List<Lotto> lotteries = new ArrayList<>();

        for (int count = 0; count < getCount(money); count++) {
            List<Integer> numbers = getNumbers();
            Collections.sort(numbers);
            lotteries.add(new Lotto(numbers));
        }
        return lotteries;
    }

    private List<Integer> getNumbers() {
        return new ArrayList<>(createLottoNumbers());
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

    public double getEarning(ResultResponse count) {
        double earning = 0;
        for (int rank = WinningNumberStatus.FIRST.getOrder(); rank <= WinningNumberStatus.FIFTH.getOrder(); rank++) {
            WinningNumberStatus winningNumberStatus = WinningNumberStatus.getWinningNumberStatusByOrder(rank);
            earning += count.getResult().get(rank) * winningNumberStatus.getMoney();
        }
        return earning;
    }

    public double getEarningRate(int purchasingAmount, double earning) {
        return (earning / purchasingAmount) * 100;
    }
}
