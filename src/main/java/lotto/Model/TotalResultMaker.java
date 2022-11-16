package lotto.Model;

import lotto.resources.Rank;
import lotto.resources.Constants;

import java.text.DecimalFormat;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

import java.util.stream.IntStream;

import java.util.concurrent.atomic.AtomicReference;

public class TotalResultMaker {

    private int bonusCase;
    private List<Integer> resultTable = new ArrayList<>();;

    public TotalResultMaker(List<Integer> answerResult, List<Integer> bonusResult) {
        this.bonusCase = Constants.ZERO.getValue();
        this.resultTable = calculateResult(answerResult, bonusResult);
    }

    public List<Integer> calculateResult(List<Integer> answerResult, List<Integer> bonusResult) {
        for (int i = 0; i < Constants.LOTTO_LENGTH.getValue() + 1; i++) {
            resultTable.add(Constants.ZERO.getValue());
        }
        for (int i = 0; i < answerResult.size(); i++) {
            int beforeAdd = resultTable.get(answerResult.get(i));
            resultTable.set(answerResult.get(i), beforeAdd + 1);
            checkBonus(i, answerResult, bonusResult);
        }
        int beforeBonus5 = resultTable.get(Constants.BONUS_INDEX.getValue());
        resultTable.set(Constants.BONUS_INDEX.getValue(), beforeBonus5 - bonusCase);

        return resultTable;
    }
    private void checkBonus(int index, List<Integer> answerResult, List<Integer> bonusResult) {
        if (Objects.equals(answerResult.get(index), Constants.BONUS_INDEX.getValue()) &&
                Objects.equals(bonusResult.get(index), Constants.BONUS_EXIST.getValue())) {
            bonusCase++;
        }
    }

    public String printLottoResult() {
        StringBuilder sb = new StringBuilder();
        int i = 3;
        for (Rank rank : Rank.values()) {
            if (rank == Rank.BONUS) {
                sb.append(String.format("5개 일치, 보너스 볼 일치 (%s원) - %d개\n", setCommaInPrint(rank.getMoney()), bonusCase));
                continue;
            }
            sb.append(String.format("%d개 일치 (%s원) - %d개", rank.getRank(), setCommaInPrint(rank.getMoney()),
                    resultTable.get(i++)));
            if (i <= 6) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public Double calculateYieldRate(long purchaseLottoCnt) {

        AtomicReference<Long> totalSum = new AtomicReference<>(0L);
        IntStream.range(Constants.RANK_START.getValue(), Constants.LOTTO_LENGTH.getValue() + 1)
                .forEach(i -> totalSum.updateAndGet(v -> v + Rank.getMoney(i) * resultTable.get(i)));
        float totalSumAndBonus = totalSum.get();
        totalSumAndBonus += Rank.getMoney(Constants.LOTTO_LENGTH.getValue() + Constants.ONE.getValue()) * bonusCase;
        int divisor = (int) (purchaseLottoCnt * Constants.CURRENCY.getValue());
        if (purchaseLottoCnt == Constants.ZERO.getValue()) {
            divisor = Constants.ONE.getValue();
        }
        double yieldRate = (totalSumAndBonus / divisor * Constants.HUNDRED.getValue());
        return (yieldRate);
    }

    public String setCommaInPrint(long money) {
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(money);
    }
}