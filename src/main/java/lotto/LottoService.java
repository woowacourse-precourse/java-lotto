package lotto;

import static lotto.util.Validator.validateLottoPrice;

import lotto.domain.UserLottoInfo;

public class LottoService {
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


}
