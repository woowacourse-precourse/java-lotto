package lotto;

public class Price {
    private final String price;

    public Price(String price) {
        numberValidate(price);
        divideValidate(price);
        this.price = price;
    }

    private void numberValidate(String price) {
        // 1-1. 숫자가 아니면 예외처리를 한다.
        for (int idx = 0; idx < price.length(); idx++) {
            if(!('0' <= price.charAt(idx) && price.charAt(idx) <= '9'))
                throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private void divideValidate(String price) {
        // 1-2. 1000원 단위로 나누어 떨어지지 않으면 예외처리를 한다.
        if(Integer.parseInt(price) % 1000 != 0)
            throw new IllegalArgumentException("1000원으로 나누어 떨어지지 않습니다.");
    }

    public String getPrice() {
        return this.price;
    }

    public Integer getLottoNum() {
        return Integer.parseInt(this.price) / 1000;
    }
}
