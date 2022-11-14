package lotto.exception;

public class LottoPriceException {
    //TODO 하드코딩한 값 상수로 빼기


    public static void checkLottoPrice(String priceInput) {
        CommonInputException.checkCommonInput(priceInput);
        Integer price = changePriceToInteger(priceInput);
        checkLessThanOneThousand(price);
        checkThousandUnits(price);
    }

    public static Integer changePriceToInteger(String price) {
        if (!price.matches("[0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 로또 금액을 숫자로 입력해주세요.");
        }
        return Integer.parseInt(price);
    }

    public static void checkLessThanOneThousand(Integer price) {
        if (price < 1000) {
            throw new IllegalArgumentException("[ERROR] 로또 1장은 1000원입니다. 1000원 보다 더 높은 금액을 입력해주세요.");
        }
    }

    public static void checkThousandUnits(Integer price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 1장은 1000원입니다. 1000단위의 금액을 입력해주세요.");
        }
    }
}
