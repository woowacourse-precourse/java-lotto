package resources;

public enum Error {
    NUMBER("[ERROR] 숫자만 입력하셔야 합니다."),
    SIZE("[ERROR] 당첨 번호의 개수는 6개여야 합니다."),
    RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private String msg;

    Error(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
