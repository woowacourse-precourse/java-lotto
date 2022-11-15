package lotto.model;

import static java.lang.Integer.parseInt;
import static lotto.utils.ConstantUtil.ERROR;
import static lotto.utils.RandomUtil.createRandomNumbers;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int MIN_LOTTO_PRICE = 1000;
    private static final String MIN_MONEY_ERROR_MESSAGE = ERROR + "구입금액은 1000원 이상부터 가능합니다.";
    private static final String MONEY_UNIT_ERROR_MESSAGE = ERROR + "구입금액은 1000원 단위만 가능합니다.";

    private int money;

    public void inputMoney(int money) {
        validate(money);
        this.money = money;
    }

    public List<Lotto> publishLotto() {
        List<Lotto> publishedAllLotto = new ArrayList<>();

        while (hasMoney()) {
            publishedAllLotto.add(new Lotto(createRandomNumbers()));
            spendMoney();
        }

        return publishedAllLotto;
    }

    public Lotto publishWinningLotto(String winningNumbers) {
        return new Lotto(convert(winningNumbers));
    }

    public Bonus publishBonus(int bonusNumber, Lotto winningLotto) {
        return new Bonus(bonusNumber, winningLotto);
    }

    private List<Integer> convert(String numbers) {
        List<Integer> convertedNumbers = new ArrayList<>();

        for (String number : numbers.split(",")) {
            convertedNumbers.add(parseInt(number));
        }

        return convertedNumbers;
    }

    private boolean hasMoney() {
        return money > 0;
    }

    private void spendMoney() {
        money -= MIN_LOTTO_PRICE;
    }

    private void validate(int money) {
        validateMinMoney(money);
        validateMoneyUnit(money);
    }

    private void validateMinMoney(int money) {
        if (money < MIN_LOTTO_PRICE) {
            throw new IllegalArgumentException(MIN_MONEY_ERROR_MESSAGE);
        }
    }

    private void validateMoneyUnit(int money) {
        if (isNotValidMoneyUnit(money)) {
            throw new IllegalArgumentException(MONEY_UNIT_ERROR_MESSAGE);
        }
    }

    private boolean isNotValidMoneyUnit(int money) {
        return money % MIN_LOTTO_PRICE != 0;
    }
}
