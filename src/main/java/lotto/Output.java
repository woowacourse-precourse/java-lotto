package lotto;

import java.util.List;
import lotto.domain.Lotto;

public class Output {

    public static void showLottoesPurchased(List<Lotto> lottoes) {
        System.out.println("\n"+lottoes.size() + "개를 구매했습니다.");
        lottoes.stream().forEach(System.out::println);
    }
}
