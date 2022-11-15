package lotto.domain;

import java.text.DecimalFormat;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lotto.Prize;

public class Bank {
    private PrizeCount prizeCount;
    private int totalPrizeMoney;
    private int lottoAmount;
    List<Lotto> purchasedLottos;
    Lotto targetWinningLotto;
    DecimalFormat decimalFormat;

    public Bank(List<Lotto> purchasedLottos, Lotto targetWinningLotto, int lottoAmount) {
        prizeCount = new PrizeCount();
        this.purchasedLottos = purchasedLottos;
        this.targetWinningLotto = targetWinningLotto;
        this.totalPrizeMoney = 0;
        this.lottoAmount = lottoAmount;
        decimalFormat = new DecimalFormat("###,###");
    }

    public void returnLottoResult(int bonusNumber) {
        calculateLottoResult(bonusNumber);
        printLottoResult();
        printReturnRate();
    }

    private void calculateLottoResult(int bonusNumber) {
        for (Lotto lotto : purchasedLottos) {
            List<Integer> targetNumbers = targetWinningLotto.getNumbers();
            List<Integer> purchaseNumbers = lotto.getNumbers();
            boolean hasBonus = purchaseNumbers.contains(bonusNumber);
            List<Integer> equalNumbers = purchaseNumbers.stream()
                    .filter(target -> targetNumbers.stream()
                            .anyMatch(Predicate.isEqual(target)))
                    .collect(Collectors.toList());
            int matchAmount = equalNumbers.size();
            prizeCount.addPrize(Prize.calculatePrize(matchAmount, hasBonus));
        }
    }

    private void printLottoResult() {
        System.out.println("당첨통계");
        System.out.println("---");
        for (Prize prize : Prize.values()) {
            String bonusPhrase = "";
            if (prize.equals(Prize.MISS)) {
                continue;
            }
            if (prize.equals(Prize.SECOND)) {
                bonusPhrase = ", 보너스 볼 일치";
            }
            int matchCount = prizeCount.getPrize(prize);
            int prizeMoney = prize.getMoney();
            int matchAmount = prize.getMatchAmount();

            accumulateTotalPrizeMoney(matchCount * prizeMoney);
            System.out.println(
                    matchAmount + "개 일치" + bonusPhrase + " (" + decimalFormat.format(prizeMoney) + "원)" + " - "
                            + matchCount + "개");
        }
    }

    private void printReturnRate() {
        double investmentCost = lottoAmount * 1000;
        double returnRate = (double) Math.round(totalPrizeMoney / investmentCost * 10000) / 100.0;
        System.out.println("총 수익률은 " + returnRate + "%입니다.");
    }

    private void accumulateTotalPrizeMoney(int money) {
        totalPrizeMoney += money;
    }
}
