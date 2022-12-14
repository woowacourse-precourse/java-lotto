package lotto.service;

import java.util.List;
import lotto.domain.TotalLotto;
import lotto.domain.WinningNumber;
import lotto.repository.LottoRepository;
import lotto.repository.WinningNumberRepository;

public class LottoService {
    private final LottoRepository lottoRepository = LottoRepository.getInstance();
    private final WinningNumberRepository winningNumberRepository = WinningNumberRepository.getInstance();

    public TotalLotto buyLottos(final int validatedPrice) {
        return lottoRepository.generateLotto(validatedPrice);
    }

    public void saveWinningNumber(final List<Integer> winningNumber) {
        winningNumberRepository.save(new WinningNumber(winningNumber));
    }
}
