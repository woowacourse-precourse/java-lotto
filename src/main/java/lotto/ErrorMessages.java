package lotto;

enum ErrorMessages {
    LOTTO_NUM_NUMBER_ERROR("[ERROR] 로또 번호 개수가 6개여야 합니다."),
    LOTTO_NUM_RANGE_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    final private String message;

    ErrorMessages(String message) {
        this.message = message;
    }
}