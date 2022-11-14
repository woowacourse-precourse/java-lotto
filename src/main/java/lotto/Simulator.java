package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Simulator {
    private int quantity;
    private List<Lotto> lottos;

    public Simulator(int price) {
        validatePrice(price);
        this.quantity = toQuantity(price);
        this.lottos = generate(this.quantity);
    }

    public int getQuantity() {
        return this.quantity;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    private void validatePrice(int price) {
        if ((price % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야합니다.");
        }
    }

    private int toQuantity(int price) {
        return price / 1000;
    }

    public static List<Lotto> generate(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(generate());
        }
        return lottos;
    }
    public static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
