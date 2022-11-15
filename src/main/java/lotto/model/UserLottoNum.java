package lotto.model;

import lotto.constants.LottoSetting;

import java.util.ArrayList;
import java.util.List;

import static lotto.constants.ErrorMessage.ERROR;
import static lotto.constants.ErrorMessage.ERROR_MESSAGE_SIZE;
import static lotto.constants.LottoSetting.LOTTO_SIZE;

public class UserLottoNum {

    private List<Lotto> userLottoNumbers = new ArrayList<>();

    public UserLottoNum(List<Lotto> userLottoNumbers) {
        validate(userLottoNumbers);
        this.userLottoNumbers = userLottoNumbers;
    }

    private void validate(List<Lotto> userLottoNumbers) {
        for (Lotto userLottoNumber : userLottoNumbers) {
            if (userLottoNumber.getLotto().size() != LOTTO_SIZE) {
                throw new IllegalArgumentException(ERROR+ERROR_MESSAGE_SIZE);
            }
        }
    }

    public List<Lotto> getUserLottoNumbers() {
        return userLottoNumbers;
    }
}
