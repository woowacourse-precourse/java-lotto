package lotto;

public enum ExceptionCode {

    Not_Size("[ERROR] 로또번호가 6개가 아닙니다."),
    Exists_Number("[ERROR] 중복된 로또번호가 있습니다."),
    Over_Range_Number("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    Not_Number("[ERROR] 로또 번호는 숫자를 입력하셔야 합니다."),
    Not_Money("[ERROR] 돈은 1,000원 단위로 입력하셔야 합니다."),
    Over_Money("[ERROR] 돈의 최소값은 0원 입니다.");

    final String message;

    ExceptionCode(String message) {
        this.message = message;
    }
}
