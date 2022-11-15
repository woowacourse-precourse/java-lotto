package lotto.domain.impl;

import lotto.Lotto;
import lotto.Rank;
import lotto.domain.Output;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static lotto.Constants.COUNT_DEFAULT_VALUE;
import static lotto.Rank.*;
import static lotto.message.ExceptionMessage.PREFIX;
import static lotto.message.Message.*;

public class OutputImpl implements Output {

    @Override
    public void issuedLottos(List<Lotto> lottos) {
        String message = String.format(RESPONSE_LOTTO_SIZE, lottos.size());
        System.out.println(message);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    @Override
    public void results(Map<Rank, Integer> results) {
        System.out.println(RESULTS);
        System.out.println(DIV_LINE);
        for (Rank rank : Arrays.asList(FIFTH, FOURTH, THIRD, SECOND, FIRST)) {
            int count = results.getOrDefault(rank, COUNT_DEFAULT_VALUE);
            System.out.println(rank.getMessage(count));
        }
    }

    @Override
    public void rate(double rate) {
        String message = String.format(RESPONSE_RATE, rate);
        System.out.println(message);
    }

    @Override
    public void exceptionMessage(IllegalArgumentException e) {
        System.out.println(PREFIX + e.getMessage());
    }
}
