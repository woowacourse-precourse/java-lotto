package lotto.Domain.Exception;

public enum PrintException {
        NOT_A_NUMBER("[ERROR] 숫자가 아닌 문자를 입력였습니다."),
        OUT_OF_RANGE("[ERROR] 1~45 사이의 숫자를 입력하지 않았습니다."),
        CANNOT_DIVIDE_THOUSAND("[ERROR] 1000원 단위의 금액을 입력하지 않았습니다."),
        OUT_OF_SIZE("[ERROR] 6개의 숫자를 입력하지 않았습니다."),
        BONUS_OVERLAP_LOTTONUM("[ERROR] 로또 번호와 중복되는 숫자가 있습니다."),
        HAVE_OVERLAP_IN_LIST("[ERROR] 중복되는 숫자를 입력하셨습니다.");
        private final String message;

        PrintException (String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }


