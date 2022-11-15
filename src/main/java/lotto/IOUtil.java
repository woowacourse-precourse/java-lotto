package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IOUtil {
    public static int moneyInput() {
        System.out.println("구입 금액을 입력해주세요.");
        String input = Console.readLine();
        try {
            int money = Integer.parseInt(input);
            if (money < 0 || money % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 사용자의 금액은 0 이상이고 1000으로 나누어 떨여져야 합니다.");
            }
            return money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 사용자의 금액은 숫자를 입력하여야 합니다.");
        }
    }

    public static Lotto answerNumberInput() {
        System.out.println("당첨 번호를 입력해주세요.");
        String input = Console.readLine();
        String[] numbers = input.split(",");
        List<Integer> lottoNumbers = new ArrayList<>();
        try {
            if (numbers.length == 0) {
                throw new IllegalArgumentException("[ERROR] 숫자를 쉼표로 구분되어야 합니다.");
            }
            for (String number : numbers) {
                lottoNumbers.add(Integer.parseInt(number));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자를 입력하여야 합니다.");
        }
        return new Lotto(lottoNumbers);
    }

    public static int bonusNumberInput() {
        System.out.println("보너스 번호를 입력해주세요.");
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자를 입력하여야 합니다.");
        }
    }

    public static String printLottos(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        sb.append(lottos.size()).append("개를 구매했습니다.\n");
        for (Lotto lotto : lottos) {
            sb.append(lotto).append("\n");
        }
        System.out.println(sb);
        return sb.toString();
    }

    public static String printWinningBoard(Map<WinningResult, Integer> board) {
        System.out.println("당첨 통계\n---");
        StringBuilder sb = new StringBuilder();
        for (WinningResult result : WinningResult.values()) {
            sb.append(result).append(" - ").append(board.get(result)).append("개\n");
        }
        System.out.println(sb);
        return sb.toString();
    }

    public static String printYield(double yield) {
        StringBuilder sb = new StringBuilder();
        sb.append("총 수익률은 ").append(yield).append("%입니다.");
        System.out.println(sb);
        return sb.toString();
    }
}
