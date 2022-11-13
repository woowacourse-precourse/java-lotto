package lotto;

import lotto.numbers_generator.Context;
import lotto.numbers_generator.LottoNumbersGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoVendor {
    private final LottoNumbersGenerator lottoNumbersGenerator = Context.getLottoNumbersGenerator();
    private final Integer lottoPrice = 1000;

    List<List<Integer>> purchase(Integer amount){
        List<List<Integer>> ret = new ArrayList<>();
        if(amount % lottoPrice != 0)
            throw new IllegalArgumentException();
        int lottoQuantity = amount / lottoPrice;
        while(lottoQuantity-- != 0)
            ret.add(lottoNumbersGenerator.generate());
        return ret;
    }
}
