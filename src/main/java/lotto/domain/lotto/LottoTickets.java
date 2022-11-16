package lotto.domain.lotto;

import lotto.domain.LottoResult;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningRank;
import lotto.utils.LottoNumberGenerator;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {

    private final List<Lotto> lottoTickets;

    public LottoTickets(int lottoCount, LottoNumberGenerator lottoNumberGenerator) {
        this.lottoTickets = generateLottoTickets(lottoCount, lottoNumberGenerator);
    }

    private List<Lotto> generateLottoTickets(int lottoCount, LottoNumberGenerator lottoNumberGenerator) {
        return IntStream.range(0, lottoCount)
                .mapToObj(count -> new Lotto(lottoNumberGenerator.generate()))
                .collect(Collectors.toList());
    }

    public LottoResult makeResult(WinningNumbers winningNumbers) {
        Map<WinningRank, Integer> resultBoard = new HashMap<>();

        for (Lotto lotto : lottoTickets) {
            WinningRank winningRank = winningNumbers.check(lotto);
            resultBoard.put(winningRank, resultBoard.getOrDefault(winningRank, 0) + 1);
        }

        return new LottoResult(resultBoard);
    }

    public int getCount() {
        return lottoTickets.size();
    }

    public List<Lotto> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}

