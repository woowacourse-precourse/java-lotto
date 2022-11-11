package lotto;

public enum ErrorMessage {
    MORE_THAN_SIX_LOTTO("[ERROR] 로또 번호의 개수는 6개가 넘으면 안됩니다."),
    DUPLICATED_LOTTO("[ERROR] 로또 번호는 중복될 수 없습니다.");

    private String status;

    ErrorMessage(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
