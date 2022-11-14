package lotto.store;

import lotto.ValidCheck;
import lotto.enumeration.LottoInformation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LottoMachine {
    private static LottoMachine lottoMachine;

    private LottoMachine() {
    }

    public static LottoMachine getInstance() {
        if (lottoMachine == null) {
            lottoMachine = new LottoMachine();
        }
        return lottoMachine;
    }

    private List<Integer> extractRandomNumbers() {
        return camp.nextstep.edu.missionutils.Randoms
                .pickUniqueNumbersInRange(LottoInformation.START_LOTTO_NUMBER_RANGE.toInteger(),
                        LottoInformation.END_LOTTO_NUMBER_RANGE.toInteger(),
                        LottoInformation.LOTTO_NUMBERS.toInteger());
    }

    private Lotto convertLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void putLotteries(List<Lotto> lotteries, Lotto lotto) {
        lotteries.add(lotto);
    }

    public List<Lotto> pickLotteries(int pay) {
        ValidCheck.isPayUnit(pay);
        AtomicInteger startIndex = new AtomicInteger();
        List<Lotto> lotteries = new ArrayList<>();

        while (startIndex.getAndIncrement() < pay / LottoInformation.LOTTO_PRICE.toInteger()) {
            putLotteries(lotteries, convertLotto(extractRandomNumbers()));
        }
        return lotteries;
    }

}
