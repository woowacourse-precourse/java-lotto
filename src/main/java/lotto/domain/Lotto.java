package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.config.BaseValidation.*;
import static lotto.config.Constant.LOTTO_NUMBER_CAPACITY;

public class Lotto {

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {

        validate(numbers);
        this.numbers = numbers;

    }

    public static void run() {

        Customer customer = new Customer();
        Store store = new Store();
        Checker checker = new Checker();
        List<Lotto> lottos = new ArrayList<>();

        customer.payMoney();

        customer.buyLotto();

        store.drawNumber(customer.getHasLotto());

        for (int i = 0;i < customer.getHasLotto();i++) {
            lottos.add(new Lotto(store.getNumbers().get(i)));
            lottos.get(i).showLotto();
        }

        checker.insertWinningNumbers();

        checker.insertBonusNumber();

        for (int i = 0;i < customer.getHasLotto();i++) {
            checker.checkMyLotto(lottos.get(i).getLotto());
        }

        checker.showWinningStats();
        checker.calculateRateOfReturn(customer.getMoney());

    }

    private void validate(List<Integer> numbers) {

        if (numbers.size() != LOTTO_NUMBER_CAPACITY) {
            throw new IllegalArgumentException(OVER_CAPACITY_LOTTO.getMessage());
        }

        for (int i = 0; i < LOTTO_NUMBER_CAPACITY - 1;i++) {
            if (numbers.get(i) == numbers.get(i + 1)) {
                throw new IllegalArgumentException(DUPLICATION_NUMBER_LOTTO.getMessage());
            }
        }
    }

    public List<Integer> getLotto() {
        return numbers;
    }

    public void showLotto() {
        System.out.println(numbers);
    }

}
