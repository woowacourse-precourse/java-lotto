package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Cashier {
    static final int LOTTO_PRICE = 1000;
    private int lottoAmount;

    public Cashier() {
        this.lottoAmount = 0;
    }

    public int getLottoAmount() {
        return lottoAmount;
    }

    private int checkInputPrice(int userValue) {
        if (!isBiggerThanZero(userValue)) {
            System.out.println("[ERROR] 음수 값이 입력되었습니다.");
            throw new IllegalArgumentException();
        }
        if (!isDividedByThousand(userValue)) {
            System.out.println("[ERROR] 1,000원으로 나누어 떨어지지 않는 값이 입력되었습니다.");
            throw new IllegalArgumentException();
        }
        return userValue;
    }

    public void sellLotto(int userValue, List<Lotto> lottos) {
        lottoAmount = checkInputPrice(userValue) / 1000;
        System.out.println(lottoAmount + "개를 구매했습니다.");
        releaseLotto(lottos);
    }

    private void releaseLotto(List<Lotto> lottos) {
        for (int i = 0; i < lottoAmount; i++) {
            Lotto purchasedLotto = new Lotto();
            System.out.println(purchasedLotto.getNumbers());
            lottos.add(purchasedLotto);
        }
    }

    private boolean isBiggerThanZero(int userValue) {
        return userValue >= 0;
    }

    private boolean isDividedByThousand(int userValue) {
        return userValue % 1000 == 0;
    }
}
