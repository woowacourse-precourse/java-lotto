package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class Output {

    public static void printErrorMessage(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }

    public static void printLottos(Lottos lottos) {
        printLottosCount(lottos.getLottosCount());
        printLottosInfo(lottos);
    }

    public static void printLottosCount(int lottosCount) {
        System.out.println(lottosCount + "개를 구매했습니다.");
    }

    public static void printLottosInfo(Lottos lottos) {
        lottos.getLottos()
                .stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);

    }
}
