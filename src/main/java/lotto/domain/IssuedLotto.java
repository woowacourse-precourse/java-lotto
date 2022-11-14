package lotto.domain;

import static lotto.io.Message.LF;

import java.util.List;

public class IssuedLotto {

    private final List<Lotto> lotto;

    private IssuedLotto(List<Lotto> lotto) {
        this.lotto = lotto;
    }

    public static IssuedLotto issue(List<Lotto> lotto) {
        if (lotto.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return new IssuedLotto(lotto);
    }

    public void add(Lotto lotto) {
        this.lotto.add(lotto);
    }

    public int getAmount() {
        return this.lotto.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto l : lotto) {
            sb.append(l).append(LF);
        }
        return sb.toString();
    }

}
