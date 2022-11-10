package lotto.service;

import lotto.domain.Lotteries;
import lotto.utils.Converter;
import lotto.utils.Validator;

public class Service {
    Lotteries lotteries;

    public void generateLottoList(String lottoPrice) {
        try {
            int lottoPriceNumber = Converter.toIntFromString(lottoPrice);
            Validator.validateLottoPrice(lottoPriceNumber);
            generateLotteries(lottoPriceNumber);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private void generateLotteries(int lottoPrice) {
        lotteries = Lotteries.generateLotteriesByPrice(lottoPrice);
    }
}
