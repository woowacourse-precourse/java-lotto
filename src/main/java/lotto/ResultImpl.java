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
        System.out.println("3개 일치 (5,000원) - "+ calculateGoal().get(GoalType.Fifth)+"개");
        System.out.println("4개 일치 (50,000원) - "+ calculateGoal().get(GoalType.Fourth)+"개");
        System.out.println("5개 일치 (1,500,000원) - "+ calculateGoal().get(GoalType.Third)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+ calculateGoal().get(GoalType.Second)+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+ calculateGoal().get(GoalType.First)+"개");
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
        int moneyFifth = myGoals.get(GoalType.Fifth) * 5000;
        int moneyFourth = myGoals.get(GoalType.Fourth) * 50000;
        int moneyThird = myGoals.get(GoalType.Third) * 1500000;
        int moneySecond = myGoals.get(GoalType.Second) * 30000000;
        int moneyFirst = myGoals.get(GoalType.First) * 2000000000;
        result =moneyFifth+moneyFourth+moneyThird+moneySecond+moneyFirst;
        return result;
    }
    @Override
    public HashMap<GoalType, Integer> calculateGoal() {

        HashMap<GoalType,Integer> result= new HashMap<>();
        int fifthCount = 0;
        int fourthCount = 0;
        int thirdCount = 0;
        int secondCount = 0;
        int firstCount = 0;
        result.put(GoalType.Fifth,0);
        result.put(GoalType.Fourth,0);
        result.put(GoalType.Third,0);
        result.put(GoalType.Second,0);
        result.put(GoalType.First,0);
        checkGoalCount(result, fifthCount, fourthCount,thirdCount, secondCount, firstCount);
        return result;
    }

    private void checkGoalCount(HashMap<GoalType, Integer> result, int fifthCount, int fourthCount,int thirdCount, int secondCount, int firstCount) {
        for (int i = 0; i < lottos.size(); i++) {
            List<Integer> numbers = lottos.get(i).getNumbers();
            boolean haveBonusNumber =lottos.get(i).getNumbers().indexOf(bonusNumber)>0;
            numbers.retainAll(goalNumbers);
            if(numbers.size()==3){
                result.put(GoalType.Fifth, ++fifthCount);
                continue;
            }
            if(numbers.size()==4){
                result.put(GoalType.Fourth, ++fourthCount);
                continue;
            }
            if(numbers.size()==5&&haveBonusNumber){
                result.put(GoalType.Second, ++secondCount);
                continue;
            }
            if(numbers.size()==5){
                result.put(GoalType.Third, ++thirdCount);
                continue;
            }
            if(numbers.size()==6){
                result.put(GoalType.First,++firstCount);
            }
        }
    }
}
