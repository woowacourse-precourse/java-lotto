package lotto.view;

import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class OutputViewFormatter {
    public String outputLottoFormat(Lotto lotto) {
        return lotto.numbers().stream()
                .sorted()
                .collect(Collectors.toList())
                .toString();
    }
}
