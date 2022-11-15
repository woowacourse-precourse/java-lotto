package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class IOUtil {
    public static int moneyInput() {
        System.out.println("구입 금액을 입력해주세요.");
        String input = Console.readLine();
        try {
            int money = Integer.parseInt(input);
            if ( money < 0 || money % 1000 != 0 ) {
                throw new IllegalArgumentException("[ERROR] 사용자의 금액은 0 이상이고 1000으로 나누어 떨여져야 합니다.");
            }
            return money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 사용자의 금액은 숫자를 입력하여야 합니다.");
        }
    }

    public static String printLottos(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        sb.append(lottos.size()).append("개 구매했습니다.\n");
        for(Lotto lotto : lottos) {
            sb.append(lotto).append("\n");
        }
        System.out.println(sb);
        return sb.toString();
    }
}
