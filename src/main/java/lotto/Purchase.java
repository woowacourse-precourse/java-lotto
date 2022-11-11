package lotto;

public class Purchase {

    private final static String ERROR_TITLE = "[ERROR] ";
    private final static String NON_NUMERIC = "숫자 이외의 값이 입력되었습니다. 문자나 띄어쓰기 등이 들어갔는지 확인해주세요.";
    private final static String NOT_IN_THOUSANDS = "금액은 천 원 단위로만 입력할 수 있습니다.";
    private final static String ONLY_NUMBER = "^\\d+$";

    private final static int PRICE_UNIT = 1000;
    private final static int EXPECTED_REMAINDER = 0;

    private final Integer price;

    public Purchase(String input) throws IllegalArgumentException {
        validateIfNumeric(input);
        Integer price = Integer.valueOf(input);
        validateIfInThousands(price);

        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    private void validateIfNumeric(String input) throws IllegalArgumentException {
        boolean isNumber = input.matches(ONLY_NUMBER);
        if (!isNumber) {
            throw new IllegalArgumentException(ERROR_TITLE + NON_NUMERIC);
        }
    }

    private void validateIfInThousands(Integer price) {
        if (price % PRICE_UNIT != EXPECTED_REMAINDER) {
            throw new IllegalArgumentException(ERROR_TITLE + NOT_IN_THOUSANDS);
        }
    }
}
