package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;
    
    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }
    
    public List<LottoRank> parseRanks(final WinningLottoNumbers winningLottoNumbers) {
        return lottos.stream()
                .map(lotto -> parseRank(winningLottoNumbers, lotto))
                .collect(Collectors.toList());
    }
    
    private LottoRank parseRank(final WinningLottoNumbers winningLottoNumbers, final Lotto lotto) {
        int countOfSameLottoNumber = countOfMatchingNumber(winningLottoNumbers, lotto);
        boolean existBonusLottoNumber = isBonusNumberExist(winningLottoNumbers, lotto);
    
        return LottoRank.parseRank(countOfSameLottoNumber, existBonusLottoNumber);
    }
    
    private int countOfMatchingNumber(final WinningLottoNumbers winningLottoNumbers, final Lotto lotto) {
        return winningLottoNumbers.countOfMatchingNumber(lotto);
    }
    
    private boolean isBonusNumberExist(final WinningLottoNumbers winningLottoNumbers, final Lotto lotto) {
        return winningLottoNumbers.isBonusNumberExist(lotto);
    }
    
    public List<List<Integer>> lottos() {
        return lottos.stream()
                .map(Lotto::lottoNumber)
                .collect(Collectors.toList());
    }
    
    @Override
    public String toString() {
        return "Lottos{" +
                "lottos=" + lottos +
                '}';
    }
}
