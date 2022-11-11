package lotto;

import camp.nextstep.edu.missionutils.Console;
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
        String input = Console.readLine().trim();
        validation.validatePrice(input);
        int amount = Integer.parseInt(input) / 1000;

        // TODO: 구매 내역 출력
        System.out.println(Sentences.getPurchase(amount));
        System.out.println();

        // TODO: 당첨 번호 입력
        System.out.println(Sentences.LUCKY.value());
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
}
