package lotto;

import java.util.List;

public class Comparison {

    int sameNumber = 0;
    int samebonusNumber = 7;
    public int comparisonNumbers(List<Integer> winNumber, List<Integer> lottoNumber) {
        for (int i = 0; i < 5; i++) {
            if (lottoNumber.contains(winNumber.get(i))) {
                sameNumber++;
            }
        }
        if(sameNumber == 5){
            if(lottoNumber.contains(winNumber.get(6))){
                return samebonusNumber;
            }
        }
        return sameNumber;
    }
}
