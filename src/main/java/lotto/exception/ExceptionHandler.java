package lotto.exception;

public enum ExceptionHandler {
    AMOUNT_UNIT {
        @Override
        public void error() {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해야 합니다.");
        }
    },

    OVERLAP_NUMBER {
        @Override
        public void error() {
            throw new IllegalArgumentException("[ERROR] 중복된 수는 로또 번호로 사용할 수 없습니다.");
        }
    },

    OVERLAP_BONUS_NUMBER {
        @Override
        public void error() {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    },

    ILLEGAL_RANGE {
        @Override
        public void error() {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    },

    INPUT_SIX_DIGITS {
        @Override
        public void error() {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    },

    ILLEGAL_VALUE {
        @Override
        public void error() {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    };

    public abstract void error();

}