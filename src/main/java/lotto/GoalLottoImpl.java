package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
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
        if(split.length!=6){
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 제대로 입력해주세요");
        }
        for (int i = 0; i < split.length; i++) {
            checkGoalNum(result, split[i]);
        }
    }

    private static void checkGoalNum(ArrayList<Integer> result, String split) {

        try {
        int num = Integer.parseInt(split);
        result.add(num);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 제대로 입력해주세요");
        }
    }

    @Override
    public int saveBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요");
        String s = Console.readLine();
        return checkBonusNum(s);
    }

    private static int checkBonusNum(String s) {
        if(s.length()!=2&&s.length()!=1){
            throw new IllegalArgumentException("[ERROR]보너스 번호를 제대로 입력해주세요");
        }
        try {
            int result = Integer.parseInt(s);
            return result;
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR]보너스 번호를 제대로 입력해주세요");
        }
    }
}
