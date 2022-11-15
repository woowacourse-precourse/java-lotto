package lotto.ui;

public enum OutputMessageGenerator {
    INSTANCE;

    private static final String PURCHASE_LOTTO_MESSAGE_FORMAT = "%d개를 구매했습니다.";

    public static String getPurchaseLottoMessage(int lottoCount) {
        return String.format(PURCHASE_LOTTO_MESSAGE_FORMAT, lottoCount);
    }
}
