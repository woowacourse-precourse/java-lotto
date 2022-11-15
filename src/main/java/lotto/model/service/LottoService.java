package lotto.model.service;

import java.util.List;
import lotto.model.domain.BonusNumber;
import lotto.model.domain.Lotto;
import lotto.model.domain.Lottos;
import lotto.model.domain.PayingMoney;
import lotto.model.domain.WinningLotto;
import lotto.model.domain.WinningStatistics;
import lotto.model.dto.LottosDto;
import lotto.model.dto.WinningLottoDto;
import lotto.model.dto.WinningStatisticsDto;
import lotto.utils.Utils;

public class LottoService {

    private static final int NUM_MIN = 1;
    private static final int NUM_MAX = 45;
    private static final int LOTTO_SIZE = 6;

    public LottosDto createLottos(String money) {
        PayingMoney payingMoney = new PayingMoney(money);
        int numOfLottoBuying = payingMoney.countNumberOfLottoBuying();
        List<List<Integer>> randomNumbers = Utils.createRandomNumbers(NUM_MIN, NUM_MAX, LOTTO_SIZE, numOfLottoBuying);
        Lottos lottos = new Lottos(randomNumbers);

        return lottos.toDto();
    }

    public WinningLottoDto createWinningNumber(String winningNumberString, String bonusNumberString) {
        WinningLotto winningLotto = new WinningLotto(winningNumberString, bonusNumberString);

        return winningLotto.toDto();
    }

    public WinningStatisticsDto createWinningStatistics(LottosDto lottosDto, WinningLottoDto winningLottoDto) {
        List<Lotto> lottos = lottosDto.get();
        Lotto winningLotto = winningLottoDto.getLotto();
        BonusNumber bonusNumber = winningLottoDto.getBonusNumber();
        WinningStatistics winningStatistics = new WinningStatistics(lottos, winningLotto, bonusNumber);

        return winningStatistics.toDto();
    }
}
