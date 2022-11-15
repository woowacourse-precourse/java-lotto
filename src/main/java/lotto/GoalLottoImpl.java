package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoalLottoImpl implements GoalLotto{
    @Override
    public List<Integer> saveGoalNumbers() {
        System.out.println("당첨 번호를 입력해 주세요");
        String s = Console.readLine();
        String[] split = s.split(",");
        ArrayList<Integer> result = new ArrayList<>();
        addGoalNumbers(split, result);
        return result;
    }

    private static void addGoalNumbers(String[] split, ArrayList<Integer> result) {
        for (int i = 0; i < split.length; i++) {
            try {
            int num = Integer.parseInt(split[i]);
            result.add(num);
            }catch (IllegalArgumentException e){
                throw new IllegalArgumentException("[ERROR] 당첨 번호를 제대로 입력해주세요");
            }
        }
    }

    @Override
    public int saveBonusNumber() {
        return 0;
    }

    @Override
    public List<Integer> getGoalNumber() {
        return null;
    }

    @Override
    public int getBonusNumber() {
        return 0;
    }
}
