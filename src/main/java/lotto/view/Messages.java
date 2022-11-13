package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class Messages {
    // Inputs
    public static final String ASK_MONEY = "구입금액을 입력해 주세요.";

    // Results
    private static final String RESULT_BUY_LOTTO = "개를 구매했습니다.";

    // ERROR
    public static final String  ERROR_NOT_DIVDE1000 = "[ERROR] 금액은 1,000원 단위로 입력할 수 있습니다.";
    public static final String  ERROR_NULL = "[ERROR] 0이 아닌 값을 입력하세요.";

    /** 로또 구입 개수 메시지 반환 메서드 */
    public static final String PRINT_BUY_LOTTO (int lotto) {
        return "\n"+lotto+RESULT_BUY_LOTTO;
    }

    private static final String PRINT_LOTTO (Lotto lotto) {
        return lotto.getNumbers().toString();
    }

    /** 로또 구입 결과 메시지 반환 메서드 */
    public static final String PRINT_LOTTOS (List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        for(Lotto lotto : lottos) {
            sb.append(Messages.PRINT_LOTTO(lotto)+"\n");
        }
        return String.valueOf(sb);
    }
}
