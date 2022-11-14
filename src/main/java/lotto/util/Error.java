package lotto.util;

public enum Error {
    ERROR_PARSE_INT("[ERROR] 구입금액을 정수형 데이터로 변환할 수 없습니다."),
    ERROR_OUT_OF_RANGE_PAYMENT("[ERROR] 구입금액은 0보다 크고 1000으로 나누어 떨어져야합니다."),
    ERROR_INVALID_WINNER_NUMBERS("[ERROR] 유효하지 않은 승자 번호 입력입니다."),
    ERROR_DUPLICATED_NUMBERS("[ERROR] 중복된 로또 번호가 존재합니다."),
    ERROR_OUT_OF_RANGE_NUMBER("[ERROR] 로또 번호는 1~45사이의 숫자여만 합니다."),
    ERROR_OUT_OF_MAX_IDX("[ERROR] 로또 번호 길이는 6입니다.");


    private final String label;
    Error(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
    public void generate(){
        throw new IllegalArgumentException(label);
    }
}
