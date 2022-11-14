package lotto.domain;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Collections;
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

    public List<Integer> matchBonus(){
        List<Integer> bonusMatchPerLotto = new ArrayList<>();
        for (int i = 0; i < userLottos.size(); i++){
            int bonusMatchNumber = 0;
            if (userLottos.get(i).contains(bonus)){
                bonusMatchNumber = 1;
            }
            bonusMatchPerLotto.add(bonusMatchNumber);
        }
        return bonusMatchPerLotto;
    }

    public List<Integer> getMatchFrequency(){
        List<Integer> matchFrequency = new ArrayList<>();
        for (int i = 3; i < 7; i++){
            matchFrequency.add(Collections.frequency(matchCountPerLotto(), i));
        }
        return matchFrequency;
    }

}
