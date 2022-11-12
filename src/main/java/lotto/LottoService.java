package lotto;

import static lotto.util.LottoNumberGenerator.*;
import static lotto.util.Validator.validateLottoPrice;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.UserLottoInfo;

public class LottoService {
    public static final int START_IDX = 1;
    public static final int END_IDX = 45;
    public static final int NUMBER_COUNT = 6;

    private final UserLottoInfo userLottoInfo;

    public LottoService(UserLottoInfo userLottoInfo) {
        this.userLottoInfo = userLottoInfo;
    }

    public String inputLottoPrice(String lottoPrice) {
        validateLottoPrice(lottoPrice);
        return lottoPrice;
    }

    public void storeLottoPrice(String lottoPrice) {
        userLottoInfo.setLottoPrice(Integer.parseInt(lottoPrice));
    }

    // lotto 개수만큼 lotto 발행 (-> Lotto 객체 n개)
    public void publishLottos() {
        int totalLottoCount = userLottoInfo.getLottoPrice() / 1000;
        userLottoInfo.initLottoList(totalLottoCount);
        for (int i = 0; i < totalLottoCount; i++) {
            publishSingleLotto();
        }
    }

    private void publishSingleLotto() {
        List<Integer> lottoNumbers = generateRandomNumbers(START_IDX, END_IDX, NUMBER_COUNT);
        userLottoInfo.addSingleLotto(new Lotto(lottoNumbers));
    }
}
