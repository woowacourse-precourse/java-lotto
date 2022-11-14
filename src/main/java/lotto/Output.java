package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Result;

public class Output {

    public static void showLottoesPurchased(List<Lotto> lottoes) {
        System.out.println("\n" + NumberFormatter.format(lottoes.size()) + "개를 구매했습니다.");
        lottoes.stream().forEach(System.out::println);
    }

    public static void showResult(Result result) {
        Map<Rank, Integer> resultInformation = result.returnInfo();
        List<String> messages = new ArrayList<>();
        resultInformation.keySet().stream().filter(rank -> rank != Rank.NOTHING)
                .forEach(rank ->
                        messages.add(rank + " - " + NumberFormatter.format(resultInformation.get(rank)) + "개"));
        System.out.println(String.join("\n", messages));
        System.out.println("총 수익률은 " + NumberFormatter.format(result.calculateYield()) + "%입니다.");
    }
}
