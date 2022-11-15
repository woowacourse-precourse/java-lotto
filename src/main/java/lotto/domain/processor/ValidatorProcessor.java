package lotto.domain.processor;

import lotto.domain.enummodel.LottoEnum;
import lotto.domain.enummodel.PriceEnum;

import java.util.List;

public interface ValidatorProcessor {

    void validateMoney(Integer money, PriceEnum priceEnum);

    List<Integer> validateLottoNumberInput(String input);

    void validateLottoSize(Integer size, LottoEnum lottoEnum);

    void validateLottoNumber(List<Integer> number, LottoEnum lottoEnum);
}
