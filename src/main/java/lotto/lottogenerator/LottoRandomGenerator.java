package lotto.lottogenerator;

import static lotto.constant.LottoConstant.END_INCLUSIVE;
import static lotto.constant.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.constant.LottoConstant.START_INCLUSIVE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PaidLotto;

public class LottoRandomGenerator implements LottoGenerator {

    @Override
    public List<PaidLotto> generateLottoList(Integer lottoMountPerPrice) {
        List<PaidLotto> lottoList = new ArrayList<>();
        while (lottoList.size() != lottoMountPerPrice) {
            lottoList.add(new PaidLotto(findSortedRandomNumbers()));
        }

        return lottoList;
    }

    private Lotto findSortedRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>(
            Randoms.pickUniqueNumbersInRange(START_INCLUSIVE.getValue(), END_INCLUSIVE.getValue(),
                LOTTO_NUMBER_COUNT.getValue()));
        Collections.sort(randomNumbers);
        return new Lotto(randomNumbers);
    }
}
