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

    public void setUserLottoNumbers(List<UserSingleLottoNumber> lottoNumberList) {
        this.userLottoNumbers = lottoNumberList;
    }
    public void createLottoNumbers(long lottoQuantity) {
        List<UserSingleLottoNumber> lottoNumbers = generateLottoNumbers.generateLottoNumber(lottoQuantity);
        setUserLottoNumbers(lottoNumbers);
    }
    public List<UserSingleLottoNumber> getUserLottoNumbers() {
        return userLottoNumbers;
    }
    public long getUserLottoBuyingPrice() {
        return userLottoBuyingPrice;
    }
    public double getUserWinningPrice() {
        return userWinningPrice;
    }
    public long getUserLottoQuantity() {
        return userLottoQuantity;
    }
    public void addUserWinningPrice(int price) {
        userWinningPrice += price;
    }
    public void setUserYield(double yield) {
        this.userYield = yield;
    }
    public double getUserYield() {
        return userYield;
    }
}
