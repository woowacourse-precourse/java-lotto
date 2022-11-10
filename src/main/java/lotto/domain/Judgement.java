package lotto.domain;

import java.util.List;

public class Judgement {
    public boolean compare(){
        return false;
    }
    public int countCorrectNumbers(List<Integer> ComputerLottoNumbers, List<Integer> userLottoNumbers){
        int count = 0;
        for(int i=0; i<ComputerLottoNumbers.size(); i++){
            if(userLottoNumbers.contains(ComputerLottoNumbers.get(i))){
                count ++;
            }
        }
        return count;
    }
}
