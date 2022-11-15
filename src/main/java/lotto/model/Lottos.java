package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final List<Lotto> lottos;

    public Lottos(int quantity) {
        this.lottos = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            Lotto lotto =
                    new Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT));
            lottos.add(lotto);
        }
    }

    public Lotto getLotto(int index) {
        return lottos.get(index);
    }

    public int getQuantity() {
        return lottos.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(lottos.size() + "개를 구매했습니다.\n");

        for (Lotto lotto : lottos) {
            sb.append(lotto.toString()).append("\n");
        }

        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }

        return sb.toString();
    }
}
