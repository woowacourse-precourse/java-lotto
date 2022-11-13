package lotto;

import lotto.verifiable.Grade;
import lotto.verifiable.PrizeMoney;

import java.util.List;
import java.util.Map;

public class Profit {
    List<Integer> number;
    Map<PrizeMoney, Integer> gradeGroup;

    public Profit(Map<PrizeMoney, Integer> gradeGroup) {
        this.gradeGroup = gradeGroup;
    }

    public Map<PrizeMoney, Integer> getgradeGroup(){
        return this.gradeGroup;
    }
}
