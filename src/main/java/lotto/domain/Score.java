package lotto.domain;

import java.util.Arrays;
import java.util.List;

import lotto.domain.Lottos;
import lotto.domain.Paper;
import lotto.domain.Lucky;
import lotto.domain.Bonusnumber;

public class Score {
    private final List<Integer> score;

    public Score(){
        score = Arrays.asList(0, 0, 0, 0, 0, 0);
    }

    public void Rating_start(Paper paper, Lottos lottos, Lucky lucky, Bonusnumber bonusnumber){
        int index;
        for (int i = 0; i < paper.Get_Paper(); i++){
            index = Rating_lucky(lottos.Get_lotto(i), lucky, bonusnumber);
            if (index >= 0 && index <= 4)
                score.set(index, score.get(index) + 1);
        }
    }

    private int Rating_lucky(Lotto lotto, Lucky lucky, Bonusnumber bonusnumber){
        int count = 0;
        for (int i = 0; i < lucky.Get_size(); i++){
            if (lotto.contains(lucky.Get_val(i)))
                count++;
        }
        if (lotto.contains(bonusnumber.Get_val()))
            count += 10;
        return Get_index(count);
    }

    private int Get_index(int count){
        if (count == 6)
            return 4;
        if (count == 15)
            return 3;
        return count - 3;
    }

    public int Get_size(){
        return score.size();
    }

    public int Get_val(int index){
        return score.get(index);
    }
}
