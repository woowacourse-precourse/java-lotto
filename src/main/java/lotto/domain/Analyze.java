package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Analyze {

    private final List<Integer> prizeNumber;
    private final List<List> userLottos;
    private final Integer bonus;

    public Analyze(List<Integer> prizeNumber, Integer bonus, List<List> userLottos){
        this.prizeNumber = prizeNumber;
        this.bonus = bonus;
        this.userLottos = userLottos;
    }

    public Integer matchCount(List<Integer> userLotto){
        int count = 0;
        for (int i = 0; i < prizeNumber.size(); i++){
            if (prizeNumber.contains(userLotto.get(i))) {
                count += 1;
            }
        }
        return count;
    }

    public List<Integer> matchCountPerLotto(){
        List<Integer> matchPerLotto = new ArrayList<>();
        for (int i = 0; i < userLottos.size(); i++){
            matchPerLotto.add(matchCount(userLottos.get(i)));
        }
        return matchPerLotto;
    }


}
