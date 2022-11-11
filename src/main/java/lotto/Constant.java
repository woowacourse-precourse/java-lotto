package lotto;

public class Constant {
    public static final int PRICE_UNIT = 1000;

    public static final String INPUT_MESSAGE = "구매금액을 입력해주세요.";
    public static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    public static final String INPUT_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String WINNING_STATISTICS = "당첨통계" + "\n" + "---";

    public static final String THREE_MATCHING = "3개 일치 (5,000원)";
    public static final String FOUR_MATCHING = "4개 일치 (50,000원)";
    public static final String FIVE_MATCHING = "5개 일치 (1,500,000원)";
    public static final String FIVE_MATCHING_WITH_BONUS_NUM = "5개 일치, 보너스 볼 일치 (30,000,000원)";
    public static final String SIX_MATCHING = "6개 일치 (2,000,000,000원)";

    public static final String TOTAL_YIELD = "총 수익률은 ";

    public static final String ERROR_MESSAGE = "[ERROR] ";
}
/**
* 3개 일치 (5,000원) - 1개
        * 4개 일치 (50,000원) - 0개
        * 5개 일치 (1,500,000원) - 0개
        * 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
        * 6개 일치 (2,000,000,000원) - 0개
        * 총 수익률은 62.5%입니다.
        */
