package lotto;

import java.util.List;

public interface GoalLotto {
    public List<Integer> saveGoalNumbers();
    public int saveBonusNumber();
    public List<Integer> getGoalNumber();
    public int getBonusNumber();
}
