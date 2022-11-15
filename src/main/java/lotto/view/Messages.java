package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class Messages {
    // Inputs
    public static final String ASK_MONEY = "구입금액을 입력해 주세요.";
    public static final String ASK_WIN_NUMBER = "당첨 번호를 입력해 주세요.";

    // Results
    private static final String RESULT_BUY_LOTTO = "개를 구매했습니다.";

    // ERROR
    public static final String  ERROR_NOT_DIVDE1000 = "[ERROR] 금액은 1,000원 단위로 입력할 수 있습니다.";
    public static final String  ERROR_NULL = "[ERROR] 0이 아닌 값을 입력하세요.";
    public static final String  ERROR_NOT_SIZE6 = "[ERROR] 쉼표(,)로 구분하여 4개의 숫자를 입력하세요.";
    public static final String  ERROR_NOT_VAILDRANGE = "[ERROR] 각 숫자가 1~45 사이에 있어야 합니다.";
    public static final String  ERROR_NOT_DIFFRENT= "[ERROR] 각 숫자는 모두 달라야 합니다.";

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
