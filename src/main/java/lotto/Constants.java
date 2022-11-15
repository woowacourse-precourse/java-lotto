package lotto;

public class Constants {
    public static final int START_NUMBER_INCLUSIVE = 1;
    public static final int END_NUMBER_INCLUSIVE = 45;
    public static final int LOTTO_SIZE = 6;
    public static final Integer UNIT_PRICE = 1000;

    public static final String ERROR_TITLE = "[ERROR] ";
    public static final String NON_NUMERIC = "숫자 이외의 값이 입력되었습니다. 문자나 띄어쓰기 등이 들어갔는지 확인해주세요.";
    public static final String NOT_IN_THOUSANDS = "금액은 천 원 단위로만 입력할 수 있습니다.";
    public static final String NOT_SIX_NUMBERS = "로또 번호의 개수가 6개가 아닙니다.";
    public static final String DUPLICATE_NUMBERS = "로또 번호 또는 보너스 번호 중에 겹치는 번호가 존재합니다.";
    public static final String OUT_OF_RANGE = "로또 번호는 1부터 45 사이의 숫자들로 이루어져야 합니다.";
    public static final String NON_PROPER_COMMA = "로또 번호는 5개의 쉼표(,)로 구분되어야 합니다.";
}
