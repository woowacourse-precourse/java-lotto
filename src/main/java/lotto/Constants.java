package lotto;

public final class Constants {
    public final class REGEX {
        public static final String WINNING_NUMBERS = "^([1-9]{1},{1}|[1-3]{1}[0-9]{1},{1}|4{1}[0-5]{1},{1}){5}"
                + "([1-9]{1}|[1-3]{1}[0-9]{1}|4{1}[0-5]{1})$";

        public static final String BONUS_NUMBER = "^[1-9]{1}|[1-3]{1}[0-9]{1}|4{1}[0-5]{1}$";
        public static final String PAYMENT = "^[1-9]*000$";

        private REGEX() {}
    }
}
