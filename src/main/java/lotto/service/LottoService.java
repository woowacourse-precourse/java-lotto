package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.NumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {
    public NumberGenerator numberGenerator;
    
    public LottoService() {
        this.numberGenerator = new NumberGenerator();
    }

    public List<Lotto> publishLotto(int cnt) {
        return IntStream.range(0, cnt)
                .mapToObj(i -> new Lotto(this.numberGenerator.createDuplicateNumbers()))
                .collect(Collectors.toList());
    }
}
