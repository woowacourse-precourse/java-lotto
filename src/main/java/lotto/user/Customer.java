package lotto.user;

import lotto.ValidCheck;
import lotto.enumeration.ConsoleAlert;
import lotto.enumeration.LottoRankInformation;
import lotto.store.Lotto;
import lotto.store.LottoDraw;
import lotto.store.LottoMachine;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class Customer {
    private final List<Lotto> lotteries;
    private final Map<LottoRankInformation, Integer> rankings = createRankings();
    private final int pay;

    public Customer(String readline) {
        ValidCheck.isNumeric(readline);
        this.pay = Integer.parseInt(readline);
        lotteries = buyLotteries(pay);
    }

    private List<Lotto> buyLotteries(int pay) {
        return LottoMachine.getInstance().pickLotteries(pay);
    }

    public String toLottoString() {
        StringJoiner currentLotteries = new StringJoiner("\n");

        currentLotteries.add(lotteries.size() + ConsoleAlert.NUMBER_OF_PURCHASES_PHRASE.toAlertString());
        lotteries.forEach(lotto -> currentLotteries.add(lotto.toString()));
        return currentLotteries.toString();
    }

    public List<Integer> matchWinNumbers(List<Integer> winNumbers) {
        return lotteries.stream()
                .map(lottoNumbers -> lottoNumbers.compareWinNumbers(winNumbers))
                .collect(Collectors.toList());
    }

    public List<Boolean> matchBonusNumber(int bonusNumber, List<Integer> matchNumbers) {
        ValidCheck.isDuplication(bonusNumber, matchNumbers);
        AtomicInteger startIndex = new AtomicInteger();

        return lotteries.stream().map(matchNumber -> {
            if (matchNumbers.get(startIndex.getAndIncrement()) == 5) {
                return matchNumber.compareBonusNumber(bonusNumber);
            }
            return false;
        }).collect(Collectors.toList());
    }

    public Map<LottoRankInformation, Integer> createWinnings(String winNumbers, String bonusNumber) {
        List<Integer> matchNumbers = matchWinNumbers(LottoDraw.getInstance().pickWinNumbers(winNumbers));
        List<Boolean> matchBonus = matchBonusNumber(LottoDraw.getInstance().pickBonusNumber(bonusNumber), matchNumbers);
        return inputRankings(matchNumbers, matchBonus);
    }

    private Map<LottoRankInformation, Integer> inputRankings(List<Integer> matchNumbers, List<Boolean> matchBonus) {
        AtomicInteger startIndex = new AtomicInteger();

        while (startIndex.get() < matchNumbers.size()) {
            int matchNumber = matchNumbers.get(startIndex.get());
            LottoRankInformation lottoRankInformation = LottoRankInformation
                    .makeLottoRankInformation(matchNumber, matchBonus.get(startIndex.getAndIncrement()));
            rankings.put(lottoRankInformation, rankings.get(lottoRankInformation) + 1);
        }
        return rankings;
    }

    private Map<LottoRankInformation, Integer> createRankings() {
        return new HashMap<>() {{
            Arrays.asList(LottoRankInformation.values()).forEach(LottoRankInformation -> put(LottoRankInformation, 0));
        }};
    }

    private long calculateWinnings() {
        AtomicLong winnings = new AtomicLong();
        rankings.forEach((ranking, count) -> winnings.addAndGet(ranking.getWinnings(count)));
        return winnings.get();
    }

    private double calculateEarningRate(long winnings) {
        double earningRate = (winnings / (double) pay) * 100;
        return Math.round(earningRate * 10) / 10.0;
    }

    public String toResultString() {
        StringJoiner resultAlert = new StringJoiner("\n");
        resultAlert.add(ConsoleAlert.RESULT_PHRASE.toAlertString());
        Arrays.stream(LottoRankInformation.values())
                .filter(LottoRankInformation -> LottoRankInformation.getMatchNumber() >= 3)
                .forEach(LottoRankInformation -> resultAlert.add(LottoRankInformation.getInformation(rankings.get(LottoRankInformation))));
        resultAlert.add(String.format(ConsoleAlert.RESULT_EARNING_RATE_PHRASE.toAlertString(),
                calculateEarningRate(calculateWinnings())));
        return resultAlert.toString();
    }

}
