package lotto.domain;

import lotto.messages.ERR_MSG;
import lotto.service.LottoPurchaseService;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//public class Statistic {
//    private final LottoPurchaseService purchaseLottoService;
//    private final Winning winning;
//    private final Map<Integer, Integer> winningGradeAndCountRepository;
//    private final double yield;
//
//    public Statistic(LottoPurchaseService lottoPurchaseService, Winning winning) {
//        this.purchaseLottoService = lottoPurchaseService;
//        this.winning = winning;
//        winningGradeAndCountRepository = calculateWinningGradeStatistic();
//        yield = calculateYield();
//    }
//
//    public Map<Integer, Integer> calculateWinningGradeStatistic() {
//        Map<Integer, Integer> winningStatistic = new HashMap<>();
//
//        List<Integer> gradeResults = winningGradeResults();
//        gradeResults.stream().filter(x -> x > 0)
//                .forEach(x -> winningStatistic.put(x, winningStatistic.getOrDefault(x, 0)+1));
//        return winningStatistic;
//    }
//
//
//    // Calculate each Lottery to winning grade
//    public int winningGrade(final Lotto purchasedLotto) {
//        int correspondantCountResult = calculateCorrespondNumberCount(purchasedLotto);
//        int bonusNumber = this.winning.getBonusNumber();
//
//        if (correspondantCountResult == 6) return 1;
//        if (correspondantCountResult == 5 && purchasedLotto.getNumbers().contains(bonusNumber)) return 2;
//        if (correspondantCountResult == 5) return 3;
//        if (correspondantCountResult == 4) return 4;
//        if (correspondantCountResult == 3) return 5;
//        return 0;
//    }
//
//    // Calculate counts of how many numbers match with winning numbers
//    public int calculateCorrespondNumberCount(final Lotto purchasedLotto) {
//        return (int)purchasedLotto.getNumbers().stream()
//                .filter(winning.getWinningNumber()::contains).count();
//    }
//
//    public double calculateYield() {
//        long sum = 0;
//        for (int winningGrade : this.winningGradeAndCountRepository.keySet()) {
//            long winningReward = mapperOfGradeToReward(winningGrade);
//            sum += (winningReward * this.winningGradeAndCountRepository.get(winningGrade));
//        }
//        return sum / (double) purchaseLottoService.getPurchaseAmount();
//    }
//
//    public long mapperOfGradeToReward(int winningGrade) {
//        for (Grade x : Grade.values()) {
//            if (x.getGrade() == winningGrade) {
//                return x.getReward();
//            }
//        }
//        return 0;
//    }
//
//    // For Print the statistical result with purchased lotteries
//    public void printWinningStatisticResult() {
//        System.out.println();
//        for (Grade grade : Grade.values()) {
//            int count = winningGradeAndCountRepository.getOrDefault(grade.getGrade(), 0);
//            System.out.println(grade.getResult() + count + "개");
//        }
//        String format = String.format(ERR_MSG.ERR_NUMBER_FORMAT.getMsg(), this.yield * 100);
//        System.out.println(format);
//    }
//}
