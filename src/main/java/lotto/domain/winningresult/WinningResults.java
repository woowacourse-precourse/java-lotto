package lotto.domain.winningresult;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.LottoDraw;
import lotto.domain.lotto.Lottos;

public class WinningResults {
    private final List<WinningResultType> winningResultTypes;

    private WinningResults(List<WinningResultType> winningResultTypes) {
        this.winningResultTypes = winningResultTypes;
    }

    public static WinningResults of(Lottos lottos, LottoDraw lottoDraw) {
        List<WinningResultType> winningResultTypes = lottos.lottoStream()
                .map(lottoDraw::match)
                .collect(Collectors.toList());

        return new WinningResults(winningResultTypes);
    }

    public int count(WinningResultType winningResultType){
        return (int) winningResultTypes.stream()
                .filter(o -> o == winningResultType)
                .count();
    }

}
