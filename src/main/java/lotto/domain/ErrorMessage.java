package lotto.domain;

public enum ErrorMessage {
    HEADER {
        @Override
        public String toString() {
            return "[ERROR] ";
        }
    },
    LOTTO_INCORRECT_SIZE {
        @Override
        public String toString() {
            return HEADER + "로또 번호 개수는 " + LottoStatus.SIZE.getValue() + "개여야 합니다.";
        }
    },
    LOTTO_OUT_OF_RANGE {
        @Override
        public String toString() {
            return HEADER + "로또 번호는 " + LottoStatus.START.getValue() +
                    "부터 " + LottoStatus.END.getValue() + " 사이의 숫자여야 합니다.";
        }
    },
    LOTTO_DUPLICATION {
        @Override
        public String toString() {
            return HEADER + "로또 번호는 중복되지 않아야 합니다.";
        }
    },
    INCORRECT_PURCHASING_AMOUNT{
        @Override
        public String toString() {
            return HEADER + "1000원 단위의 숫자여야 합니다.";
        }
    },
    INCORRECT_LUCKY_NUMBER_SIZE{
        @Override
        public String toString() {
            return HEADER + "당첨 번호는 ,로 구분하여 6개의 번호(1~45)를 입력하여야 합니다.";
        }
    },
    INCORRECT_LUCKY_NUMBER_DIGIT{
        @Override
        public String toString() {
            return HEADER + "당첨 번호는 숫자를 입력하여야 합니다.";
        }
    },
    INCORRECT_LUCKY_NUMBER_RANGE{
        @Override
        public String toString() {
            return HEADER + "당첨 번호는 1부터 45사이의 숫자여야 합니다.";
        }
    },
    LUCKY_NUMBER_DUPLICATION{
        @Override
        public String toString() {
            return HEADER + "로또 번호는 중복되지 않아야 합니다.";
        }
    },
    INCORRECT_BONUS_NUMBER_SIZE{
        @Override
        public String toString() {
            return HEADER + "보너스 번호는 1~45 사이의 번호여야 합니다.";
        }
    },
    INCORRECT_BONUS_NUMBER_DIGIT{
        @Override
        public String toString() {
            return HEADER + "당첨 번호는 숫자를 입력하여야 합니다.";
        }
    },
    INCORRECT_BONUS_NUMBER_RANGE{
        @Override
        public String toString() {
            return HEADER + "보너스 번호는 1부터 45사이의 숫자여야 합니다.";
        }
    },
    BONUS_NUMBER_DUPLICATION{
        @Override
        public String toString() {
            return HEADER + "보너스 번호는 당첨 번호와 중복되지 않아야 합니다.";
        }
    },
}
