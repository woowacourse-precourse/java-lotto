package lotto.domain.lotto.service;

import lotto.domain.lotto.BonusBall;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.money.Money;
import lotto.domain.profit.Profit;
import lotto.domain.statistics.Statistics;
import lotto.global.utils.convert.ConvertUtils;

import java.util.List;

public class LottoServiceImpl implements LottoService {

    private final LottoMessenger lottoMessenger;
    private final LottoCreator lottoCreator;

    public LottoServiceImpl(LottoMessenger lottoMessenger, LottoCreator lottoCreator) {
        this.lottoMessenger = lottoMessenger;
        this.lottoCreator = lottoCreator;
    }

    @Override
    public String requestMoney() {
        return lottoMessenger.requestMoney();
    }

    @Override
    public Lottos buyLottos(Money money) {
        return lottoCreator.buyLottos(money);
    }

    @Override
    public void sendLottosInfo(Lottos lottos) {
        lottoMessenger.sendLottosInfo(lottos);
    }

    @Override
    public Lotto requestWinningNumbers() {
        final String inputNumbers = lottoMessenger.requestWinningNumbers();
        final List<Integer> numbers = ConvertUtils.convertStringToIntegerList(inputNumbers);
        return Lotto.create(numbers);
    }

    @Override
    public BonusBall requestBonusNumber() {
        final String inputBonusNumber = lottoMessenger.requestBonusNumber();
        final Integer bonusNumber = ConvertUtils.convertStringToInteger(inputBonusNumber);
        return BonusBall.create(bonusNumber);
    }

    @Override
    public void sendStatistics(Statistics statistics) {
        lottoMessenger.sendStatistics(statistics);
    }

    @Override
    public void sendProfit(Profit profit) {
        lottoMessenger.sendProfit(profit);
    }

}
