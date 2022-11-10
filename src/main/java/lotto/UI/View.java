package lotto.UI;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

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
            System.out.println(lotto);
        }
    }
}
