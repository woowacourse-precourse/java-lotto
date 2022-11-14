package lotto.util;

public class Lang {
    public final static String THROW_NON_NUMERIC_CHARACTER = "입력한 내용 중 숫자가 아닌 문자가 있어요.";
    public final static String THROW_ELEMENT_INSUFFICIENT = "%d개 이하의 숫자를 입력했어요. %d개 숫자를 입력해 주세요.";
    public final static String THROW_ELEMENT_DUPLICATE = "중복된 숫자를 입력했어요. 중복 없는 %d개 숫자를 입력해 주세요.";
    public final static String THROW_OUT_RANGE = "%d ~ %d 숫자를 입력해 주세요.";
    public static final String THROW_VARIABLE_NOT_DECLARE = "변수를 선언하지 않았어요.";
    public static final String THROW_NUMBER_NEGATIVE = "음수가 아닌 숫자를 입력해 주세요.";
    public static final String THROW_MONEY_LEFT_AFTER_BUY_LOTTO = "%d 단위로 입력해 주세요.";

    public static final String VIEW_ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String VIEW_ENTER_RANGE_ONCE = "%d ~ %d 숫자 1개를 입력해 주세요.";
    public static final String VIEW_EXAMPLE_NUMBER = "ex) 42";
    public static final String VIEW_LOTTO_PRICE = "로또 1장의 가격은 %d원 입니다.";
    public static final String VIEW_ENTER_WIN_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String VIEW_ENTER_NON_DUPLICATE_NUMBERS
            = "1부터 45까지의 중복되지 않는 6개의 숫자를 입력해 주세요.";
    public static final String VIEW_EXAMPLE_NUMBERS = "ex) 1,2,3,4,5,6";
    public static final String VIEW_SUCCESS_BUY = "%d개를 구매했습니다.";
    public static final String VIEW_ENTER_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요.";
    public static final String VIEW_ENTER_NUMBER_AND_KEEP_UNIT
            = "구입 금액은 숫자만 입력할 수 있으며 %d원 단위로 구매할 수 있어요.";
    public static final String VIEW_EXAMPLE_MONEY = "ex) 8000";
    public static final String VIEW_WINNING_STATS = "당첨 통계";
    public static final String VIEW_STATS_UNIT = "%s - %d개";
    public static final String VIEW_TOTAL_RETURNS = "총 수익률은 %.1f%%입니다.";
    public static final String VIEW_ERROR = "[ERROR]";


    public static String format(String message, Object ...args) {
        return String.format(message, args);
    }
}
