package lotto.domain;

import lotto.utils.Ranking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.utils.LottoInformation.LOTTO_SELECTION_COUNT;
import static lotto.utils.LottoInformation.LOTTO_BONUS_NUMBER_COUNT;

public class Statistics {
    private final Ticket ticket;
    private final Answer answer;
    private final Map<Ranking, Integer> counter = new HashMap<>();
    private double returnRate;

    public Statistics(Ticket ticket, Answer answer) {
        counter.put(Ranking.RANK6, 0);
        counter.put(Ranking.RANK5, 0);
        counter.put(Ranking.RANK4, 0);
        counter.put(Ranking.RANK3, 0);
        counter.put(Ranking.RANK2, 0);
        counter.put(Ranking.RANK1, 0);
        this.ticket = ticket;
        this.answer = answer;

        setCounter();
        setReturnRate();
    }

    private void setCounter() {
        Ranking ranking;

        for (Lotto lotto : ticket.getLottos()) {
            int match = countMatch(answer.getWinningNumbers(), lotto.getNumbers());
            boolean bonus = false;

            if (match == LOTTO_SELECTION_COUNT - LOTTO_BONUS_NUMBER_COUNT) {
                bonus = isExistIn(answer.getBonusNumber(), lotto.getNumbers());
            }
            ranking = Ranking.getRanking(match, bonus);
            counter.put(ranking, counter.get(ranking));
        }
    }

    private void setReturnRate() {
        double rate;
        long sumPrize = 0;

        for (Ranking ranking : counter.keySet()) {
            sumPrize += ranking.getPrize() * counter.get(ranking);
        }
        rate = sumPrize / (double) ticket.getPrice();
        returnRate = Double.parseDouble(String.format("%.1f", rate));
    }

    private int countMatch(List<Integer> expected, List<Integer> actual) {
        int count = 0;
        for (int number : expected) {
            if (actual.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean isExistIn(int number, List<Integer> numbers) {
        return numbers.contains(number);
    }

    public double getReturnRate() {
        return returnRate;
    }

    public int getCount(int match, boolean bonus) {
        return counter.get(Ranking.getRanking(match, bonus));
    }
}