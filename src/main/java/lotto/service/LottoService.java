package lotto.service;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.TotalLotto;
import lotto.domain.WinningNumber;
import lotto.repository.BonusNumberRepository;
import lotto.repository.LottoRepository;
import lotto.repository.WinningNumberRepository;

public class LottoService {
    private final LottoRepository lottoRepository = LottoRepository.getInstance();
    private final WinningNumberRepository winningNumberRepository = WinningNumberRepository.getInstance();
    private final BonusNumberRepository bonusNumberRepository = BonusNumberRepository.getInstance();

    public TotalLotto buyLottos(final int validatedPrice) {
        return lottoRepository.generateLotto(validatedPrice);
    }

    public void saveWinningNumber(final List<Integer> winningNumber) {
        winningNumberRepository.save(new WinningNumber(winningNumber));
    }

    public void saveBonusNumber(final int bonusNumber) {
        winningNumberRepository.find()
                .validateBonusNumber(bonusNumber);
        bonusNumberRepository.save(new BonusNumber(bonusNumber));
    }


}
