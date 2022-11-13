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
    };

    public static final String INVALID_FORMAT_ERROR_MSG ="입력형식이 맞지 않습니다.";
    public static final String INVALID_COST_ERROR_MSG ="입력이 1000의 배수가 아닙니다.";

    public abstract String getErrorMsg();
}
