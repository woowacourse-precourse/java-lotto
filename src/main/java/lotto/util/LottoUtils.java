package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import static lotto.values.Constants.Console.TOTAL_PROFIT_PERCENT_MESSAGE;
import static lotto.values.Constants.Digit.*;
import static lotto.values.Constants.Util.LOTTO_NUMBER_SEPARATOR;

public class LottoUtils {


    public static int getLottoCntByMoney(Money money) {
        return money.getMoney() / LOTTO_PRICE;
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        lottos.forEach(lotto -> {
            System.out.println(lotto.getLottoNumbers().toString());
        });
    }

    public static void printTotalProfitMessage(String percent) {
        System.out.printf(TOTAL_PROFIT_PERCENT_MESSAGE, percent);
    }

    public static List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        String inputNumbers = Console.readLine();
        String[] splitNumbers = inputNumbers.split(LOTTO_NUMBER_SEPARATOR);

        for (String splitNumber : splitNumbers) {
            int number = Integer.parseInt(splitNumber);
            winningNumbers.add(number);
        }

        return winningNumbers;
    }

    public static int getBonusNumber() {
        int bonusNumber = Integer.parseInt(Console.readLine());
        return bonusNumber;
    }


    public static String getProfitPercentage(Rank rank, int inputMoney) {
        int totalProfit = calculateProfit(rank.getRank());
        double profitPercent = (double) totalProfit / (double) inputMoney * 100.0;
        String roundedPercent = String.format("%.1f", profitPercent);
        return roundedPercent;
    }

    private static int calculateProfit(LinkedHashMap<Integer, Integer> rankData) {
        int totalProfit = 0;
        Set<Integer> ranking = rankData.keySet();

        for (Integer rank : ranking) {
            Integer cnt = rankData.get(rank);
            totalProfit += calculateRankingPrize(rank, cnt);
        }
        return totalProfit;
    }

    private static int calculateRankingPrize(Integer rank, int cnt){
        int prize = 0;
        if (rank.equals(FIRST_PLACE)) {
            prize = FIRST_PLACE_PRIZE;
        } else if (rank.equals(SECOND_PLACE)) {
            prize = SECOND_PLACE_PRIZE;
        } else if (rank.equals(THIRD_PLACE)) {
            prize = THIRD_PLACE_PRIZE;
        } else if (rank.equals(FOURTH_PLACE)) {
            prize = FOURTH_PLACE_PRIZE;
        } else if (rank.equals(FIFTH_PLACE)) {
            prize = FIFTH_PLACE_PRIZE;
        }

        return prize * cnt;
    }


}