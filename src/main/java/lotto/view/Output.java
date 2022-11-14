package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class Output {

    public static void printGeneratedLotto(List<Lotto> lottoList) {
        lottoList.forEach( lotto -> System.out.println(lotto.toString()));
    }

}
