package domain;

import view.Input;

public class LottoCount {
    private Input input;
    private int count;
    private final static int unitPrice = 1000;
    public LottoCount() {
        count = 0;
    }
    public int getNumber() {
        return this.count;
    }
    public boolean isNotMultiple(int price) {
        return (price % unitPrice != 0);
    }
    public void returnNumber(int price) {
        if(!isNotMultiple(price)) {
            count = price / unitPrice;
        }
        if(isNotMultiple(price)) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액을 1000으로 나누어 떨어져야 합니다.");
        }
    }
}
