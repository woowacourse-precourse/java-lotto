package lotto.function;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import lotto.*;

public class CompareLotto {
    public HashMap<Integer, Integer> lottoRate = new HashMap<>();

    public CompareLotto(){
        for(int i=0;i<8; i++){
            lottoRate.put(i,0);
        }
    }
    public void lottoListCompare(List<Lotto> lottoList, List<Integer> winnerNumber, int bonusNumber){
        for ( Lotto data : lottoList){
            List<Integer> lottoNumber = new ArrayList<>(data.getNumber());
            compareNumber(lottoNumber, winnerNumber, bonusNumber);
        }
    }

    public void compareNumber(List<Integer> lottoNumber, List<Integer> winnerNumber, int bonusNumber){
        int count = 0;
        for(int number : lottoNumber){
            if(winnerNumber.contains(number)){
                count += 1;
            }
        }

        if(count == 6){ // 1등은 count 7, 2등은 count 6, ... 5등은 count 3.
            count +=1;
        }
        else if(count == 5) { // 2등 : 5개 일치 + 보너스 일치
            if (lottoNumber.contains(bonusNumber)) {
                count += 1;
            }
        }
        lottoRate.put(count, lottoRate.get(count)+1);
    }

}
