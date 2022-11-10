package lotto.UI;

import camp.nextstep.edu.missionutils.Console;

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
}
