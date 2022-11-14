package lotto.domain;

import java.util.List;

public class Analyze {

    private final List<Integer> prizenumber;
    private final List<List> userlottos;
    private final Integer bonus;

    Analyze(List<Integer> prizenumber, Integer bonus, List<List> userlottos){
        this.prizenumber = prizenumber;
        this.bonus = bonus;
        this.userlottos = userlottos;
    }

    public List<Integer> userlotto(int i){
        return userlottos.get(i);
    }

    public void matchCount(List<Integer> userlotto){
        for (int i = 0; i < userlotto.size(); i++){
            int count = 0;
            if (prizenumber.contains(userlotto(i).get(i))) {
                count += 1;
            }
        }
    }


}
