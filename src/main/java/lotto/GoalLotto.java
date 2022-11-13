package lotto;

import java.util.List;

public interface GoalLotto {
    public void saveGoalNumbers(List<Integer> goalNumbers);
    public int saveBonusNumber(int bonusNumber);
    public List<Integer> getGoalNumber();
    public int getBonusNumber();
}
