package lotto.view;

import lotto.domain.Lotto;

import static lotto.constant.MessageConstants.*;
import java.util.List;

public class OutputView {
    public static void printPurchasedLotto(List<Lotto> lottos) {
        int lottoCount = lottos.size();
        System.out.println(ENTER+ lottoCount + PURCHASED_MESSAGE);
        lottos.stream()
                .map(Lotto::toString)
                .forEach(System.out::println);
    }
}
