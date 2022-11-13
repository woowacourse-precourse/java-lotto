package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.LotteryTicket;
import lotto.domain.constant.LottoProperty;

import java.util.List;

public class LotterySellService {
    public LotteryTicket createLotteryTicket() {
        List<Integer> lotteryNumbers = generateLotteryNumbers();
        return new LotteryTicket(lotteryNumbers);
    }

    private List<Integer> generateLotteryNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoProperty.MIN_NUMBER.getProperty(),
                LottoProperty.MAX_NUMBER.getProperty(),
                LottoProperty.LENGTH.getProperty()
        );
    }
}
