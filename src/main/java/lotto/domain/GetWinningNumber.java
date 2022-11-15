package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class GetWinningNumber {
    public List<Integer> winningNumber;
      public void getWinningNumber(String userInput){
        Validate checkLottoNumber = new Validate();
        winningNumber = new ArrayList<>();
        checkLottoNumber.validateUserInput(userInput);
        String [] splitNumber = userInput.split(",");
        for (String num : splitNumber) {
            winningNumber.add(Integer.parseInt(num));
        }
    }
}
