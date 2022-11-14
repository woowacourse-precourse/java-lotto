package lotto;

public enum Exception {

    LOTTO_PRICE_01(1, "로또 금액은 1000으로 나누어지는 양의 정수만이 가능합니다"),
    WINNING_NUMBER_02(2, "당첨 번호 입력값은 숫자 또는 ','로만 이루어져야 합니다"),
    WINNING_NUMBER_03(3, "당첨 번호는 1~45 사이의 숫자여야 합니다"),
    WINNING_NUMBER_04(4, "당첨 번호는 총 6개여야 합니다"),
    WINNING_NUMBER_05(5, "당첨 번호는 입력값은 null이 될 수 없습니다");

    private Integer number;
    private String message;

    Exception(Integer number, String message) {
        this.number = number;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Integer getNumber() {
        return number;
    }

    public static void of(Exception e){
        throw new IllegalArgumentException("[ERROR]" + "-(" + e.getNumber() +") " + e.getMessage());
    }
}
