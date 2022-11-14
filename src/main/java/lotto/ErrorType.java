package lotto;

public enum ErrorType {

    INVALID_FORMAT {
        @Override
        public String getErrorMsg() {
            return INVALID_FORMAT_ERROR_MSG;
        }
    },

    INVALID_PURCHASE_COST {
        @Override
        public String getErrorMsg () {
            return INVALID_COST_ERROR_MSG;
        }
    },

    INVALID_LENGTH {
        @Override
        public String getErrorMsg () {
            return INVALID_LENGTH_ERROR_MSG;
        }
    },

    DUPLICATED_NUMBER {
        @Override
        public String getErrorMsg () {
            return DUPLICATED_NUMBER_ERROR_MSG;
        }
    },

    INVALID_RANGE {
        @Override
        public String getErrorMsg () {
            return INVALID_RANGE_ERROR_MSG;
        }
    };

    private static final String INVALID_FORMAT_ERROR_MSG ="[ERROR] 입력이 숫자가 아닙니다.\n";
    private static final String INVALID_COST_ERROR_MSG ="[ERROR] 입력이 1000의 배수가 아닙니다.\n";
    private static final String INVALID_LENGTH_ERROR_MSG = "[ERROR] 입력의 길이가 맞지 않습니다.\n";
    private static final String DUPLICATED_NUMBER_ERROR_MSG = "[ERROR] 당첨번호에 중복된 수가 있으면 안됩니다.\n";
    private static final String INVALID_RANGE_ERROR_MSG = "[ERROR] 입력의 범위가 1 ~ 45가 아닙니다.\n";

    public abstract String getErrorMsg();
}
