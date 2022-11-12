package lotto;

import io.Output;
import java.util.ArrayList;
import java.util.List;

public class LottoContainer {
    private final List<Lotto> lottoBundle;

    public LottoContainer(List<Lotto> lottoBundle) {
        validate(lottoBundle);
        this.lottoBundle = lottoBundle;
    }

    private void validate(List<Lotto> lottoBundle) {
        // 이 로또 뭉치가 유효한지 검사. (개수만)
//        for (int i = 0; i < lottoBundle.size(); i++) {
//            System.out.println(lottoBundle.get(i));
//        }
    }

    public void printLottoBundles(Output output) {
        for (int i = 0; i < lottoBundle.size(); i++) {
            lottoBundle.get(i).printLottoDigits(output);
        }
    }
}


/* list <> [6] 자리를 감싸고 있는 일급 컬랙션 Lotto 들의 리스트를 감싸는 일급 컬렉션   */

/*
Lotto -> (private final List<Integer> numbers)를 감쌈
LottoContainer -> (private final ArrayList<Lotto> lottoPack ) 를 감싼다.

 */