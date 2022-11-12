package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoEnum;
import lotto.dto.Lotto;

public class ManagementLotto {
    public List<Lotto> purchase(Integer amount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int count = 0; count < amount; count++) {
            lottos.add(generateLottoNumber());
        }

        return lottos;
    }
    public Lotto generateLottoNumber() {
        List<Integer> lottoNumber = new ArrayList<>();
        lottoNumber = Randoms.pickUniqueNumbersInRange(
                LottoEnum.START_NUM.getValue(), LottoEnum.END_NUM.getValue(), LottoEnum.SIZE.getValue());
        lottoNumber.sort(Integer::compareTo);

        return new Lotto(lottoNumber);
    }

    public void checkLottooNumber() {

    }

    public void calcROI() {

    }
}
