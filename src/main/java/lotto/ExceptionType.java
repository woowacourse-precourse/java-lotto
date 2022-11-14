package lotto;

public enum ExceptionType {
    rangeError("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    numError("[ERROR] 로또 번호는 숫자여야 합니다"),
    DuplicateError("[ERROR] 로또 숫자는 중복이 되면 안됩니다.");

    final private String name;
    public String getName(){
        return name;
    }
    ExceptionType(String name) {
        this.name = name;
    }
}
