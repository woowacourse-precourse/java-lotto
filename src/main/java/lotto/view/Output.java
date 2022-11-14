package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class Output {

    public static void printGeneratedLotto(List<Lotto> lottoList) {
        System.out.println(lottoList.size()+"개를 구매했습니다.");
        lottoList.forEach( lotto -> System.out.println(lotto.toString()));
    }

}
