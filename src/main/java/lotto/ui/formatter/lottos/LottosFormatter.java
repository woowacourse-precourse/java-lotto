package lotto.ui.formatter.lottos;

import java.util.stream.Collectors;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.ui.formatter.OutputFormatter;

public class LottosFormatter implements OutputFormatter<Lottos> {
    private static final String LINE_BREAK = "\n";
    private static final String LOTTO_DIAMETER = "\n";
    private static final String LOTTO_PURCHASED_MESSAGE = "개를 구매했습니다.";
    private final OutputFormatter<Lotto> lottoOutputFormatter;

    public LottosFormatter(OutputFormatter<Lotto> lottoOutputFormatter) {
        this.lottoOutputFormatter = lottoOutputFormatter;
    }

    @Override
    public String outputFormat(Lottos lottos) {
        StringBuilder lottosFormat = new StringBuilder();
        int purchasedLottoSize = lottos.size();
        purchasedLottoAmountFormat(lottosFormat, purchasedLottoSize);

        lottosFormat.append(lottos.lottoStream()
                .map(lottoOutputFormatter::outputFormat)
                .collect(Collectors.joining(LOTTO_DIAMETER)));

        return lottosFormat.toString();
    }

    private void purchasedLottoAmountFormat(StringBuilder lottosFormat, int purchasedLottoSize) {
        lottosFormat.append(purchasedLottoSize)
                .append(LOTTO_PURCHASED_MESSAGE)
                .append(LINE_BREAK);
    }
}
