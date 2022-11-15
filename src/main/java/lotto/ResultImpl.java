package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ResultImpl implements Result{

    private final BuyLotto buyLotto;
    private final GoalLotto goalLotto;

    private final ArrayList<Lotto> lottos;
    private final List<Integer> goalNumbers;

    private final int buyMoney;
    private final int bonusNumber;
    public ResultImpl(BuyLotto buyLotto, GoalLotto goalLotto, int buyMoney) {
        this.buyLotto = buyLotto;
        this.goalLotto = goalLotto;
        this.lottos = buyLotto.getLottos();
        this.goalNumbers = goalLotto.saveGoalNumbers();
        this.bonusNumber = goalLotto.saveBonusNumber();
        this.buyMoney = buyMoney;
    }


    @Override
    public void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+ calculateGoal().getOrDefault(GoalType.Fifth,0)+"개");
        System.out.println("4개 일치 (50,000원) - "+ calculateGoal().getOrDefault(GoalType.Fourth,0)+"개");
        System.out.println("5개 일치 (1,500,000원) - "+ calculateGoal().getOrDefault(GoalType.Third,0)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+ calculateGoal().getOrDefault(GoalType.Second,0)+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+ calculateGoal().getOrDefault(GoalType.First,0)+"개");
        System.out.println("총 수익률은 "+calculatePer()+"%입니다.");
    }


    @Override
    public String calculatePer() {
        System.out.println(moneyResult());
        double result = (double)moneyResult() / (double) buyMoney *100;

        String formatedResult = String.format("%.1f", result);

        return formatedResult;
    }
    public int moneyResult(){
        int result = 0;
        HashMap<GoalType, Integer> myGoals = calculateGoal();
        int moneyFifth = myGoals.getOrDefault(GoalType.Fifth,0) * 5000;
        int moneyFourth = myGoals.getOrDefault(GoalType.Fourth,0) * 50000;
        int moneyThird = myGoals.getOrDefault(GoalType.Third,0) * 1500000;
        int moneySecond = myGoals.getOrDefault(GoalType.Second,0) * 30000000;
        int moneyFirst = myGoals.getOrDefault(GoalType.First,0) * 2000000000;
        result =moneyFifth+moneyFourth+moneyThird+moneySecond+moneyFirst;
        return result;
    }
    @Override
    public HashMap<GoalType, Integer> calculateGoal() {
        HashMap<GoalType,Integer> result= new HashMap<>();
        checkGoalCount(result);
        return result;
    }

    private void checkGoalCount(HashMap<GoalType, Integer> result) {
        for (int i = 0; i < lottos.size(); i++) {
            List<Integer> numbers = lottos.get(i).getNumbers();
            boolean haveBonusNumber =lottos.get(i).getNumbers().indexOf(bonusNumber)>0;
            numbers.retainAll(goalNumbers);
            if(numbers.size()==3){
                result.put(GoalType.Fifth, result.getOrDefault(GoalType.Fifth,0)+1);
                continue;
            }
            if(numbers.size()==4){
                result.put(GoalType.Fourth, result.getOrDefault(GoalType.Fourth,0)+1);
                continue;
            }
            if(numbers.size()==5&&haveBonusNumber){
                result.put(GoalType.Second, result.getOrDefault(GoalType.Second,0)+1);
                continue;
            }
            if(numbers.size()==5){
                result.put(GoalType.Third, result.getOrDefault(GoalType.Third,0)+1);
                continue;
            }
            if(numbers.size()==6){
                result.put(GoalType.First,result.getOrDefault(GoalType.First,0)+1);
            }
        }
    }
}
