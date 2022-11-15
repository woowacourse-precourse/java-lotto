package lotto.ui.generator;

import lotto.model.Lotto;

import java.util.stream.Collectors;

public enum LottoReceiptGenerator {
    INSTANCE;

    private static final String PURCHASE_LOTTO_MESSAGE_FORMAT = "%d개를 구매했습니다.";

    public static String getPurchaseLottoMessage(int lottoCount) {
        return String.format(PURCHASE_LOTTO_MESSAGE_FORMAT, lottoCount);
    }

    public static String getLottoNumbersByAscendingOrder(Lotto lotto) {
        return lotto.getNumbers().stream()
                .sorted()
                .collect(Collectors.toList())
                .toString();
    }
}
