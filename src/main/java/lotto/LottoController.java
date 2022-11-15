package lotto;

import java.util.List;

public class LottoController {

    private static int compareOneElement(int i, List<Integer> oneLotto, List<Integer> winNumbers){
        int count =0;
        for(int j=0; j<winNumbers.size(); j++){
            if(oneLotto.get(i).equals(winNumbers.get(j))){
                count++;
            }
        }
        return count;
    }

    private static int compareOneLotto(List<Integer> oneLotto, List<Integer> winNumbers){
        int count = 0;
        for(int i=0; i<oneLotto.size(); i++){
            count += compareOneElement(i,oneLotto,winNumbers);
        }
        return count;
    }

    private static boolean compareBonus(List<Integer> oneLotto, Integer bonusNumber){
        boolean isSame = false;
        for(int i=0; i<oneLotto.size(); i++){
            if(oneLotto.get(i).equals(bonusNumber)){
                isSame = true;
            }
        }
        return isSame;
    }

    public static int first(LottoModel lottoModel){
        int count = 0;
        List<List<Integer>> issueLotto = lottoModel.getSavedIssueLotto();
        List<Integer> winNumbers = lottoModel.getSavedWinNumbers();
        for(int i=0; i<issueLotto.size(); i++){
            if(compareOneLotto(issueLotto.get(i), winNumbers) == 6){
                count++;
            }
        }
        return count;
    }

    public static int second(LottoModel lottoModel){
        int count = 0;
        List<List<Integer>> issueLotto = lottoModel.getSavedIssueLotto();
        List<Integer> winNumbers = lottoModel.getSavedWinNumbers();
        Integer bonusNumber = lottoModel.getSavedBonusNumber();
        for(int i=0; i<issueLotto.size(); i++){
            if(compareOneLotto(issueLotto.get(i), winNumbers) == 5
                    && compareBonus(issueLotto.get(i), bonusNumber)){
                count++;
            }
        }
        return count;
    }

    public static int third(LottoModel lottoModel){
        int count = 0;
        List<List<Integer>> issueLotto = lottoModel.getSavedIssueLotto();
        List<Integer> winNumbers = lottoModel.getSavedWinNumbers();
        Integer bonusNumber = lottoModel.getSavedBonusNumber();
        for(int i=0; i<issueLotto.size(); i++){
            if(compareOneLotto(issueLotto.get(i), winNumbers) == 5
                    && !compareBonus(issueLotto.get(i), bonusNumber)){
                count++;
            }
        }
        return count;
    }

    public static int fourth(LottoModel lottoModel){
        int count = 0;
        List<List<Integer>> issueLotto = lottoModel.getSavedIssueLotto();
        List<Integer> winNumbers = lottoModel.getSavedWinNumbers();
        for(int i=0; i<issueLotto.size(); i++){
            if(compareOneLotto(issueLotto.get(i), winNumbers) == 4){
                count++;
            }
        }
        return count;
    }

    public static int fifth(LottoModel lottoModel){
        int count = 0;
        List<List<Integer>> issueLotto = lottoModel.getSavedIssueLotto();
        List<Integer> winNumbers = lottoModel.getSavedWinNumbers();
        for(int i=0; i<issueLotto.size(); i++){
            if(compareOneLotto(issueLotto.get(i), winNumbers) == 3){
                count++;
            }
        }
        return count;
    }
}
