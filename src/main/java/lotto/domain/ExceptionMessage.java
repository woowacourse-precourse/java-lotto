package lotto.domain;

public enum ExceptionMessage {
    notFitSize("[ERROR] 로또번호가 6개가 아닙니다."),
    duplicateNumber("[ERROR] 중복된 로또번호가 있습니다."),
    outOfRangeNumber("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    notNumber("[ERROR] 로또 번호는 숫자를 입력하셔야 합니다."),
    moneyBy1000("[ERROR] 돈은 1,000원 단위로 입력하셔야 합니다."),
    underMoney("[ERROR] 돈의 최소값은 0원 입니다.");

    final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }
}
