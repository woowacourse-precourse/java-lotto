package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

import lotto.constant.LottoStatistic;

public class Machine {
    public Machine() {
    }
    public List<Lotto> issueLottoTickets(long money) {
        long numberOfTickets = money / LottoStatistic.LOTTO_PRICE.getValue();
        List<Lotto> lottoTickets = new ArrayList<>();
        for (long number = 0; number < numberOfTickets; number++) {
            lottoTickets.add(createSingleLottoTicket());
        }
        return lottoTickets;
    }

    public Lotto createSingleLottoTicket() {
        List<Integer> sortedRandomNumbers = Randoms.pickUniqueNumbersInRange(LottoStatistic.MIN_NUMBER.getValue(),
                LottoStatistic.MAX_NUMBER.getValue(), LottoStatistic.NUMBER_OF_LOTTERY_NUMBERS.getValue());
        return new Lotto(sortedRandomNumbers);
    }

    /*public List<Integer> createSortedRandomNumbers(int start, int end, int count) {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(start, end, count);
        Collections.sort(randomNumbers);
        return randomNumbers;
    }*/
}
