package lotto.domain.lotto;


import java.util.List;
import java.util.stream.Collectors;

/**
 * 로또 묶음
 */
public class LottoBundle {
    private final List<Lotto> lottoBundle;

    public LottoBundle(final List<List<Integer>> input) {
        this.lottoBundle = input.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    // 소지하고 있는 로또를 리스트를 보여줌
    public String listUpLotto() {
        var stringBuilder = new StringBuilder();
        for (var lotto : lottoBundle) {
            stringBuilder.append(lotto.print()).append("\n");
        }
        return stringBuilder.toString().trim();
    }
}
