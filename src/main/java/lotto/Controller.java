package lotto;
import lotto.*;
import java.util.*;

public class Controller {
    private List<HashMap<Integer, Boolean>> resultList;
    private float profitRate;
    private List<Integer> lotto;
    private int bonusNumber;
    private final static String AVERAGE_WINNING_MESSAGE = "당첨 통계";
    private int enoughMoney;
    private int realPurchasedMoney;

    public Controller(List<Integer> lotto, int bonusNumber, int money) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
        this.resultList = new ArrayList<>();
        this.profitRate = 0.00F;
        this.enoughMoney = enoughMoney;
        this.realPurchasedMoney = realPurchasedMoney;

    }

    public void compareResult(List<Integer> numbers) {
        int count = 0;
        boolean hasBonus = false;
        HashMap<Integer, Boolean> valueResult = new HashMap<>();

        for(int number : numbers) {
            if(this.lotto.contains(number)) count++;
        }
        if(numbers.contains(bonusNumber)) {
            hasBonus = true;
        }
        valueResult.put(count, hasBonus);
        resultList.add(valueResult);
    }

    public void showLottoWinningResult(ArrayList<ArrayList<Integer>> numbersContainer) {
        for(List<Integer> numbers : numbersContainer) {
            compareResult(numbers);
        }
        System.out.println(AVERAGE_WINNING_MESSAGE);
        System.out.println("---");
        System.out.println("3개 일치(5,000원) - "+findResult(3, false)+"개");
        this.enoughMoney += 5000*findResult(3, false);
        System.out.println("4개 일치(50,000원) - "+findResult(4, false)+"개");
        this.enoughMoney += 50000*findResult(4, false);
        System.out.println("5개 일치(1,500,000원) - "+findResult(5, false)+"개");
        this.enoughMoney += 1500000*findResult(5, false);
        System.out.println("5개 일치, 보너스 볼 일치(30,000,000원) - "+findResult(5, true)+"개");
        this.enoughMoney += 30000000*findResult(5, true);
        System.out.println("6개 일치(2,000,000,000원) - "+findResult(6, false)+"개");
        this.enoughMoney += 2000000000*findResult(6, false);
        calculateProfitRate();
        System.out.println("총 수익률은 "+String.format("%1.f", this.profitRate)+"%입니다.");
    }

    public int findResult(int count, boolean hasBonus) {
        if(hasBonus) {
            return (int) resultList.stream().filter(map -> map.containsKey(count)).filter(map -> map.containsValue(hasBonus)).count();
        }
        if(count == 5) {
            return (int)resultList.stream().filter(map -> map.containsKey(count)).filter(map -> map.containsValue(false)).count();
        }
        return (int) resultList.stream().filter(map -> map.containsKey(count)).count();
    }

    public void calculateProfitRate() {
        this.profitRate = (float)((float)this.enoughMoney/(float)this.realPurchasedMoney*100.0);
    }
}
