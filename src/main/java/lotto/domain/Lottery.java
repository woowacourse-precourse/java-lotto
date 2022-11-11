package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottery {
    public List<Lotto> createLottery(int buyLottos, CreateStrategy lottoCreateStrategy) {
        return IntStream.range(0, buyLottos)
                .mapToObj(ticket -> lottoCreateStrategy.createTempLottoNumber())
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

}
