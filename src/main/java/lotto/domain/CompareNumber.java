package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompareNumber {
    private List<List<Integer>> lottoNumbers;
    private List<Integer> winingNumbers;
    private int bonusNumber;
    private List<Integer> lottoResult;

    public CompareNumber(List<List<Integer>> lottoNumbers, List<Integer> winingNumbers, int bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.winingNumbers = winingNumbers;
        this.bonusNumber = bonusNumber;
        this.lottoResult = new ArrayList<>(List.of(0,0,0,0,0));
    }

    public List<Integer> getLottoResult() {
        return lottoResult;
    }

    public void compareLotto(){
        for (List<Integer> lottoNumber : lottoNumbers) {
            int compareCount = countDuplicateNumber(lottoNumber);
            rankLotto(compareCount, lottoNumber);
        }
    }

    public int countDuplicateNumber(List<Integer> lottoNumber){
        List<Integer> joined = Stream.concat(lottoNumber.stream(), winingNumbers.stream())
                .distinct()
                .collect(Collectors.toList());
        return (lottoNumber.size() + winingNumbers.size()) - joined.size();
    }

    public void rankLotto(int correctCount, List<Integer> lottoNumber){
        if(correctCount == 5 && compareBonusNumber(lottoNumber)){
            lottoResult.set(3,lottoResult.get(3)+1);
            return;
        }
        if(correctCount == 6){
            lottoResult.set(4,lottoResult.get(4)+1);
            return;
        }
        if (correctCount >= 3){
            lottoResult.set(correctCount-3,lottoResult.get(correctCount-3)+1);
        }
    }

    public boolean compareBonusNumber(List<Integer> lottoNumber){
        if(lottoNumber.contains(bonusNumber)){
            return true;
        }
        return false;
    }
}
