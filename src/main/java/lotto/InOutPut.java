package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class InOutPut {

    ProcessData change = new ProcessData();
    CoreProcess core = new CoreProcess();
    public String start = "구입금액을 입력해 주세요.";

    public void confirm(int moneyChance) {
        String num = change.setCount(moneyChance);
        System.out.println(num + "개를 구매했습니다.");
    }

    public String input = "당첨 번호를 입력해 주세요.";
    public String inputBonus = "보너스 번호를 입력해 주세요.";

    public void resultLotto(List<Integer> result, double earningRatio) {
        String resultEarning = change.earningCount(earningRatio);
        System.out.println("당첨 통계\n"
                + "---\n"
                + "3개 일치 (5,000원) - " + change.outcomeNumber(1, result) + "개\n"
                + "4개 일치 (50,000원) - " + change.outcomeNumber(2, result) + "개\n"
                + "5개 일치 (1,500,000원) - " + change.outcomeNumber(3, result) + "개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - " + change.outcomeNumber(4, result) + "개\n"
                + "6개 일치 (2,000,000,000원) - " + change.outcomeNumber(5, result) + "개\n"
                + "총 수익률은 " + resultEarning + "%입니다.");
    }

    public String InputNumber(String str) {
        System.out.println(str);
        return Console.readLine();
    }

    public void showMessage(String str) {
        System.out.println(str);
    }


}

