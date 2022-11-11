package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Game {

    private static final Validation validation = new Validation();
    List<Integer> results;
    private static final List<Winning> rankings = List.of(
            Winning.FIFTH,
            Winning.FOURTH,
            Winning.THRID,
            Winning.SECOND,
            Winning.FIRST
    );

    public Game() {
    }

    public void run() {
        // TODO: 구입 금액 입력
        System.out.println(Sentences.PRICE.value());
        int amount = getPurchasePrice();
        System.out.println();

        // TODO: 구매 내역 출력
        System.out.println(Sentences.getPurchase(amount));
        List<Lotto> lottos = getRandomLottos(amount);
        System.out.println();

        // TODO: 당첨 번호 입력
        System.out.println(Sentences.LUCKY.value());
        Lotto lucky = getLuckyNumbers();
        System.out.println();

        // TODO: 보너스 번호 입력
        System.out.println(Sentences.BONUS.value());
        int bonus = getBonusNumber();
        lucky.validateBonusNumber(bonus);
        System.out.println();

        // TODO: 번호 비교
        results = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        getResult(lottos, lucky, bonus);

        // TODO: 당첨 통계 출력
        System.out.println(Sentences.STATS.value());
        System.out.println(Sentences.LINE.value());
        printResult();

        // TODO: 총 수익률 출력
        String earningRate = calculateEarningRate(amount);
        System.out.println(Sentences.getRate(earningRate));

    }

    private int getPurchasePrice() {
        String input = Console.readLine().trim();
        validation.validatePrice(input);
        return Integer.parseInt(input) / 1000;
    }

    private List<Lotto> getRandomLottos(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            System.out.println(numbers);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private Lotto getLuckyNumbers() {
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

    private int getBonusNumber() {
        String input = Console.readLine().trim();
        validation.validateNumber(input);
        int bonus = Integer.parseInt(input);
        validation.validateNumberRange(bonus);
        return bonus;
    }

    private void getResult(List<Lotto> lottos, Lotto lucky, int bonus) {
        for (Lotto lotto : lottos) {
            int ranking = lucky.getRanking(lotto, bonus);
            if (ranking != 0) {
                Integer before = results.get(5 - ranking);
                results.set(5 - ranking, before + 1);
            }
        }
    }

    private void printResult() {
        for (int i = 0; i < 5; i++) {
//            String result = Sentences.getResult(rankings.get(i), results.get(i));
            Winning ranking = rankings.get(i);
            String result = ranking.toString(results.get(i));
            System.out.println(result);
        }
    }

    private String calculateEarningRate(int amount) {
        int price = amount * 1000;
        int prize = calculatePrize();
        float rate = prize / price * 100;
        return String.format("%.1f", rate);
    }

    private int calculatePrize() {
        int prize = 0;
        for (int i = 0; i < 5; i++) {
            Integer result = results.get(i);
            if (result != 0) {
                prize += rankings.get(i).prize;
            }
        }
        return prize;
    }
}
