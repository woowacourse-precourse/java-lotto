package lotto.view;

public class OutputView {
    private static final String PAY_NOTICE = "구입금액을 입력해 주세요.";
    private static final String ERR_PREFIX = "[ERROR] ";

    public static void announcePayNotice() {
        System.out.println(PAY_NOTICE);
    }

    public static void announceError(String msg) {
        System.out.println(ERR_PREFIX+msg);
    }
}
