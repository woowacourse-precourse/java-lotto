package lotto.domain;

import java.util.List;

public interface ValidatorProcessor {

    void validateMoney(Integer money, PriceEnum priceEnum);

    List<Integer> validateLottoNumberInput(String input);
}
