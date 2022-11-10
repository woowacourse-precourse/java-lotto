package lotto;

public class LottoBuyer {

    private final int cost;

    public LottoBuyer(int cost) {
        costValidate(cost);
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void costValidate(int cost) {
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력 가능합니다.");
        }
    }

}
