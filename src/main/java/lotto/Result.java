package lotto;

import java.util.HashMap;
import java.util.List;

public interface Result {
    public void printResult();
    public String calculatePer();
    public HashMap<GoalType,Integer> calculateGoal();
}
