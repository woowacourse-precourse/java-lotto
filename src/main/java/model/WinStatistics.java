package model;

import static controller.StartLotto.bonusNumber;
import static controller.StartLotto.lottoQuantity;
import static controller.StartLotto.lottos;
import static controller.StartLotto.winNumber;
import static model.Constant.FIVE_MATCH_NUMBER;
import static model.Constant.MINIMUM_LOTTO_PRICE;
import static model.Constant.ONE_HUNDRED_FOR_PERCENT;
import static model.Constant.ZERO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import view.Message;

public class WinStatistics {
    public static double earningRate;
    private static final String COMMA = ",";

    public enum Rank {
        FIRST_PLACE(1, 2_000_000_000, 6, null, Message.WIN_FIRST_PLACE),
        SECOND_PLACE(2, 30_000_000, 5, true, Message.WIN_SECOND_PLACE),
        THIRD_PLACE(3, 1_500_000, 5, null, Message.WIN_THIRD_PLACE),
        FORTH_PLACE(4, 50_000, 4, null, Message.WIN_FOURTH_PLACE),
        FIFTH_PLACE(5, 5_000, 3, null, Message.WIN_FIFTH_PLACE);

        private final int rank;
        private final int prize;
        private final int matchNumber;
        private final Boolean isMatchBonusNumber;
        private final String message;
        private int count;

        Rank(int rank, int prize, int matchNumber, Boolean isMatchBonusNumber, String message) {
            this.rank = rank;
            this.prize = prize;
            this.matchNumber = matchNumber;
            this.isMatchBonusNumber = isMatchBonusNumber;
            this.message = message;
        }

        private static void init() {
            Arrays.stream(Rank.values())
                    .forEach(rank -> rank.count = ZERO.constant);
        }

        public void print() {
            System.out.printf(message + "%n", count);
        }

        private static void getWinQuantity(int matchNumberQuantity, Boolean isMatchBonusNumber) {
            Optional<Rank> specificNumber = Arrays.stream(values())
                    .filter(number -> number.matchNumber == matchNumberQuantity
                            && number.isMatchBonusNumber == isMatchBonusNumber)
                    .findFirst();

            specificNumber.ifPresent(value -> value.count++);
        }
    }

    private WinStatistics(List<Lotto> lottos, Lotto winNumber, int bonusNumber) {
        Rank.init();

        lottos.forEach(userNumber -> {
            int matchNumberQuantity = getMatchNumber(userNumber, winNumber);
            Boolean isMatchBonusNumber = checkBonusNumber(userNumber, bonusNumber, matchNumberQuantity);
            Rank.getWinQuantity(matchNumberQuantity, isMatchBonusNumber);
        });
    }

    private Boolean checkBonusNumber(Lotto userNumber, int bonusNumber, int matchNumberQuantity) {
        if (matchNumberQuantity == FIVE_MATCH_NUMBER.constant) {
            return Lotto.checkBonusNumber(userNumber, bonusNumber);
        }
        return null;
    }

    private int getMatchNumber(Lotto userNumber, Lotto winNumber) {
        return Lotto.countMatchNumber(userNumber, winNumber);
    }

    private static void getEarningRate(int purchaseMoney) {
        int totalPrize = ZERO.constant;
        double beforeRounds;
        totalPrize += Arrays.stream(Rank.values())
                .mapToInt(rank -> rank.count * rank.prize)
                .sum();

        beforeRounds = (double) totalPrize / purchaseMoney * ONE_HUNDRED_FOR_PERCENT.constant;
        earningRate = Math.round(beforeRounds * 10) / 10.0;
    }

    private static List<String> splitByComma(String userInput) {
        return Arrays.asList(userInput.split(COMMA));
    }

    public static void setWinNumber(String userInput) {
        List<String> commaSplits = splitByComma(userInput);
        List<Integer> winNumbers = new ArrayList<>();

        commaSplits.forEach(commaSplit -> {
            IsValid.correctNumber(commaSplit);
            winNumbers.add(Integer.valueOf(commaSplit));
        });
        winNumber = new Lotto(winNumbers);
    }

    public static void checkMatchNumber() {
        new WinStatistics(lottos, winNumber, bonusNumber);
        Message.printWinStatistics();
    }

    public static void earningRate() {
        getEarningRate(lottoQuantity * MINIMUM_LOTTO_PRICE.constant);
        Message.printEarningRate();
    }
}