package lotto.ui;

import lotto.domain.Lotto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum OutputMessageGenerator {
    INSTANCE;

    private static final String PURCHASE_LOTTO_MESSAGE_FORMAT = "%d개를 구매했습니다.";

    public static String getPurchaseLottoMessage(int lottoCount) {
        return String.format(PURCHASE_LOTTO_MESSAGE_FORMAT, lottoCount);
    }

    public static List<String> getAllLottoNumbersByAscendingOrder(List<Lotto> lotteries) {
        return lotteries.stream()
                .map(OutputMessageGenerator::getLottoNumbersByAscendingOrder)
                .collect(Collectors.toList());
    }
    private static String getLottoNumbersByAscendingOrder(Lotto lotto) {
        return lotto.getNumbers().stream()
                .sorted()
                .collect(Collectors.toList())
                .toString();
    }
}
