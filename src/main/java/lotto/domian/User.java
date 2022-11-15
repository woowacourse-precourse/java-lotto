package lotto.domian;

import static lotto.constant.Constant.*;
import java.util.ArrayList;
import java.util.List;
import lotto.util.GenerateLottoNumbers;

public class User {
    private final long userLottoBuyingPrice;
    private List<UserSingleLottoNumber> userLottoNumbers;
    private double userWinningPrice;
    private final long userLottoQuantity;
    private double userYield;
    GenerateLottoNumbers generateLottoNumbers = new GenerateLottoNumbers();

    public User(long price) {
        this.userLottoBuyingPrice = price;
        this.userLottoNumbers = new ArrayList<>();
        this.userWinningPrice = INITIAL_NUMBER;
        this.userLottoQuantity = price / LOTTO_PRICE;
        this.userYield = INITIAL_NUMBER;
    }
}
