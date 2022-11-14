package lotto.domain;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<LottoPrize> mapToLottoPrize(Function<Lotto, LottoPrize> function) {
        return lottos.stream()
                .map(function)
                .collect(Collectors.toList());
    }
}
