package resources;

public enum Error {
    NUMBER("[ERROR] 숫자만 입력하셔야 합니다."),
    THOUSAND("[ERROR] 천 단위만 입력하셔야 합니다."),
    SIZE("[ERROR] 당첨 번호의 개수는 6개여야 합니다."),
    RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ONE_SIZE("[ERROR] 보너스 번호 입력은 한 개만 해야합니다."),
    ONLY_ONE("[ERROR] 입력 받은 당첨 번호에 이미 보너스 번호가 있습니다.");
    private String msg;

    Error(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
