package lotto;

public enum Exception {

    LOTTO_PRICE_01(1, "로또 금액은 1000으로 나누어지는 양의 정수만이 가능합니다");

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
