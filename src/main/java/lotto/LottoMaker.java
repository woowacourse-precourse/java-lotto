package lotto;

import java.util.List;

public class LottoMaker {

    private List<Integer> splitNumber(String number){

        String [] numbers =number.split(",");
        return stringToInteger(numbers);
    }

}
