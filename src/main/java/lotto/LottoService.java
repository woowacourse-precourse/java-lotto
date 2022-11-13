package lotto;

import lotto.numbers_generator.Context;
import lotto.numbers_generator.LottoNumbersGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final LottoNumbersGenerator lottoNumbersGenerator = Context.getLottoNumbersGenerator();
    private final Integer lottoPrice = 1000;

    List<Lotto> purchase(Integer amount){
        List<Lotto> ret = new ArrayList<>();
        if(amount % lottoPrice != 0)
            throw new IllegalArgumentException();
        int lottoQuantity = amount / lottoPrice;
        while(lottoQuantity-- != 0)
            ret.add(new Lotto(lottoNumbersGenerator.generate()));
        return ret;
    }


}
