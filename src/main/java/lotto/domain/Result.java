package lotto.domain;

import java.util.List;

public class Result {
    private int[][] result;

    public int[][] convertLotto(List<Lotto> input,List<Integer> winning, String bonus){
        result = new int[input.size()][2];
        for(int i=0; i<input.size(); i++){
            compareLotto(input.get(i), winning,i);
            compareBonus(input.get(i),bonus,i);
        }
        return result;
    }

    private void compareLotto(Lotto lotto, List<Integer> winning, int i) {
        for(int j = 0; j< lotto.getLotto().size(); j++){
            if(winning.contains(lotto.getLotto().get(j))){
                result[i][0]++;
            }
        }
    }
    private void compareBonus(Lotto lotto, String bonus, int i){
        if(lotto.getLotto().contains(Integer.parseInt(bonus))){
            result[i][1]++;
        }
    }

}
