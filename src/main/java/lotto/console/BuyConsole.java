package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.WinningTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class BuyConsole {
    public static final String INPUT_PRICE = "구입금액을 입력해 주세요.";
    public static final String PURCHASE = "개를 구매했습니다.";
    public static final String INPUT_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS = "보너스 번호를 입력해 주세요.";
    public static final String STATISTICS = "당첨 통계\n---";
    public static final String FIRST = "6개 일치 (2,000,000,000원) - %d개\n";
    public static final String SECOND = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    public static final String THIRD = "5개 일치 (1,500,000원) - %d개\n";
    public static final String FORTH = "4개 일치 (50,000원) - %d개\n";
    public static final String FIFTH = "3개 일치 (5,000원) - %d개\n";
    public static final String PROFIT = "총 수익률은 %.1f%%입니다.";

    public void printInputMessage() {
        System.out.println(INPUT_PRICE);
    }

    public int inputPrice() {
        String input = Console.readLine();
        Pattern p = Pattern.compile("^[0-9]*$");
        if (!p.matcher(input.trim()).matches()) {
            System.out.println("[ERROR] 숫자만 입력 가능합니다. 다시 입력하세요.");
            return inputPrice();
        }
        return Integer.parseInt(input);
    }

    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + PURCHASE);
        for(Lotto l : lottos) {
            System.out.println(l.getNumbers());
        }
        System.out.println();
    }



    public List<Integer> inputNumbers() {
        System.out.println(INPUT_NUMBERS);
        String input = Console.readLine();
        String []arr = input.split(",");
        List<Integer> list = new ArrayList<>();
        for(String s : arr) {
            list.add(Integer.parseInt(s));
        }

        return list;
    }

    public int inputBonus() {
        System.out.println(INPUT_BONUS);
        String input = Console.readLine();

        return Integer.parseInt(input);
    }

    public void printStatistics(Map<WinningTable, Integer> map, double profitRate) {
        System.out.println(STATISTICS);
        System.out.printf(FIFTH, map.get(WinningTable.FIFTH));
        System.out.printf(FORTH, map.get(WinningTable.FORTH));
        System.out.printf(THIRD, map.get(WinningTable.THIRD));
        System.out.printf(SECOND, map.get(WinningTable.SECOND));
        System.out.printf(FIRST, map.get(WinningTable.FIRST));
        System.out.printf(PROFIT, profitRate);
    }
}
