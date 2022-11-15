package constance;

import java.text.DecimalFormat;

public class Values {
    public enum Texts {
        PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
        PURCHASE_RESULT("%d개를 구매했습니다.\n%s"),
        WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
        BONUS_NUMBERS("보너스 번호를 입력해 주세요."),
        RESTART("게임을 재시작합니다."),
        WINNING_STATS("당첨 통계"),
        DIVISION("---"),
        COINCIDE_RESULT("%d개 일치%s (%s원) - %d개"),
        COINCIDE_BONUS(", 보너스 볼 일치"),
        LOTTERY_RETURN("총 수익률은 %.1f%%입니다."),
        ERROR("[ERROR] 검사 대상 : %s || %s 게임을 종료합니다."),
        ERROR_ILLEGAL("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
        ERROR_NEGATIVE("입력값은 양수여야 합니다."),
        ERROR_NON_NUMERIC("입력값은 숫자여야 합니다."),
        ERROR_LACK_OF_AMOUNT("금액이 부족합니다. 로또 구입을 위해 최소 1000원이 필요합니다."),
        ERROR_VALIDATE("입력한 당첨 번호가 6개가 아닙니다."),
        ERROR_DUPLICATED("입력한 번호 중 중복값이 존재합니다."),
        EXCEPTION_AMOUNT_REMAIN("입력된 구입금액 %d원 에서 로또 구매 후 잔액이 존재합니다.\n" +
                "%d원을 반환합니다. 반환된 값은 수익률 계산에서 제외됩니다.")
        ;
        private final String message;
        Texts(String message) {
            this.message = message;
        }
        public String message() {
            return message;
        }
    }

    public enum Constants {
        NUMBERS_SIZE(6),
        MIN_COINCIDE(3),
        MAX_COINCIDE(6),
        ;
        private final int value;
        Constants(int value) {
            this.value = value;
        }
        public int value() {
            return value;
        }
    }

    public static final int[] WINNINGS = {0, 0, 0, 5000, 50000, 1500000, 2000000000, 30000000};
    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###,###");
}
