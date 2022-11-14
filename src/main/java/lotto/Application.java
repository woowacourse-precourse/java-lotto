package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    private static final Comment comment = new Comment();
    private static final Service service = new Service();
    private static final LottoGroup lottoGroup = new LottoGroup();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            int purchaseAmount = service.toInt(comment.printPayment());
            int purchasedLottery = service.numberOfLottery(purchaseAmount);

            service.createLotteryTickets(purchasedLottery, lottoGroup);
            comment.printCountBuyingTickets(purchasedLottery, lottoGroup);

            List<String> winningStrings = service.splitByCommas(comment.printWinningNumber());
            List<Integer> winningNumbers = service.toIntegers(winningStrings);
            int bonusNumber = service.toInt(comment.printBonusNumber());
            WinningNumber winningNumber = new WinningNumber(new Lotto(winningNumbers), bonusNumber);

            comment.printWinningStats();

            List<RankType> winningResult = service.getLotteriesRanks(lottoGroup, winningNumber);
            Map<RankType, Integer> eachRankCount = new HashMap<>();

            for (RankType rankType : RankType.getReverseRankTypeExceptNone()) {
                eachRankCount.put(rankType, Collections.frequency(winningResult, rankType));
                comment.printWinningRankCount(rankType, eachRankCount);
            }

            int totalReturn = service.sumAllWinnings(winningResult);

            comment.printTotalReturn(service.calculateTotalReturn(purchaseAmount, totalReturn));
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]: 사용자의 입력이 잘못 되었습니다.");
        }
    }
}
