package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 로또 번호 생성에 관한 클래스
 *
 * @version 1.0.0
 * @author chlskreh2
 */
public class LottoNumberCreator {

    /**
     * 로또 번호 생성 후 Lotto class 에게 로또 발행시키기
     */
    public List<Lotto> createLottoNumber(int lottoQuantity) {
        List<Lotto> lotteries = new ArrayList<>();
        for (int i = 0; i < lottoQuantity; ++i) {
            List<Integer> lottoCreateNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoCreateNumbers.sort(Comparator.naturalOrder());
            lotteries.add(new Lotto(lottoCreateNumbers));
        }
        return lotteries;
    }
}
