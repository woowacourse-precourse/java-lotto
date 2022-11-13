package lotto.config;

public enum BaseException {

    ERRORRANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERRORNOTNUM("[ERROR] 숫자로 입력해야 합니다."),
    ERRORDIVIDE("[ERROR] 1000으로 나누어 떨어지지 않습니다."),
    ERRORLOTTIO("[ERROR] 로또 발행 실패했습니다.");

    private final String error;

    public String getError(){
        return error;
    }

    private BaseException(String error){
        this.error = error;
    }
}
