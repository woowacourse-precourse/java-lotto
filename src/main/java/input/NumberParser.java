package input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;

public class NumberParser {
    public List<Integer> getWinningNumbers(){
        String rawNumbers = Console.readLine();
        String[] splittedNumbers = rawNumbers.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for(String number : splittedNumbers){
            winningNumbers.add(Integer.parseInt(number));
        }

        return winningNumbers;
    }

    public int getBonusNumber(){
        String rawNumbers = Console.readLine();
        int bonusNumber = Integer.parseInt(rawNumbers);
        return bonusNumber;
    }
}
