package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.dto.TotalWinningLottoDto;
import lotto.domain.enums.WinResultStatus;

public class TotalLotto {
    public static final String NEXT_LINE = "\n";
    private final List<Lotto> lottos = new ArrayList<>();

    public TotalLotto(final List<Lotto> buyingLottos) {
        this.lottos.addAll(buyingLottos);
    }

    public int getLottoCount() {
        return lottos.size();
    }

    @Override
    public String toString() {
        StringBuilder lottoLog = new StringBuilder();
        lottos.stream()
                .map(Lotto::toString)
                .forEach(log -> lottoLog.append(log)
                        .append(NEXT_LINE));
        return lottoLog.toString();
    }

    public List<WinResultStatus> getResult(final TotalWinningLottoDto totalWinningLotto) {
        return lottos.stream()
                .map(lotto -> lotto.getMatchResult(totalWinningLotto))
                .collect(Collectors.toList());
    }
}
