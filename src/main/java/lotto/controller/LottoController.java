package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;

import java.util.List;

public class LottoController {

    public List<Lotto> create(String price) {
        return LottoGenerator.generate(price);
    }
}
