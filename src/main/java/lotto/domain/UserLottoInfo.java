package lotto.domain;

import static lotto.ui.ConsoleMessage.INVALID_INPUT_PRICE;

import java.util.ArrayList;
import java.util.List;
import lotto.ui.LottoConsole;

public class UserLottoInfo {

    private final int lottoPrice;
    private List<Lotto> userLotto;

    public UserLottoInfo(String lottoPrice) {
        validateLottoPrice(lottoPrice);
        this.lottoPrice = Integer.parseInt(lottoPrice);
    }

    private void validateLottoPrice(String lottoPrice) {
        if (!isLottoPriceNumeric(lottoPrice)) {
            LottoConsole.printErrorMessage(INVALID_INPUT_PRICE.toString());
            throw new IllegalArgumentException();
        }
        if (!isLottoPriceMultiplesof1000(Integer.parseInt(lottoPrice))) {
            LottoConsole.printErrorMessage(INVALID_INPUT_PRICE.toString());
            throw new IllegalArgumentException();
        }
    }

    private boolean isLottoPriceMultiplesof1000(int lottoPrice) {
        return (lottoPrice % 1000 == 0);
    }

    private boolean isLottoPriceNumeric(String lottoPrice) {
        return lottoPrice.chars().allMatch(Character::isDigit);
    }

    public int getLottoPrice() {
        return lottoPrice;
    }

    public void initLottoList(int lottoCount) {
        userLotto = new ArrayList<>(lottoCount);
    }

    public void addSingleLotto(Lotto singleLotto) {
        userLotto.add(singleLotto);
    }

    public Lotto getSingleLotto(int index) {
        return userLotto.get(index);
    }

    public List<Lotto> getUserLotto() {
        return userLotto;
    }

    public int getUserLottoSize() {
        return userLotto.size();
    }
}
