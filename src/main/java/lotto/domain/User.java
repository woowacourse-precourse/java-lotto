package lotto.domain;

import lotto.constant.LotteryRank;
import lotto.constant.Status;
import lotto.domain.constant.LottoProperty;
import lotto.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class User {
    private int money;
    private int numberOfTickets;
    private List<LotteryTicket> lotteryTickets;
    private LotteryResult lotteryResult;

    public User (int money) throws IllegalArgumentException {
        validate(money);
        this.money = money;
        numberOfTickets = Status.EMPTY.getStatus();
        lotteryTickets = new ArrayList<>();
        lotteryResult = new LotteryResult();
    }

    public void validate (int money) throws IllegalArgumentException {
        if (!isMultipleOfThousand(money)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_AMOUNT.getErrorMessage());
        }
    }

    private boolean isMultipleOfThousand (int money) {
        return money % LottoProperty.PRICE.getProperty() == Status.EMPTY.getStatus();
    }

    public void buyLotteryTicket(LotteryTicket lotteryTicket) {
        money -= LottoProperty.PRICE.getProperty();
        lotteryTickets.add(lotteryTicket);
        numberOfTickets++;
    }

    public List<List<Integer>> findAllLotteryNumbers() {
        List<List<Integer>> lotteryNumbers = new ArrayList<>();
        return lotteryTickets.stream().map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }

    public void addResult(String id, LotteryRank rank) {
        lotteryResult.add(id, rank);
    }

    public Map<LotteryRank, Integer> countWinningTickets() {
        return lotteryResult.findWinningInformation();
    }

    public boolean hasMoney() {
        return money > Status.EMPTY.getStatus();
    }

    public int getMoney() {
        return money;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public long getTotalReward() {
        return lotteryResult.getTotalReward();
    }

    public List<LotteryTicket> getLotteryTickets() {
        return new ArrayList<>(lotteryTickets);
    }
}
