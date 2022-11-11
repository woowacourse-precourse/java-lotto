package lotto;

public class Print {

    private final static String INPUT_PRICE = "구입금액을 입력해 주세요.";
    private final static String INPUT_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
    private final static String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private final static String BUY_LOTTO = "개를 구매했습니다.";

    public static void inputPrice() {
        System.out.println(INPUT_PRICE);
    }

    public static void inputLottoNumbers() {
        System.out.println(INPUT_LOTTO_NUMBERS);
    }

    public static void inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public static void newLine() {
        System.out.println();
    }

    public static void buyLotto(int count) {
        System.out.print(count);
        System.out.println(BUY_LOTTO);
    }
}
