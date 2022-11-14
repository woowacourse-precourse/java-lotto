package lotto;

import java.util.ArrayList;
import java.util.List;

public class GetUerNumber {
      public List<Integer> makeWinningNumber(String userInput){
        Validate checkLottoNumber = new Validate();
        List<Integer> WinningNumber = new ArrayList<>();
        checkLottoNumber.validateUserInput(userInput);
        String [] splitNumber = userInput.split(",");
        for (String num : splitNumber) {
            WinningNumber.add(Integer.parseInt(num));
        }
        return WinningNumber;
    }
}
