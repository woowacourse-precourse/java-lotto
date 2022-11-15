package lotto;

public class InputView {
    public enum Messages {
        PURCHASING_AMOUNT("구입금액을 입력해 주세요."),
        LOTTO_NUMBERS("\n당첨 번호를 입력해 주세요."),
        LOTTO_BONUS_NUMBER("\n보너스 번호를 입력해주세요.");

        private final String message;
        Messages(String message) {
            this.message = message;
        }
    }

    public static void printPurchasingAmount() {
        System.out.println(Messages.PURCHASING_AMOUNT.message);
    }

    public static void printLottoNumbers() {
        System.out.println(Messages.LOTTO_NUMBERS.message);
    }

    public static void printLottoBonusNumber() {
        System.out.println(Messages.LOTTO_BONUS_NUMBER.message);
    }
}
