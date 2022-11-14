package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningNumbers {
    Input input;

    public List<Integer> winningNumbers;
    public int bonsNumber;


    public WinningNumbers(){
        winningNumbers = new ArrayList<>();
        bonsNumber = 0;
    }

    public List<Integer> finalWinningNumbers(String inputWinningNumber){
        String [] numbers = inputWinningNumber.split(",");
        List<Integer> winning = new ArrayList<>();
        for(int i = 0; i<numbers.length; i++){
            winning.add(Integer.valueOf(numbers[i]));
        }
        winningNumbers = winning;
        Collections.sort(winningNumbers);
        return winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
