package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoService {

    public List<LottoResult> compareLottoNumbers(List<Lotto> lottoTickets,
                                                 List<Integer> winningNumbers,
                                                 int bonusNumber) {
        return lottoTickets.stream()
                .map(lotto -> lotto.result(winningNumbers, bonusNumber))
                .collect(Collectors.toList());
    }
}
