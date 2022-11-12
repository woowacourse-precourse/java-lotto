package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {

    private static final Validation validation = new Validation();
    private static final List<Winning> rankings = List.of(
            Winning.FIFTH,
            Winning.FOURTH,
            Winning.THRID,
            Winning.SECOND,
            Winning.FIRST
    );

    static List<Integer> wins;

    public static void main(String[] args) {
        System.out.println(Sentences.PRICE.value());
        int amount = getPurchasePrice();
        System.out.println();

        System.out.println(Sentences.getPurchase(amount));
        List<Lotto> lottos = getRandomLottos(amount);
        System.out.println();

        System.out.println(Sentences.LUCKY.value());
        Lotto lucky = getLuckyNumbers();
        System.out.println();

        System.out.println(Sentences.BONUS.value());
        int bonus = getBonusNumber();
        lucky.validateBonusNumber(bonus);
        System.out.println();

        wins = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        getResult(lottos, lucky, bonus);

        System.out.println(Sentences.STATS.value());
        System.out.println(Sentences.LINE.value());
        printResult();

        String earningRate = calculateEarningRate(amount);
        System.out.println(Sentences.getRate(earningRate));
    }

    private static int getPurchasePrice() {
        String input = Console.readLine().trim();
        validation.validatePrice(input);
        return Integer.parseInt(input) / 1000;
    }

    private static List<Lotto> getRandomLottos(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private static void printRandomLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    private static Lotto getLuckyNumbers() {
        String input = Console.readLine().trim();
        String[] splitedInput = input.split(",");
        List<Integer> luckyNumber = new ArrayList<>();
        for (String s : splitedInput) {
            validation.validateNumber(s);
            int number = Integer.parseInt(s);
            validation.validateNumberRange(number);
            luckyNumber.add(number);
        }
        return new Lotto(luckyNumber);
    }

    private static int getBonusNumber() {
        String input = Console.readLine().trim();
        validation.validateNumber(input);
        int bonus = Integer.parseInt(input);
        validation.validateNumberRange(bonus);
        return bonus;
    }

    private static void getResult(List<Lotto> lottos, Lotto lucky, int bonus) {
        for (Lotto lotto : lottos) {
            int ranking = lucky.getRanking(lotto, bonus);
            if (ranking != 0) {
                Integer before = wins.get(5 - ranking);
                wins.set(5 - ranking, before + 1);
            }
        }
    }

    private static void printResult() {
        for (int i = 0; i < 5; i++) {
            Winning ranking = rankings.get(i);
            String result = ranking.toString(wins.get(i));
            System.out.println(result);
        }
    }

    private static String calculateEarningRate(int amount) {
        int price = amount * 1000;
        int prize = calculatePrize();
        float rate = prize / price * 100;
        return String.format("%.1f", rate);
    }

    private static int calculatePrize() {
        int prize = 0;
        for (int i = 0; i < 5; i++) {
            Integer result = wins.get(i);
            prize += rankings.get(i).prize * result;
        }
        return prize;
    }
}
