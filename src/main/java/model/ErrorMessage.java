package model;

public enum ErrorMessage {
    INCORRECT_SIZE{
        @Override
        public String toString() {
            return "[ERROR] 로또 번호 개수는 " + LottoStatus.SIZE.getValue() + "개여야 합니다.";
        }
    }
}
