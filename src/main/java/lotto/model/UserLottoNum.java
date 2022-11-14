package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class UserLottoNum {

    private List<Lotto> userLottoNumbers = new ArrayList<>();

    public UserLottoNum(List<Lotto> userLottoNumbers) {
        validate(userLottoNumbers);
        this.userLottoNumbers = userLottoNumbers;
    }

    private void validate(List<Lotto> userLottoNumbers) {
        for (Lotto userLottoNumber : userLottoNumbers) {
            if (userLottoNumber.getLotto().size() != 6) {
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Lotto> getUserLottoNumbers() {
        return userLottoNumbers;
    }
}
