package lotto.model.dto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.model.domain.Lotto;

public class LottosDto {

    private static final String BUY_SOME = "개를 구매했습니다.\n";

    private final List<Lotto> lottos;

    public LottosDto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    @Override
    public String toString() {
        String numberOfBuying = lottos.size() + BUY_SOME;
        String lottoNumbers = lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining());

        return numberOfBuying + lottoNumbers;
    }

    public List<Lotto> get() {
        return lottos;
    }
}
