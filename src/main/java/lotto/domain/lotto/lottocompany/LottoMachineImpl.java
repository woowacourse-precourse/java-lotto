package lotto.domain.lotto.lottocompany;

import static lotto.domain.lotto.lotto.LottoInfo.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.domain.lotto.lotto.Lotto;

public class LottoMachineImpl implements LottoMachine {

    @Override
    public Lotto createLotto() {
        return new Lotto(pickLottoNumbers());
    }

    private List<Integer> pickLottoNumbers() {

        ArrayList<Integer> pickedLottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE));
        pickedLottoNumbers.sort(Comparator.naturalOrder());
        return pickedLottoNumbers;
    }
}
