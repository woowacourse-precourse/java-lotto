package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import lotto.Constants.ERROR;
import lotto.Constants.PRINT;
import lotto.Constants.REGEX;
import lotto.domain.Buyer;
import lotto.domain.Generator;
import lotto.domain.Lotto;

public class LottoProgram {

    private static Buyer buyer = new Buyer();
    public static void init() throws IllegalArgumentException {
        System.out.println(PRINT.INPUT_PAYMENT);
        String purchaseAmout = Console.readLine();
        String purchaseRegex = REGEX.PAYMENT;
        if (!Pattern.matches(purchaseRegex, purchaseAmout)) {
            throw new IllegalArgumentException(ERROR.PURCHASE_FORMAT);
        }
        int purchaseAmoutCash = Integer.parseInt(purchaseAmout);

        buyer.setTotalPurchaseAmout(purchaseAmoutCash);

        int numbersOfLotto = purchaseAmoutCash / 1000;
        buyer.setLottoPurchasedCount(numbersOfLotto);
        System.out.println(buyer.getLottoPurchasedCount() + PRINT.BUYED_LOTTO);

        purchasedLottoSave();
        System.out.println(PRINT.INPUT_WINNING_NUMBERS);
        String winningNumbers = Console.readLine();

        String winningNumberRegex = REGEX.WINNING_NUMBERS;
        if (!Pattern.matches(winningNumberRegex, winningNumbers)) {
            throw new IllegalArgumentException(ERROR.WINNING_NUMBER_FORMAT);
        }


        Integer[] numberArray = convertToInteger(winningNumbers);
        HashSet<Integer> removeDuplicatedNumbers = new HashSet<Integer>(List.of(numberArray));
        if (removeDuplicatedNumbers.size() != 6) {
            throw new IllegalArgumentException(ERROR.WINNING_NUMBER_DUPLICATE);
        }

        Lotto.setWinningNumbers(Arrays.asList(numberArray));

        System.out.println(PRINT.INPUT_BONUS_NUMBER);
        String bonusNumber = Console.readLine();
        String bonusNumberRegex = REGEX.BONUS_NUMBER;
        if (!Pattern.matches(bonusNumberRegex, bonusNumber)) {
            throw new IllegalArgumentException(ERROR.BONUS_NUMBER_RANGE);
        }
        if (Lotto.getWinningNumbers().contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(ERROR.BONUS_NUMBER_IN_WINNING_NUMBER);
        }

        Lotto.setBonusNumber(Integer.parseInt(bonusNumber));

        Generator.calculateRank(buyer);

        System.out.println(buyer.getWinningSummary().entrySet());

        System.out.println(PRINT.WINNING_RESULTS);
        HashMap<String, Integer> winningSummary = buyer.getWinningSummary();
        List<Ranking> rankings = new ArrayList<Ranking>(
                Arrays.asList(
                        Ranking.FIFTH,
                        Ranking.FOURTH,
                        Ranking.THIRD,
                        Ranking.SECOND,
                        Ranking.FIRST)
        );

        rankings.stream()
                .forEach(rank -> {
                    int rankCount = winningSummary.get(rank.getLabel());
                    if (rank.getLabel().equals(Lotto.RANK_SECOND)) {
                        buyer.setTotalWinningPrize(rank.getPrize() * rankCount);
                        System.out.printf(
                                PRINT.BONUS_CORRECT_FORMAT,
                                rank.getWinningCount(), rank.getPrizeLabel(),
                                rankCount);
                        return;
                    }
                    buyer.setTotalWinningPrize(rank.getPrize() * rankCount);
                    System.out.printf(
                            PRINT.GENERAL_CORRECT_FORMAT,
                            rank.getWinningCount(), rank.getPrizeLabel(),
                            rankCount);
                });

        double totalPrize = Generator.profitCalculate(
                buyer.getTotalPurchaseAmout(), buyer.getTotalWinningPrize());

        System.out.printf(PRINT.PROFIT_FORMAT, totalPrize);

    }

    private static void purchasedLottoSave() {
        int count = buyer.getLottoPurchasedCount();
        for (int lottoCount = 0; lottoCount < count; lottoCount++) {
            List<Integer> purchasedLottoNumber = new ArrayList<Integer>(
                    Randoms.pickUniqueNumbersInRange(1, 45, 6));
            purchasedLottoNumber.sort(Comparator.naturalOrder());
            System.out.println(purchasedLottoNumber);
            buyer.setLottoPurchased(new Lotto(purchasedLottoNumber));
        }
    }

    private static Integer[] convertToInteger(String inputNumber) {
        return Stream.of(inputNumber.split(","))
                .mapToInt((number) -> {
                    try {
                        int parsedInt = Integer.parseInt(number);
                        return parsedInt;
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException();
                    }
                })
                .boxed()
                .toArray(Integer[]::new);
    }
}
