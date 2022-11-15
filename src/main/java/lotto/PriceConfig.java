package lotto;

public class PriceConfig {

    private static int price = 1000;

    /**
     * 거스름돈은 반환하지 않고 버리는 가격정책
     */
    public static int getLottoCountWithoutChange(int cost) {
        return cost / price;
    }

    public static int getPrice() {
        return price;
    }

    public static void setPrice(int price) {
        PriceConfig.price = price;
    }
}
