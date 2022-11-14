package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    private List<Integer> winningNumber;

    public LottoResult(String winningNumber){
        this.winningNumber = splitter(winningNumber);
    }

    public List<Integer> getWinningNumber(){
        return winningNumber;
    }

    private List<Integer> splitter(String winningNumber){
        String[] numberInputs = winningNumber.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String numberInput: numberInputs){
            numbers.add(Integer.parseInt(numberInput));
        }

        return numbers;
    }
}
