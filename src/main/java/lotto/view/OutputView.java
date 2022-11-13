package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lottos;

public class OutputView {
    private final OutputViewFormatter outputViewFormatter;

    public OutputView() {
        this.outputViewFormatter = new OutputViewFormatter();
    }

    public void outputLottos(Lottos lottos) {
        for (String lottoOutput : lottoOutputTexts(lottos)) {
            System.out.println(lottoOutput);
        }
    }

    private List<String> lottoOutputTexts(Lottos lottos) {
        return lottos.lottos().stream()
                .map(outputViewFormatter::outputLottoFormat)
                .collect(Collectors.toList());
    }
}
