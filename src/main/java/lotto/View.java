package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class View {
    public View() {

    }
    public String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }
    public void printPurchase(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }
    public List<String> inputWinNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return Arrays.asList(input.split(","));
    }

    public String inputBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public void printStatistics(List<Integer> sameNumbers) {
        System.out.print("당첨 통계\n---\n");
        for(PrizeNumber prizeNumber : PrizeNumber.values()) {
            System.out.print(
                    prizeNumber.prizeString() + " - "
                            + sameNumbers.get(prizeNumber.ordinal()) + "개\n"
            );
        }
    }
    public void printReturnRate(double returnRate) {
        System.out.println("총 수익률은 " + returnRate + "%입니다.");
    }
}
