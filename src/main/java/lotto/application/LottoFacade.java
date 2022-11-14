package lotto.application;

import lotto.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class LottoFacade {

    private final LottoProcessor lottoProcessor = new LottoProcessorImpl();
    private final MoneyProcessor moneyProcessor = new MoneyProcessorImpl();
    private final ValidatorProcessor validatorProcessor = new ValidatorProcessorImpl();


    public List<Lotto> buyLotto(Integer money) {
        validatorProcessor.validateMoney(money, PriceEnum.LOTTO_PRICE);
        Integer count = moneyProcessor.calculateLottoCount(money);
        return lottoProcessor.createLottoByCount(count);
    }

    public Lotto registerWinLotto(String input) {
        List<Integer> validatedLottoNumber = validatorProcessor.validateLottoNumberInput(input);
        validatorProcessor.validateLottoSize(validatedLottoNumber.size(), LottoEnum.LOTTO);
        return lottoProcessor.createLotto(validatedLottoNumber);
    }
}
