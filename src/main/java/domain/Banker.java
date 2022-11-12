package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Banker {
    public Banker() {
    }

    private Map<Victory, Integer> map = new HashMap<>();
    private List<Integer> winningNumber = new ArrayList<>();
    private Integer bonusNumber;

    public void setWinningNumber(List<Integer> winningNumber) {
        this.winningNumber = winningNumber;
    }

    public void setBonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public Map<String, Integer> correctCount(List<Integer> lotto) {
        Map<String,Integer> victoryNumber = new HashMap<>();
        int result = 0;
        int resultBonus = 0;
        for (int i = 0; i < lotto.size(); i++) {
            if (lotto.contains(winningNumber.get(i))) {
                result++;
            }
        }
        if (lotto.contains(bonusNumber)) {
            resultBonus++;
        }
        victoryNumber.put("result", result);
        victoryNumber.put("resultBonus", resultBonus);
        return victoryNumber;
    }


}
