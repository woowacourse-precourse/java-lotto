package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    private static final Validation validation = new Validation();
    private static final List<Sentences> rankings = List.of(
            Sentences.FIFTH,
            Sentences.FOURTH,
            Sentences.THRID,
            Sentences.SECOND,
            Sentences.FIRST
    );

    public Game() {
    }

    public void run() {
        // TODO: 구입 금액 입력
        System.out.println(Sentences.PRICE.value());
        int amount = getPurchasePrice();

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
        System.out.println();

        // TODO: 번호 비교

        // TODO: 당첨 통계 출력
        System.out.println(Sentences.STATS.value());
        System.out.println(Sentences.LINE.value());
        List<Integer> results = List.of(1, 0, 0, 0, 0);
        for (int i = 0; i < 5; i++) {
            String result = Sentences.getResult(rankings.get(i), results.get(i));
            System.out.println(result);
        }

        // TODO: 총 수익률 출력
        System.out.println(Sentences.getRate(62.5F));

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
}
