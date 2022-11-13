package lotto;

public enum ExceptionType {

    INVALID_FORMAT {
        public String getErrorMsg (){
            return INVALID_FORMAT_ERROR_MSG;
        }
    },

    INVALID_PURCHASE_COST {
        public String getErrorMsg (){
            return INVALID_COST_ERROR_MSG;
        }
    },

    INVALID_LENGTH {
        public String getErrorMsg (){
            return INVALID_LENGTH_ERROR_MSG;
        }
    },

    DUPLICATED_NUMBER {
        public String getErrorMsg (){
            return DUPLICATED_NUMBER_ERROR_MSG;
        }
    },

    INVALID_RANGE {
        public String getErrorMsg (){
            return INVALID_RANGE_ERROR_MSG;
        }
    };

    public static final String INVALID_FORMAT_ERROR_MSG ="당첨번호는 총 6개여야 합니다.";
    public static final String INVALID_COST_ERROR_MSG ="입력이 1000의 배수가 아닙니다.";
    private static final String INVALID_LENGTH_ERROR_MSG = "입력의 길이가 맞지 않습니다.";
    private static final String DUPLICATED_NUMBER_ERROR_MSG = "당첨번호에 중복된 수가 있으면 안됩니다.";
    private static final String INVALID_RANGE_ERROR_MSG = "입력의 범위가 1 ~ 45가 아닙니다.";

    public abstract String getErrorMsg();
}
