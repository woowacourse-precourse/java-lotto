package lotto.domain;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        validate(lottos);
        this.lottos = lottos;
    }


    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    private void validate(List<Lotto> lottos) {
        if(lottos.isEmpty()){
            throw new IllegalArgumentException("1개 이상의 로또가 포함되어 있어야합니다.");
        }
    }

    public List<Lotto> get() {
        return lottos;
    }
}
