package lotto.domain;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Analyze {

    private final List<Integer> prizeNumber;
    private final List<List> userLottos;
    private final Integer bonus;
    private static int countingNumber = 1000;

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

    public List<Integer> judgeSecondPrize(){
        List<Integer> judgeSecond = new ArrayList<>();
        for (int i = 0; i < userLottos.size(); i++){
            int number = 0;
            if(matchCountPerLotto().get(i) == 5 && matchBonus().get(i) == 1){
                number = 2;
            }
            judgeSecond.add(number);
        }
        return judgeSecond;
    }

    public List<Integer> finalMatchCountPerLotto(){
        List<Integer> finalMatch = new ArrayList<>();
        for(int i = 0; i < matchCountPerLotto().size(); i++){
            finalMatch.add(matchCountPerLotto().get(i) + judgeSecondPrize().get(i));
        }
        return  finalMatch;
    }
    public List<Integer> getMatchFrequency(){
        List<Integer> matchFrequency = new ArrayList<>();
        for (int i = 3; i < 8; i++){
            matchFrequency.add(Collections.frequency(finalMatchCountPerLotto(), i));
        }
        return matchFrequency;
    }

    public float profit(int lottoCount){
        List<Integer> winnings = PrizeCategory.getWinnings();
        int totalPrize = 0;
        for (int i = 0; i < getMatchFrequency().size(); i++){
            totalPrize += getMatchFrequency().get(i) * winnings.get(i);
        }
        return totalPrize / (lottoCount * countingNumber);
    }

}
