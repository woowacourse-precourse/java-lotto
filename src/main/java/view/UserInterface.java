package view;

import camp.nextstep.edu.missionutils.Console;
import messages.ErrorMessages;
import messages.PrintMessages;
import lotto.Lotto;
import lotto.LottoRank;
import lotto.LottoResult;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class UserInterface {
    private static DecimalFormat decimalFormat = new DecimalFormat("###,###");

    public static int readPayment() throws IllegalArgumentException {
        System.out.println(PrintMessages.INPUT_PAYMENT);
        String line = Console.readLine();
        try {
            int payment = Integer.parseInt(line);
            if (payment < 1000 || payment % 1000 != 0) {
                throw new IllegalArgumentException(ErrorMessages.LESS_THAN_MINIMUM_UNIT);
            }
            return payment;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.NOT_NUMBER_INPUT);
        }
    }

    public static Lotto readLuckyNumbers() throws IllegalArgumentException {
        System.out.println(PrintMessages.INPUT_LUCKY_NUMBERS);
        String[] tokens = Console.readLine().split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            try {
                numbers.add(Integer.parseInt(token));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessages.NOT_NUMBER_INPUT);
            }
        }

        return new Lotto(numbers);
    }

    public static int readBonusNumber() throws IllegalArgumentException {
        System.out.println(PrintMessages.INPUT_BONUS_NUMBER);
        String line = Console.readLine();
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.NOT_NUMBER_INPUT);
        }
    }

    public static void printStatistics(LottoResult statistics) throws IllegalArgumentException {
        System.out.println(PrintMessages.START_PRINT_STATISTICS);
        for (LottoRank rank : LottoRank.values()) {
            if (rank.getRank() == 0)
                continue;
            System.out.println(getFormedRankLine(rank, statistics.getNumOfRank(rank)));
        }
        System.out.println(getFormedYield(statistics.getYield()));
    }

    public static void printBoughtLotteries(List<Lotto> lotteries) {
        System.out.println("\n" + String.format(PrintMessages.BUY_COMPLETE, lotteries.size()));
        StringBuffer sb = new StringBuffer();
        for (Lotto lotto : lotteries) {
            sb.append(lotto.getNumbers());
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void printError(Exception e) {
        System.out.println(ErrorMessages.ERROR_PREFIX + " " + e.getMessage());
        e.printStackTrace();
    }

    private static String getFormedRankLine(LottoRank rank, int nums) {
        return String.format(PrintMessages.RANK_INFORMATION, rank.getDescription(), decimalFormat.format(rank.getPrize()), nums);
    }

    private static String getFormedYield(double yield) {
        return String.format(PrintMessages.PRINT_YIELD_FORMAT, yield);
    }
}