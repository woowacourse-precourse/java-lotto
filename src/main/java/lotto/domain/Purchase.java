package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.Error;

public class Purchase {

    private static final int LOTTO_PRICE = 1_000;

    private List<Lotto> lottos;
    private final int amount;
    private final int count;

    public Purchase(int amount) {
        validate(amount);
        this.amount = amount;
        this.count = amount / LOTTO_PRICE;
    }

    private void validate(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(Error.WRONG_AMOUNT.getMessage());
        }
    }

    public List<Lotto> createLottos() {
        lottos = new ArrayList<>();

        for (int i = 0; i < this.count; i++) {
            lottos.add(new Lotto(NumberGenerator.createDifferentRandomNumbers()));
        }

        return lottos;
    }

    public void printLottos() {
        lottos.forEach(System.out::println);
    }

    public int createLottoBonusNumber() {
        return NumberGenerator.createRandomNumber();
    }

    public void printCount() {
        System.out.println(count + "개를 구매했습니다.");
    }

    public int getAmount() {
        return amount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
