package lotto;

import static java.lang.Integer.parseInt;
import static lotto.utils.ConstantUtil.MIN_LOTTO_PRICE;
import static lotto.utils.RandomUtil.createRandomNumbers;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private int money;

    public LottoMachine() {
    }

    public void inputMoney(int money) {
        validate(money);
        this.money = money;
    }

    public List<Lotto> publishLotto() {
        List<Lotto> allLotto = new ArrayList<>();

        while (money != 0) {
            allLotto.add(new Lotto(createRandomNumbers()));
            spendMoney();
        }

        return allLotto;
    }

    public Lotto publishWinningLotto(String winningNumbers) {
        return new Lotto(convertToList(winningNumbers));
    }

    private List<Integer> convertToList(String numbers) {
        List<Integer> convertedNumbers = new ArrayList<>();

        for (String number : numbers.split(",")) {
            convertedNumbers.add(parseInt(number));
        }

        return convertedNumbers;
    }

    private void spendMoney() {
        money -= MIN_LOTTO_PRICE;
    }

    private void validate(int money) {
        Validator validator = new Validator();

        validator.validateMinMoney(money);
        validator.validateMoneyUnit(money);
    }
}
