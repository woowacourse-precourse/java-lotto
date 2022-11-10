package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoService {

    public List<LottoResult> compareLottoNumbers(List<Lotto> lottoBundle,
                                                 List<Integer> winningNumbers,
                                                 int bonusNumber) {
        return lottoBundle.stream()
                .map(lotto -> lotto.result(winningNumbers, bonusNumber))
                .collect(Collectors.toList());
    }
}
