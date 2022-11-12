package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class SixDigitGenerator {

    public static List<Lotto> generateLottoDigits(long lottoCnt) {
        //make 6size list that have valid 6 numbers
        List<Lotto> lottoSet = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            Lotto createdLotto = new Lotto(selectLottoDigits()); // 여섯자리 정수 리스트를 생성
            lottoSet.add(createdLotto);
        }
        return lottoSet;
    }
    public static List<Integer> selectLottoDigits() {
        return Randoms.pickUniqueNumbersInRange(1,45,6);
        //it choose 6 numbers from 1~45 range
    }
}
