package lotto.service;


import lotto.domain.Exchange;
import lotto.domain.PrizeLotto;
import lotto.domain.Users;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class LottoServiceImpl implements LottoService {

    private final String WINNING_STATISTICS = "당첨 통계";
    private final String DIVIDING_LINE = "---";
    private final String ROUND_UNIT = "%.1f";
    private final String YIELD_MESSAGE = "총 수익률은 ";
    private final String PERCENT_MESSAGE = "%입니다.";
    private final String COUNT = "개";


    @Override
    public void run() {
        Users user = new Users();
        PrizeLotto prizeLotto = new PrizeLotto();
        Long yield = matchLotto(user, prizeLotto);
        printYieldMessage(yield, user);
    }

    Long matchLotto(Users user, PrizeLotto prizeLotto) {
        printStatisticsMessage();
        Map<Exchange, Long> matches = getMatches(user, prizeLotto);
        return getMoney(matches);
    }

    Map<Exchange, Long> getMatches(Users user, PrizeLotto prizeLotto) {
        return user.getLottos().stream()
                .map(lotto -> this.getRank(
                        getMatchResult(lotto.getNumbers(), prizeLotto.getLotto().getNumbers()),
                        isContainBonus(lotto.getNumbers(), prizeLotto.getBonus()))
                )
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    Integer getMatchResult(List<Integer> numbers, List<Integer> target) {
        return Math.toIntExact(numbers.stream()
                .filter(target::contains)
                .count());
    }

    boolean isContainBonus(List<Integer> numbers, Integer bonus) {
        return numbers.stream()
                .anyMatch(number -> number.equals(bonus));
    }

    Exchange getRank(Integer match, boolean bonus) {
        return Arrays.stream(Exchange.values())
                .filter(value -> value.isMatch(match))
                .filter(value -> value.isBonus(bonus))
                .findAny()
                .orElse(Exchange.NOTHING);
    }

    Long getMoney(Map<Exchange, Long> result) {
        long money = 0L;
        for (Exchange value : Exchange.values()) {
            if (result.containsKey(value)) {
                long count = result.get(value);
                money += count * value.getPrice();
                printExchangeCount(value.getMessage(), count);
            }
            if (!result.containsKey(value)) {
                printExchangeCount(value.getMessage(), 0);
            }
        }
        return money;
    }

    void printExchangeCount(String message, long count) {
        System.out.println(message + count + COUNT);
    }

    void printStatisticsMessage() {
        System.out.println(WINNING_STATISTICS);
        System.out.println(DIVIDING_LINE);
    }

    void printYieldMessage(Long yield, Users user) {
        System.out.println(YIELD_MESSAGE + String.format(ROUND_UNIT, calculateYield(yield, user.getPrice())) + PERCENT_MESSAGE);
    }

    double calculateYield(Long son, Integer mom) {
        return (((double) son * 100.0) / (double) mom);
    }
}
