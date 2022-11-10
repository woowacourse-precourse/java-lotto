package lotto;

public class Player {

    public static final int LOTTO_PRICE = 1000;

    public int canBuyLottoCount(int price) {
        return price / LOTTO_PRICE;
    }
}
