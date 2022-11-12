package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static int convertBuyingPriceIntoLotteries(int buyingPrice) {
        if (buyingPrice % 1000 != 0) {
            throw new IllegalArgumentException(ErrorResponse.INPUT_BUYING_RANGE_ERROR.getErrorMessage());
        }

        return buyingPrice / 1000;
    }
}
