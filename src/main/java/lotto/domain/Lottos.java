package lotto.domain;

import lotto.dto.WinningLottoNumbersDTO;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;
    
    public <E> Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }
    
    public List<LottoRank> parseRanks(final WinningLottoNumbersDTO winningLottoNumbersDTO) {
        return lottos.stream()
                .map(lotto -> parseRank(winningLottoNumbersDTO, lotto))
                .collect(Collectors.toList());
    }
    
    private LottoRank parseRank(final WinningLottoNumbersDTO winningLottoNumbersDTO, final Lotto lotto) {
        final Lotto winningLotto = winningLottoNumbersDTO.getWinningLotto();
        final int bonusNumber = winningLottoNumbersDTO.getBonusNumber();
        
        return LottoRank.parseRank(lotto.countOfSameNumber(winningLotto), lotto.containsNumber(bonusNumber));
    }
}
