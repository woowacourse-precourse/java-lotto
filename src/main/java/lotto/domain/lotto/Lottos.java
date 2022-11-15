package lotto.domain.lotto;

import java.util.List;

public class Lottos {

    private static final String LEFT_BRACKET = "[";
    private static final String RIGHT_BRACKET = "]";

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Integer size() {
        return lottos.size();
    }

    public void sendInfo() {
        lottos.forEach(lotto -> System.out.println(LEFT_BRACKET + lotto.numbers() + RIGHT_BRACKET));
    }
}
