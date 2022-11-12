package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.stream.Collectors;

public class OutputView {

    private final static String COUNT_OF_LOTTO_MESSAGE = "%d개를 구매했습니다.\n";

    public static void printCountOfLotto(int LottoCount) {
        System.out.println();
        System.out.printf(COUNT_OF_LOTTO_MESSAGE, LottoCount);
    }
    public static void viewLottos(Lottos lottos){
        printCountOfLotto(lottos.getCountOfLotto());
        for (Lotto lotto: lottos.getLottos()){
            printLotto(lotto);
        }
        System.out.println();
    }

    public static void printLotto(Lotto lotto){
        String LottoNumbers = lotto.getLotto()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        System.out.println(LottoNumbers);
    }

}
