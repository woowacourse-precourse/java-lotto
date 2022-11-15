package lotto;

public final class Constants {
    public final class NUMBER {
        public static final int ZERO = 0;
        public static final int ONE = 1;
        public static final int HUNDRED = 100;

        private NUMBER() {
        }


    }

    public final class LOTTO {
        public static final int PRICE = 1000;
        public static final int START = 1;
        public static final int END = 45;
        public static final int SIZE = 6;

        private LOTTO() {
        }
    }

    public final class REGEX {
        public static final String WINNING_NUMBERS = "^([1-9]{1},{1}|[1-3]{1}[0-9]{1},{1}|4{1}[0-5]{1},{1}){5}"
                + "([1-9]{1}|[1-3]{1}[0-9]{1}|4{1}[0-5]{1})$";
        public static final String BONUS_NUMBER = "^[1-9]{1}|[1-3]{1}[0-9]{1}|4{1}[0-5]{1}$";
        public static final String PAYMENT = "^[1-9]{1}[0-9]*000$";

        private REGEX() {
        }
    }

    public final class ERROR {
        public static final String LOTTO_SIZE = "[ERROR] 로또는 6개의 숫자를 필요로 합니다.";
        public static final String PURCHASE_FORMAT = "[ERROR] 로또 구입금액을 정확히 입력해주세요.";
        public static final String WINNING_NUMBER_FORMAT = "[ERROR] 당첨 번호는 1-45사이의 숫자를 콤마로 구분하여 입력해주세요.";
        public static final String WINNING_NUMBER_DUPLICATION = "[ERROR] 당첨 번호는 중복 숫자가 존재하지 않아야 합니다.";
        public static final String BONUS_NUMBER_RANGE = "[ERROR] 보너스 번호는 1-45사이의 숫자여야 합니다.";
        public static final String BONUS_NUMBER_IN_WINNING_NUMBER = "[ERROR] 보너스 번호는 당첨 번호에 존재할 수 없습니다.";

        private ERROR() {
        }
    }

    public final class PRINT {
        public static final String INPUT_PAYMENT = "구입금액을 입력해 주세요.";
        public static final String PAID_LOTTO = "개를 구매했습니다.";
        public static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해주세요.";
        public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
        public static final String WINNING_RESULTS = "당첨 통계\n---";
        public static final String SECOND_RANK_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
        public static final String OTHER_RANK_FORMAT = "%d개 일치 (%s원) - %d개\n";
        public static final String PROFIT_FORMAT = "총 수익률은 %.1f%%입니다.";

        private PRINT() {
        }
    }
}
