package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InOutPut {

    public String start = "구입금액을 입력해 주세요.";
    public String confirm = "N개를 구매했습니다.";
    public String input = "당첨 번호를 입력해 주세요.";
    public String inputBonus = "보너스 번호를 입력해 주세요.";
    public String resultLotto = "당첨 통계\n"
            + "---\n"
            + "3개 일치 (5,000원) - N개\n"
            + "4개 일치 (50,000원) - N개\n"
            + "5개 일치 (1,500,000원) - N개\n"
            + "5개 일치, 보너스 볼 일치 (30,000,000원) - N개\n"
            + "6개 일치 (2,000,000,000원) - N개\n"
            + "총 수익률은 %입니다.";

    public String InputNumber() {
        return Console.readLine();
    }

    public void showMessage(String str) {
        System.out.println(str);
    }

}
