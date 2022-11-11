package model;

public enum ErrorMessage {
    INCORRECT_SIZE{
        @Override
        public String toString() {
            return "[ERROR] 로또 번호 개수는 " + LottoStatus.SIZE.getValue() + "개여야 합니다.";
        }
    },
    OUT_OF_RANGE{
        @Override
        public String toString() {
            return "[ERROR] 로또 번호는 " + LottoStatus.START.getValue() +
                    "부터 " + LottoStatus.END.getValue() + " 사이의 숫자여야 합니다.";
        }
    }

}
