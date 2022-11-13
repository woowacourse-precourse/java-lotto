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
import lotto.Constants.REGEX;
import lotto.domain.Buyer;
import lotto.domain.Generator;
import lotto.domain.Lotto;

public class LottoProgram {

    private static Buyer buyer = new Buyer();
    public static void init() throws IllegalArgumentException {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmout = Console.readLine();
        String purchaseRegex = REGEX.PAYMENT;
        if (!Pattern.matches(purchaseRegex, purchaseAmout)) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요");
        }
        int purchaseAmoutCash = Integer.parseInt(purchaseAmout);

        buyer.setTotalPurchaseAmout(purchaseAmoutCash);

        int numbersOfLotto = purchaseAmoutCash / 1000;
        buyer.setLottoPurchasedCount(numbersOfLotto);
        System.out.println(buyer.getLottoPurchasedCount() + "개를 구매했습니다.");

        purchasedLottoSave();
        System.out.println("당첨 번호를 입력해주세요.");
        String winningNumbers = Console.readLine();

        String winningNumberRegex = REGEX.WINNING_NUMBERS;
        if (!Pattern.matches(winningNumberRegex, winningNumbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1-45사이의 숫자를 콤마로 구분하여 입력해주세요.");
        }


        Integer[] numberArray = convertToInteger(winningNumbers);
        HashSet<Integer> removeDuplicatedNumbers = new HashSet<Integer>(List.of(numberArray));
        if (removeDuplicatedNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복 숫자가 존재하지 않아야 합니다.");
        }

        Lotto.setWinningNumbers(Arrays.asList(numberArray));

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        String bonusNumberRegex = REGEX.BONUS_NUMBER;
        if (!Pattern.matches(bonusNumberRegex, bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1-45사이의 숫자여야 합니다.");
        }
        if (Lotto.getWinningNumbers().contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호에 존재할 수 없습니다.");
        }

        Lotto.setBonusNumber(Integer.parseInt(bonusNumber));

        Generator.calculateRank(buyer);

        System.out.println(buyer.getWinningSummary().entrySet());

        System.out.println("당첨 통계\n---");
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
                                "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n",
                                rank.getWinningCount(), rank.getPrizeLabel(),
                                rankCount);
                        return;
                    }
                    buyer.setTotalWinningPrize(rank.getPrize() * rankCount);
                    System.out.printf(
                            "%d개 일치 (%s원) - %d개\n",
                            rank.getWinningCount(), rank.getPrizeLabel(),
                            rankCount);
                });

        double totalPrize = Generator.profitCalculate(
                buyer.getTotalPurchaseAmout(), buyer.getTotalWinningPrize());

        System.out.printf("총 수익률은 %.1f%%입니다.", totalPrize);

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
