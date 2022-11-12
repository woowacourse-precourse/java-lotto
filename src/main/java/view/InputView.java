package view;

public class InputView {
    private static final String LOTTOPRICE = "구입금액을 입력해 주세요.";
    private static final String INPUTLOTTONUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUTBONUSNUMBER = "보너스 번호를 입력해 주세요.";
    private static final String WINRESULT = "당첨 통계";
    private static final String LINE = "---";

    public static void printLottoPrice() {
        System.out.println(LOTTOPRICE);
    }

    public static void printInputLottoNumber() {
        System.out.println(INPUTLOTTONUMBER);
    }

    public static void printInputBonusNumber() {
        System.out.println("\n" + INPUTBONUSNUMBER);
    }

    public static void printWinResult() {
        System.out.println("\n" + WINRESULT);
    }

    public static void printLine() {
        System.out.println(LINE);
    }

}
