package lotto.view;

import lotto.domain.Computer;
import lotto.domain.Rank;
import lotto.domain.Resource;

public final class Message {
    public static final String ERROR_MESSAGE = "[ERROR] ";
    public static final String JOIN_SEPARATOR = ", ";
    public static final String LOTTO_PRINT_START = "[";
    public static final String LOTTO_PRINT_END = "]";
    public static final String PURCHASE_AMOUNT = "구매금액은 ";
    public static final String WINNING_NUMBER = "당첨 번호는 ";
    public static final String BONUS_NUMBER = "보너스 번호는 ";
    public static final String PURCHASE_ENTER = "\n구매금액을 입력해주세요.";
    public static final String WINNING_ENTER = "\n당첨 번호를 입력해주세요.";
    public static final String BONUS_ENTER = "\n보너스 번호를 입력해주세요.";
    public static final String BUY = "개를 구매했습니다.";
    public static final String ISNULL = "빈 값을 입력할 수 없습니다.";
    public static final String ISZERO = "0이상의 값을 입력하세요.";
    public static final String ISSPACE = "띄어쓰기 없이 입력하세요.";
    public static final String NOTNUMBER = "숫자만 입력 가능합니다.";
    public static final String HASCHARGE = Resource.LOTTO_PRICE + "원 단위어야 합니다.";
    public static final String NOCOMMA = "쉼표를 포함해야 합니다";
    public static final String NOTRANGE = "는 " + Resource.MIN_LOTTO_NUMBER + " ~ " + Resource.MAX_LOTTO_NUMBER + " 사이의 수여야 합니다";
    public static final String ISDUPLICATE = "당첨번호와 중복값을 쓸 수 없습니다.";
    public static final String LOTTO_NOTSIZE = "당첨번호는 " + Resource.LOTTO_SIZE + "개의 숫자를 입력하셔야 합니다.";
    public static final String LOTTO_DUPLICATE = "당첨번호는 중복번호를 입력할 수 없습니다.";
    public static final String LOTTO_NOTRANGE = "당첨번호는 " + Resource.MIN_LOTTO_NUMBER + "부터 " + Resource.MAX_LOTTO_NUMBER + "까지의 수여야 합니다.";

    public static final String RESULT = "\n당첨 통계\n---\n3개 일치 (5,000원) - " + Rank.FIFTH.getCount() + "개\n4개 일치 (50,000원) - " + Rank.FOURTH.getCount() + "개\n5개 일치 (1,500,000원) - " + Rank.THIRD.getCount() + "개\n"
            + "5개 일치, 보너스 볼 일치 (30,000,000원) - " + Rank.SECOND.getCount() + "개\n6개 일치 (2,000,000,000원) - " + Rank.FIRST.getCount() + "개\n"
            + "총 수익률은 " + Computer.getYIELD() + "%입니다.";

}
