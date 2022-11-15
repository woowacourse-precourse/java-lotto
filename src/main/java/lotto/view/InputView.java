package lotto.view;

public class InputView {
    private static final String INPUT_LOTTO_START = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNINGNUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUSNUMBER = "보너스 번호를 입력해 주세요.";

    public static void gameStart() {
        System.out.println(INPUT_LOTTO_START);
    }

    public static void printWinningNumberIntro() {
        System.out.println();
        System.out.println(INPUT_WINNINGNUMBER);
    }
     public static void printBonusNumberIntro() {
        System.out.println();
        System.out.println(INPUT_BONUSNUMBER);
    }

}
