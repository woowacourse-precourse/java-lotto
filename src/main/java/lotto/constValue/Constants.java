package lotto.constValue;

import javax.swing.plaf.PanelUI;

public final class Constants {

    public class ExceptionMessage {
        public static final String MONEY_INPUT_NON_NUMBER_ERROR_MESSAGE = "[ERROR] : 구입 금액은 숫자여야 합니다.";
        public static final String MONEY_INPUT_NON_THOUSAND_ERROR_MESSAGE = "[ERROR] : 구입 금액은 1000원 단위이어야 합니다.";
        public static final String LOTTO_NUMBER_OVER_RANGE_ERROR_MESSAGE = "[ERROR] : 로또 번호의 범위를 벗어났습니다.";
        public static final String LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE = "[ERROR] : 로또 번호에 중복 숫자가 없어야 합니다.";
        public static final String LOTTO_WINNING_NUMBER_OVER_RANGE_ERROR_MESSAGE = "[ERROR] : 당첨 번호의 범위를 벗어났습니다.";
        public static final String LOTTO_WINNING_NUMBER_BAD_FORMAT_ERROR_MESSAGE = "[ERROR] : 당첨 번호 형식에 맞지 않습니다.";
        public static final String BONUS_NUMBER_OVER_RANGE_ERROR_MESSAGE = "[ERROR] : 보너스 번호의 범위에 벗어났습니다.";
        public static final String BONUS_NUMBER_BAD_FORMAT_ERROR_MESSAGE = "[ERROR] : 보너스 번호는 숫자만 가능합니다.";
    }

    public class LottoInfo {
        public static final int MIN_RANGE = 1;
        public static final int MAX_RANGE = 45;
        public static final int COUNT_RANGE = 6;
        public static final int THOUSAND_UNIT_LENGTH=3;
        public static final String THOUSAND_UNIT = "000";

    }

    public class ProfitInfo{
        public static final int DECIMAL_POINT_FIRST=1;
        public static final int INIT_MONEY=0;
        public static final int THOUSAND_MONEY=1000;
        public static final int PERCENT=100;

    }

    public class WinnerInfo{
        public static final String SEPARATOR_COMMA = ",";
    }

    public class Format {
        public static final String BONUS_NUMBER_FORMAT = "^[1-9]{0,1}[0-9]{1}$";
        public static final String WINNING_NUMBER_FORMAT = "^[1-9]{0,1}[0-9]{1},[1-9]{0,1}[0-9]{1},"
                + "[1-9]{0,1}[0-9]{1},[1-9]{0,1}[0-9]{1},"
                + "[1-9]{0,1}[0-9]{1},[1-9]{0,1}[0-9]{1}$";
        public static final String MONEY_FORMAT = "^[0-9]*$";
    }
}
