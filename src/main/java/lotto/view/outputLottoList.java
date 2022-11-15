package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class outputLottoList {
    public static void printLottoList(List<Lotto> lottos) {
        lottos.forEach(System.out::println);
        System.out.println();
    }
}
