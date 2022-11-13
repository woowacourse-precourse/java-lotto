package lotto;

public final class Constants {
    public final class REGEX {
        public static final String WINNING_NUMBERS = "^([1-9]{1},{1}|[1-3]{1}[0-9]{1},{1}|4{1}[0-5]{1},{1}){5}"
                + "([1-9]{1}|[1-3]{1}[0-9]{1}|4{1}[0-5]{1})$";

        public static final String BONUS_NUMBER = "^[1-9]{1}|[1-3]{1}[0-9]{1}|4{1}[0-5]{1}$";
        public static final String PAYMENT = "^[1-9]*000$";

        private REGEX() {}
    }

    public final class ERROR {
        public static final String PURCHASE_FORMAT = "[ERROR] 로또 구입금액을 정확히 입력해주세요.";
        public static final String  WINNING_NUMBER_FORMAT = "[ERROR] 당첨 번호는 1-45사이의 숫자를 콤마로 구분하여 입력해주세요.";
        public static final String  WINNING_NUMBER_DUPLICATE = "[ERROR] 당첨 번호는 중복 숫자가 존재하지 않아야 합니다.";
        public static final String  BONUS_NUMBER_RANGE = "[ERROR] 보너스 번호는 1-45사이의 숫자여야 합니다.";
        public static final String  BONUS_NUMBER_IN_WINNING_NUMBER = "[ERROR] 보너스 번호는 당첨 번호에 존재할 수 없습니다.";
    }
}
