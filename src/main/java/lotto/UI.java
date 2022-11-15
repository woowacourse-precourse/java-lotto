package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;

public class UI {
    private int cost;
    private List<Integer> winningNumbers;
    private int bonus;

    public UI() {
        this.winningNumbers = new ArrayList<>();
    }

    public int getCost() {
        return cost;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonus() {
        return bonus;
    }

    public void inputCost() {
        System.out.println("구입 금액을 입력해 주세요.");
        this.cost = Integer.parseInt(readLine());
        System.out.println();
    }

    public void inputWinning() {
        System.out.println("당첨 번호를 입력해 주세요");
        String[] winning = readLine().split(",");
        for (int i = 0; i < winning.length; i++) {
            winningNumbers.add(Integer.parseInt(winning[i]));
        }
        System.out.println();
    }

    public void inputBonus() {
        System.out.println("보너스 번호를 입력해 주세요");
        this.bonus = Integer.parseInt(readLine());
        System.out.println();
    }

    public void showCostCount() {
        System.out.println(this.cost/1000+"개를 구매했습니다.");
    }

    public void showLottoNumbers(List<List<Integer>> lottoNumbers) {
        for (List<Integer> list : lottoNumbers) {
            System.out.println(list.toString());
        }
        System.out.println();
    }

    public void showWinning(int first, int second, int third, int fourth, int fifth) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+fifth+"개");
        System.out.println("4개 일치 (50,000원) - "+fourth+"개");
        System.out.println("5개 일치 (1,500,000원) - "+third+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+second+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+first+"개");
    }

    public void showYield(float yield) {
        System.out.println("총 수익률은 "+yield+"%입니다.");
    }
}
