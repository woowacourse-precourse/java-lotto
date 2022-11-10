package lotto.service;

import java.util.List;

import lotto.domain.Lotto;
import lotto.utils.Converter;
import lotto.utils.Validator;

public class Service {
    public void generateLottoList(String lottoPrice) {
        try {
            int lottoPriceNumber = Converter.toIntFromString(lottoPrice);
            Validator.validateLottoPrice(lottoPriceNumber);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            throw new IllegalArgumentException();
        }
    }
}
