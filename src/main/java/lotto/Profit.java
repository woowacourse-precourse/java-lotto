package lotto;

import lotto.verifiable.PrizeMoney;
import java.util.Map;

public class Profit {
    Map<PrizeMoney, Integer> gradeGroup;

    public Profit(Map<PrizeMoney, Integer> gradeGroup) {
        this.gradeGroup = gradeGroup;
    }

    public Map<PrizeMoney, Integer> getgradeGroup(){
        return this.gradeGroup;
    }
}
