package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.BonusNumber;
import lotto.domain.TotalLotto;
import lotto.domain.WinningNumber;
import lotto.domain.WinningResult;
import lotto.domain.WinningResults;
import lotto.domain.dto.TotalWinningLottoDto;
import lotto.domain.enums.WinResultStatus;
import lotto.repository.BonusNumberRepository;
import lotto.repository.LottoRepository;
import lotto.repository.WinningNumberRepository;

public class LottoService {
    private final LottoRepository lottoRepository = LottoRepository.getInstance();
    private final WinningNumberRepository winningNumberRepository = WinningNumberRepository.getInstance();
    private final BonusNumberRepository bonusNumberRepository = BonusNumberRepository.getInstance();

    public TotalLotto buyLottos(final int validatedPrice) {
        return new TotalLotto(lottoRepository.generateLotto(validatedPrice));
    }

    public void saveWinningNumber(final List<Integer> winningNumber) {
        winningNumberRepository.save(new WinningNumber(winningNumber));
    }

    public void saveBonusNumber(final int bonusNumber) {
        winningNumberRepository.find()
                .validateBonusNumber(bonusNumber);
        bonusNumberRepository.save(new BonusNumber(bonusNumber));
    }


    public WinningResults generateWinningResult() {
        WinningResults winningResults = createDefaultWinningResults();
        winningResults.generate(
                new TotalLotto(lottoRepository.findAll()),
                new TotalWinningLottoDto(winningNumberRepository.find(), bonusNumberRepository.find())
        );
        return winningResults;
    }

    private WinningResults createDefaultWinningResults() {
        return new WinningResults(Arrays.stream(WinResultStatus.values())
                .map(WinningResult::new)
                .collect(Collectors.toList()));
    }

    public int findLottoCount() {
        return lottoRepository.findAll()
                .size();
    }
}
