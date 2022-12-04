package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.List;
import java.util.stream.Collectors;

public enum LottosView {

    LOTTOS_COUNT("%d개를 구매했습니다.\n"),
    ;

    private final String format;

    LottosView(String format) {
        this.format = format;
    }

    public String render(Lottos lottos) {
        return String.format(format, lottos.size()) + toString(lottos);
    }

    public String toString(Lottos lottos) {
        return lottos.getLottos().stream()
                .map(Lotto::getNumbers)
                .map(this::listToString)
                .collect(Collectors.joining("\n"));
    }

    private String listToString(List<Integer> list) {
        return list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
