package lotto.service;

import lotto.domain.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {
    public NumberGenerator numberGenerator;
    
    public LottoService() {
        this.numberGenerator = new NumberGenerator();
    }

    public Lottos publishLotto(String input) {
        List<Lotto> result = IntStream.range(0, new Money(input).getLottoCount())
                .mapToObj(i -> new Lotto(this.numberGenerator.createDuplicateNumbers()))
                .collect(Collectors.toList());

        return new Lottos(result);
    }

    public void getLottosByMoney(Buyer buyer, String input) {
        buyer.buyLottos(publishLotto(input));
    }
}
