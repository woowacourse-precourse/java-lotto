package lotto.View;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserException {
    public void IsNumberFormat(String input) throws IllegalArgumentException{
        try{
            Double.parseDouble(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
    public void IsRightWinnerNumberFormat(String winnerNumber) throws IllegalArgumentException{
        try{
            List<Integer> numbers = Arrays.stream(winnerNumber.split(","))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
            for(int number : numbers){
                isRightLottoNumber(number);
            }
        }catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    public void IsRightBonusNumberFormat(String bonusNumber) throws IllegalArgumentException{
        try{
            Double.parseDouble(bonusNumber);
            isRightLottoNumber(Integer.parseInt(bonusNumber));
        }catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    public void isRightLottoNumber(int number){
        final int minLottoNumber = 1;
        final int maxLottoNumber = 45;
        if(minLottoNumber > number || number > maxLottoNumber){
            throw new NumberFormatException();
        }
    }
}