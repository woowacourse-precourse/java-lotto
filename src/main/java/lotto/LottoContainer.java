package lotto;

import java.util.ArrayList;

public class LottoContainer {
    private final ArrayList<Lotto> lottoBundle;

    public LottoContainer(ArrayList<Lotto> lottoBundle) {
        validate(lottoBundle);
        this.lottoBundle = lottoBundle;
    }

    private void validate(ArrayList<Lotto> lottoBundle) {
        // 이 로또 뭉치가 유효한지 검사. (개수만)
    }
}


/* list <> [6] 자리를 감싸고 있는 일급 컬랙션 Lotto 들의 리스트를 감싸는 일급 컬렉션   */

/*
Lotto -> (private final List<Integer> numbers)를 감쌈
LottoContainer -> (private final ArrayList<Lotto> lottoPack ) 를 감싼다.

 */