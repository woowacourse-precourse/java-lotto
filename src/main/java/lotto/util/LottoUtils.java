package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.values.Hit;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import static lotto.domain.Lotto.*;
import static lotto.domain.Money.inputMoney;
import static lotto.domain.Rank.getLottosRanking;
import static lotto.values.Constants.Console.*;
import static lotto.values.Constants.Console.STATISTICS_MESSAGE;
import static lotto.values.Constants.Digit.*;
import static lotto.values.Constants.Util.LOTTO_NUMBER_SEPARATOR;

public class LottoUtils {


    public static int getLottoCntByMoney(Money money) {
        return money.getMoney() / LOTTO_PRICE;
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getLottoNumbers().toString()));
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

    public static void start(){
        Money money = getMoney();
        List<Lotto> lottos = inputLottos(money);
        Lotto winningLotto = inputWinningLotto();
        int bonusNumber = inputBonusNumber();
        Rank rank = getRankByValues(lottos, winningLotto, bonusNumber);
        LinkedHashMap<Integer, Integer> ranking = rank.getRank();

        printRanking(ranking);
        printTotalProfitMessage(getProfitPercentage(rank, money.getMoney()));
    }

    private static void printRanking(LinkedHashMap<Integer, Integer> ranking) {
        for (int i = FIFTH_PLACE; i <= FIRST_PLACE; i++) {
            Hit hit = getHit(i);
            Integer cnt = ranking.get(i);
            System.out.printf(hit.getMessage(), cnt);
        }
        printEnter();
    }

    private static Hit getHit(int rank){
        Hit hit = null;
        if(rank == FIFTH_PLACE){
            hit = Hit.THREE;
        } else if(rank == FOURTH_PLACE){
            hit = Hit.FOUR;
        } else if(rank == THIRD_PLACE) {
            hit = Hit.FIVE;
        } else if (rank == SECOND_PLACE) {
            hit = Hit.FIVE_BONUS;
        } else if (rank == FIRST_PLACE) {
            hit = Hit.SIX;
        }
        return hit;
    }

    private static Rank getRankByValues(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        System.out.println(STATISTICS_MESSAGE);
        Rank rank = getLottosRanking(winningLotto, bonusNumber, lottos);
        return rank;
    }

    private static Lotto inputWinningLotto() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        Lotto winningLotto = generateWinningLotto();
        printEnter();
        return winningLotto;
    }
    
    private static int inputBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        int bonusNumber = generateBonusNumber();
        printEnter();
        return bonusNumber;
    }

    private static List<Lotto> inputLottos(Money money) {
        int lottoCnt = getLottoCntByMoney(money);
        System.out.printf(OUTPUT_CNT_MESSAGE,lottoCnt);
        List<Lotto> lottos = generateLottos(lottoCnt);
        printLottoNumbers(lottos);
        printEnter();
        return lottos;
    }

    private static Money getMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        Money money = inputMoney();
        printEnter();
        return money;
    }

    private static void printEnter(){
        System.out.println();
    }

}