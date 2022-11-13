package lotto;

import lotto.domain.LottoRunner;

public class Application {
    private static final String _error = "[ERROR]";

    public static void main(String[] args) {
        LottoRunner.run();
    }

    public static void lottoError(String error_msg) {
        throw new IllegalArgumentException(_error + " " + error_msg);
    }
}
