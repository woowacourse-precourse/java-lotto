package lotto;

public class Calculate {

    private static final int LOTTO_PRICE = 1000;


    public static int countLotto(int price){

        validate(price);
        return price/LOTTO_PRICE;

    }

    private static void validate(int price){
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 금액이여야 합니다.");
        }
    }
}
