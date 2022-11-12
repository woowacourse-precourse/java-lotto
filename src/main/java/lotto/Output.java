package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Result;

public class Output {

    public static void showLottoesPurchased(List<Lotto> lottoes) {
        System.out.println("\n"+lottoes.size() + "개를 구매했습니다.");
        lottoes.stream().forEach(System.out::println);
    }

    public static void showResult(Result result) {
        System.out.println(result);
        System.out.println("총 수익률은 " + result.calculateYield() + "%입니다.");
    }
}
