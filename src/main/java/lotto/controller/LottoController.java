package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoEnum;
import lotto.model.RANKING;

public class LottoController {

    public List<Lotto> createLotteries(int count) {
        if (count < LottoEnum.MIN_TOTAL_LOTTERIES.getValue()) {
            throw new IllegalArgumentException();
        }
        List<Lotto> lotteries = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lotteries.add(createLotto());
        }
        return lotteries;
    }

    private Lotto createLotto() {
        return new Lotto(createLottoNumbers());
    }

    private List<Integer> createLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
            LottoEnum.MIN_LOTTO_NUMBER.getValue(), LottoEnum.MAX_LOTTO_NUMBER.getValue(),
            LottoEnum.TOTAL_LOTTO_NUMBER.getValue());
        numbers.sort(Comparator.comparingInt(number -> number));
        return numbers;
    }

    public List<RANKING> generateRankings(List<Lotto> lotteries, Lotto luckyLotto,
        int luckyNumber) {
        List<RANKING> rankings = new LinkedList<>();
        for (final Lotto lotto : lotteries) {
            RANKING ranking = lotto.matchLottoWithLuckyNumber(luckyLotto, luckyNumber);
            rankings.add(ranking);
        }
        return rankings;
    }

    public double generateEarningsRate(List<Lotto> lotteries, Lotto luckyLotto, int luckyNumber) {
        double acc = 0;
        for (final Lotto lotto : lotteries) {
            RANKING ranking = lotto.matchLottoWithLuckyNumber(luckyLotto, luckyNumber);
            acc += ranking.getPrice();
        }
        return acc / (lotteries.size() * 1000) * 100;
    }
}
