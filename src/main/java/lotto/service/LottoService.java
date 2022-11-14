package lotto.service;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PayingMoney;
import lotto.domain.WinningNumber;
import lotto.domain.WinningStatistics;
import lotto.dto.LottosDto;
import lotto.dto.WinningNumberDto;
import lotto.dto.WinningStatisticsDto;
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

    public WinningNumberDto createWinningNumber(String winningNumberString, String bonusNumberString) {
        WinningNumber winningNumber = new WinningNumber(winningNumberString, bonusNumberString);

        return winningNumber.toDto();
    }

    public WinningStatisticsDto createWinningStatistics(LottosDto lottosDto, WinningNumberDto winningNumberDto) {
        List<Lotto> lottos = lottosDto.get();
        Lotto winningLotto = winningNumberDto.getLotto();
        BonusNumber bonusNumber = winningNumberDto.getBonusNumber();
        WinningStatistics winningStatistics = new WinningStatistics(lottos, winningLotto, bonusNumber);

        return winningStatistics.toDto();
    }
}
