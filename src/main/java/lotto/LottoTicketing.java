package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LottoTicketing {

    public List<Integer> getValidLottoNumbers(){
        List<Integer> lottoNumbers;
        lottoNumbers=Randoms.pickUniqueNumbersInRange(1,45,6);
        Set<Integer>lottoNumbersWithoutDuplication=checkDuplicatedNumbers(lottoNumbers);
        lottoNumbers = new ArrayList<>(lottoNumbersWithoutDuplication);
        return lottoNumbers;

    }

    public Set<Integer> checkDuplicatedNumbers(List<Integer> lottoNumbers){
        Set<Integer> lottoNumbersWithoutDuplication= new TreeSet<>(lottoNumbers);
        if(lottoNumbers.size()!=lottoNumbersWithoutDuplication.size()){
            getValidLottoNumbers();
        }
        return lottoNumbersWithoutDuplication;
    }

    public List<List<Integer>> giveLottoTickets(int howManyTickets){
        List<List<Integer>> lottoTickets = new ArrayList<>();
        for(int howManyTimes=0; howManyTimes<howManyTickets; howManyTimes++) {
            lottoTickets.add(getValidLottoNumbers());
        }
        return lottoTickets;
    }
}
