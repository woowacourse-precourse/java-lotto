package lotto.application;

import lotto.domain.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class LottoFacadeImpl implements LottoFacade{

    private final LottoProcessor lottoProcessor = new LottoProcessorImpl();
    private final MoneyProcessor moneyProcessor = new MoneyProcessorImpl();
    private final ValidatorProcessor validatorProcessor = new ValidatorProcessorImpl();


    @Override
    public List<Lotto> buyLotto(Integer money) {
        validatorProcessor.validateMoney(money, PriceEnum.LOTTO_PRICE);
        Integer count = moneyProcessor.calculateLottoCount(money);
        return lottoProcessor.createLottoByCount(count);
    }

    @Override
    public Lotto registerWinLotto(String input) {
        List<Integer> validatedLottoNumber = validatorProcessor.validateLottoNumberInput(input);
        validatorProcessor.validateLottoSize(validatedLottoNumber.size(), LottoEnum.LOTTO);
        return lottoProcessor.createLotto(validatedLottoNumber);
    }

    @Override
    public String getMargin(Integer before, Integer after) {
        return moneyProcessor.calculateMargin(before, after);
    }

    @Override
    public List<Integer> checkWinning(Lotto winLotto, List<Lotto> clientLotto, Integer bonus) {
        List<Integer> result = new ArrayList<>();
        clientLotto.forEach(lotto -> {
            int count = lottoProcessor.matchLottoNumber(winLotto, lotto);
            count = checkAndCountNumber(count == RankEnum.FIRST.getMatchNumber()-1, count);
            count = checkBonus(bonus, lotto, count);
            result.add(count);
        });
        return result;
    }

    private int checkBonus(int bonus, Lotto lotto, int count) {
        if (count == RankEnum.SECOND.getMatchNumber()-1) {
            count = checkAndCountNumber(lottoProcessor.matchBonusNumber(bonus, lotto), count);
        }
        return count;
    }

    private int checkAndCountNumber(boolean check, int count) {
        if (check) {
            count++;
        }
        return count;
    }
}
