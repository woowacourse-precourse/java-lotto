package lotto;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private static final Comment comment = new Comment();
    private static final Service service = new Service();
    private static final LottoGroup lottoGroup = new LottoGroup();

    public static void main(String[] args) {
        try {
            int purchaseAmount = service.toInt(comment.printPayment());
            int purchasedLottery = service.numberOfLottery(purchaseAmount);

            runCreateLotto(purchasedLottery, lottoGroup);

            WinningNumber winningNumber = runGetWinningNumber();

            runWinningStats(winningNumber);

            runTotalReturn(lottoGroup, winningNumber, purchaseAmount);
        } catch (IllegalArgumentException e) {
            comment.printErrorMessage();
        }
    }

    private static void runCreateLotto(int purchasedLottery, LottoGroup lottoGroup) {
        service.createLotteryTickets(purchasedLottery, lottoGroup);
        comment.printCountBuyingTickets(purchasedLottery, lottoGroup);
    }

    private static WinningNumber runGetWinningNumber() {
        List<String> winningStrings = service.splitByCommas(comment.printWinningNumber());
        List<Integer> winningNumbers = service.toIntegers(winningStrings);

        int bonusNumber = service.toInt(comment.printBonusNumber());

        WinningNumber winningNumber = new WinningNumber(new Lotto(winningNumbers), bonusNumber);

        return winningNumber;
    }

    private static void runWinningStats(WinningNumber winningNumber) {
        Map<RankType, Integer> eachRankCount = new HashMap<>();
        comment.printWinningStats();
        List<RankType> winningResult = service.getLotteriesRanks(lottoGroup, winningNumber);

        for (RankType rankType : RankType.getReverseRankTypeExceptNone()) {
            eachRankCount.put(rankType, Collections.frequency(winningResult, rankType));
            comment.printWinningRankCount(rankType, eachRankCount);
        }
    }

    private static void runTotalReturn(LottoGroup lottoGroup, WinningNumber winningNumber, int purchaseAmount) {
        List<RankType> winningResult = service.getLotteriesRanks(lottoGroup, winningNumber);

        int totalReturn = service.sumAllWinnings(winningResult);

        comment.printTotalReturn(service.calculateTotalReturn(purchaseAmount, totalReturn));
    }
}
