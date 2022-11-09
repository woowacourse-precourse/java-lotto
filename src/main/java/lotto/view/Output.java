package lotto.view;

import static java.util.stream.Collectors.joining;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;

public class Output {

    private static final String NEW_LINE_REGEX = "\n";
    private static final String LOTTO_NUMBER_DELIMITER = ", ";
    private static final String LOTTO_NUMBERS_PREFIX = "[";
    private static final String LOTTO_NUMBERS_SUFFIX = "]";
    private static final String LOTTO_PURCHASE_MESSAGE = "개를 구매했습니다.";

    public void printPurchaseInfo(LottoTicket lottoTicket) {
        System.out.println(lottoTicket.getQuantity() + LOTTO_PURCHASE_MESSAGE);
        printLottoTicket(lottoTicket.getLottoTicket());
    }

    private void printLottoTicket(List<Lotto> lottos) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottos) {
            stringBuilder.append(printLotto(lotto))
                    .append(NEW_LINE_REGEX);
        }
        System.out.println(stringBuilder);
    }

    private String printLotto(Lotto lotto) {
        return lotto.getLotto().stream()
                .sorted()
                .map(number -> String.valueOf(number))
                .collect(joining(LOTTO_NUMBER_DELIMITER, LOTTO_NUMBERS_PREFIX, LOTTO_NUMBERS_SUFFIX));
    }
}
