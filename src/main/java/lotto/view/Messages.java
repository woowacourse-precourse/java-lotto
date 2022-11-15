package lotto.view;

import lotto.controller.Result;
import lotto.domain.Lotto;
import lotto.domain.Win;

import java.util.List;
import java.util.Map;

import static lotto.domain.Win.*;

public class Messages {
    // Inputs
    public static final String ASK_MONEY = "구입금액을 입력해 주세요.";
    public static final String ASK_WIN_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    // Results
    private static final String RESULT_BUY_LOTTO = "개를 구매했습니다.";
    private static final String RESULT_LOTTO_WIN = "당첨 통계\n" +
            "---\n" +
            "3개 일치 (5,000원) - %d개\n" +
            "4개 일치 (50,000원) - %d개\n" +
            "5개 일치 (1,500,000원) - %d개\n" +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
            "6개 일치 (2,000,000,000원) - %d개\n" +
            "총 수익률은 %.2f%%입니다.";

    // ERROR
    public static final String  ERROR_NOT_DIVDE1000 = "[ERROR] 금액은 1,000원 단위로 입력할 수 있습니다.";
    public static final String  ERROR_NULL = "[ERROR] 0이 아닌 값을 입력하세요.";
    public static final String  ERROR_NOT_SIZE6 = "[ERROR] 쉼표(,)로 구분하여 6개의 숫자를 입력하세요.";
    public static final String  ERROR_NOT_VAILDRANGE = "[ERROR] 각 숫자가 1~45 사이에 있어야 합니다.";
    public static final String  ERROR_NOT_DIFFRENT= "[ERROR] 각 숫자는 모두 달라야 합니다.";
    public static final String  ERROR_NOT_NUMBER= "[ERROR] 숫자로 입력해 주세요.";
    public static final String  ERROR_NOT_DIFFRENT_BONUS_NUMBER= "[ERROR] 보너스 숫자가 아미 당첨 번호에 포함되어 있습니다.";

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

    /** 로또 결과 출력 메시지 반환 메서드 */
    public static final String PRINT_RESULT (Map<Win, Integer> wins, double winningsRate) {
        String result = String.format(RESULT_LOTTO_WIN, wins.get(FIFTH), wins.get(FOURTH), wins.get(THIRD), wins.get(SECOND), wins.get(FIRST), winningsRate);
        return result;
    }
}
