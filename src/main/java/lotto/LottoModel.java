package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoModel {
    private List<Integer> winNumbers;
    private Integer bonusNumber;
    private List<List<Integer>> issueLotto = new ArrayList<>();

    public void saveWinNumbers(List<Integer> winNumbers){
        this.winNumbers = winNumbers;
    }
    public List<Integer> getSavedWinNumbers(){
        return this.winNumbers;
    }

    public void saveBonusNumber(int bonusNumber){
        this.bonusNumber = bonusNumber;
    }
    public Integer getSavedBonusNumber(){
        return this.bonusNumber;
    }

    public void saveIssueLotto(int theNumberOfLotto){
        for(int i=0; i<theNumberOfLotto; i++){
            issueLotto.add(Lotto.makeLotto().getNumbers());
        }
    }
    public List<List<Integer>> getSavedIssueLotto(){
        return this.issueLotto;
    }
}
