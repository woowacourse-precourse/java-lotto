package lotto.UI;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class View {
    public int getInvestmentCash(){
        String input = Console.readLine();

        return Integer.parseInt(input);
    }

    public List<Integer> getWinningNumber(){
        String input = Console.readLine();
        String[] numbers = input.split(",");

        List<Integer> winningNumber = new ArrayList<>();
        for(String number: numbers){
            winningNumber.add(Integer.parseInt(number));
        }

        return winningNumber;
    }

    public int getBonusNumber(){
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
