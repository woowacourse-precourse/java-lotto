package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMaker {

    private Exception exception = new Exception();

    List<Integer> splitNumber(String number){
        String [] numbers =number.split(",");
        return stringToInteger(numbers);
    }

    private List<Integer> stringToInteger(String [] numbers){
        List<Integer> LottoNumber = new ArrayList<>();
        for(int i=0;i<numbers.length;i++){
            if(exception.lottoValidator(Integer.parseInt(numbers[i]))){
                LottoNumber.add(Integer.parseInt(numbers[i]));
                continue;
            }
            throw new IllegalArgumentException("ERROR");
        }
        return LottoNumber;
    }

}
