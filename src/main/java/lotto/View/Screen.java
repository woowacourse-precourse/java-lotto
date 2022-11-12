package lotto.View;

import lotto.domain.Lotto;
import lotto.domain.Result;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Screen {

    public String readMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return readLine();
    }

    public String readLotto(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return readLine();
    }

    public String readBonus(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return readLine();
    }

    public void printLottoCount(int num){
        System.out.println(num + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos){
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printResult(Result result) {
        System.out.println("3개 일치 (5,000원) - " + result.getFifth() + "개");
        System.out.println("4개 일치 (50,000원) - " + result.getFourth() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.getThird() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.getSecond() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.getFirst() + "개");
        System.out.println("총 수익률은 " + Math.round((result.getEarningsRate())*10)/10.0 + "%입니다.");
    }
}
