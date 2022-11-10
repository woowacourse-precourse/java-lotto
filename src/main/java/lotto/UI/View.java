package lotto.UI;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.domain.Prize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class View {
    public int getInvestmentCash(){
        System.out.println("구입 금액을 입력해주세요.");
        String input = Console.readLine();

        return Integer.parseInt(input);
    }

    public List<Integer> getWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] numbers = input.split(",");

        List<Integer> winningNumber = new ArrayList<>();
        for(String number: numbers){
            winningNumber.add(Integer.parseInt(number));
        }

        return winningNumber;
    }

    public int getBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();

        return Integer.parseInt(input);
    }

    public void printMyLottoInfo(List<Lotto> myLottos){
        int quantity = myLottos.size();
        System.out.println(quantity + "개를 구매했습니다.");
        for(Lotto lotto: myLottos){
            System.out.println(lotto.getNumbers());
        }
    }

    public void printResult(HashMap<Prize, Integer> state, double profit){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(String.format("3개 일치 (5,000원) - %d개", state.get(Prize.FIFTH)));
        System.out.println(String.format("4개 일치 (50,000원) - %d개", state.get(Prize.FOURTH)));
        System.out.println(String.format("5개 일치 (1,500,000원) - %d개", state.get(Prize.THIRD)));
        System.out.println(String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", state.get(Prize.SECOND)));
        System.out.println(String.format("6개 일치 (2,000,000,000원) - %d개", state.get(Prize.FIRST)));
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }
}
