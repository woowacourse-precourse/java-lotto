package lotto.model;

import java.util.ArrayList;
import java.util.List;

import static lotto.utils.Constant.LOTTO_PRICE;

public class Lottos {
    public static final String INPUT_RIGHT_MONEY = "1000원으로 나누어 떨어지는 금액을 입력해주세요.";

    private final List<Lotto> lottos = new ArrayList<>();

    private Lottos(int money) {
        validateMoney(money);
        purchaseLotto(money);
    }

    private static void validateMoney(int money) {
        if (isRestMoney(money)) {
            throw new IllegalArgumentException(INPUT_RIGHT_MONEY);
        }
    }

    private void purchaseLotto(int money) {
        int totalLotto = money / LOTTO_PRICE;
        for (int count = 0; count < totalLotto; count++) {
            lottos.add(Lotto.create());
        }
    }

    private static boolean isRestMoney(int money) {
        return money % LOTTO_PRICE != 0;
    }

    public static Lottos purchaseLottos(int money) {
        return new Lottos(money);
    }

    public void printAll() {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
    }
}
