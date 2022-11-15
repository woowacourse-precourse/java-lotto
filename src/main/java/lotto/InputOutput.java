package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputOutput {

    private static final List<Winning> rankings = List.of(
            Winning.FIFTH,
            Winning.FOURTH,
            Winning.THRID,
            Winning.SECOND,
            Winning.FIRST
    );

    public InputOutput() {
    }

    public String getPrice() {
        System.out.println(Sentences.PRICE.value());
        String input = Console.readLine().trim();
        System.out.println();
        return input;
    }

    public void printLottos(int amount, List<Lotto> lottos) {
        System.out.println(Sentences.getPurchase(amount));
        printRandomLottos(lottos);
        System.out.println();
    }

    private void printRandomLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public String getLukcyNumber() {
        System.out.println(Sentences.LUCKY.value());
        String input = Console.readLine().trim();
        System.out.println();
        return input;
    }

    public String getBonusNumber() {
        System.out.println(Sentences.BONUS.value());
        String input = Console.readLine().trim();
        System.out.println();
        return input;
    }

    public void printResult(List<Integer> wins) {
        System.out.println(Sentences.STATS.value());
        System.out.println(Sentences.LINE.value());
        printLottoResult(wins);

    }

    private void printLottoResult(List<Integer> wins) {
        for (int i = 0; i < 5; i++) {
            Winning ranking = rankings.get(i);
            String result = ranking.toString(wins.get(i));
            System.out.println(result);
        }
    }

    public void printEarningRate(String rate) {
        System.out.println(Sentences.getRate(rate));
    }

}
