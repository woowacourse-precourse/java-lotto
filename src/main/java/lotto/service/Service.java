package lotto.service;

import java.util.List;

import lotto.domain.Lotteries;
import lotto.domain.Lotto;
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

    public List<List<Integer>> getPurchaseResult() {
        return lotteries.getLotteries();
    }

    private void generateLotteries(int lottoPrice) {
        lotteries = Lotteries.generateLotteriesByPrice(lottoPrice);
    }

}
