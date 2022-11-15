package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        validate(lottos);
        this.lottos = lottos;
    }

    private void validate(List<Lotto> lottos) {
        if (lottos == null) {
            throw new IllegalArgumentException("로또가 생성되지 않았습니다.");
        }
    }

    public LottoResult getResult(Lotto winningNumbers, LottoNumber bonusNumber) {
        validateBonusNumber(winningNumbers, bonusNumber);
        List<Rank> rewards = findRanks(winningNumbers, bonusNumber);
        return new LottoResult(rewards);
    }

    private List<Rank> findRanks(Lotto winningNumbers, LottoNumber bonusNumber) {
        return lottos.stream()
                .map(lotto -> Rank.findRank(lotto.countMatchNumber(winningNumbers), lotto.isMatch(bonusNumber)))
                .collect(Collectors.toList());
    }

    private void validateBonusNumber(Lotto winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.isMatch(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
