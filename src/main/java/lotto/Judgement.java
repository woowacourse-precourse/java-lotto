package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Judgement {
    private List<HashMap<Integer, Boolean>> resultTable;
    private float returnRate;
    private List<Integer> lotto;
    private int bonusNumber;


    public Judgement(List<Integer> lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
        this.resultTable = new ArrayList<>();
        this.returnRate = 0.00F;
    }

    private void compare(List<Integer> lotteryNumbers) {
        int count = 0;
        boolean bonusFlag = false;
        HashMap<Integer, Boolean> tableValue = new HashMap<>();

        for(int number : lotteryNumbers) {
            if (this.lotto.contains(number)) count++;
        }

        if(lotteryNumbers.contains(bonusNumber)) bonusFlag = true;

        tableValue.put(count, bonusFlag);
        resultTable.add(tableValue);
    }

    public void informLottoResult(ArrayList<ArrayList<Integer>> lotteryNumbers) {
        for(List<Integer> lotteryNumber : lotteryNumbers){
            compare(lotteryNumber);
        }

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + search(3, false) + "개");
        System.out.println("4개 일치 (50,000원) - " + search(4, false) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + search(5, false) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + search(5, true) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + search(6, false) + "개");
        System.out.println("총 수익률은" + "%입니다.");
    }

    private int search(int count, boolean flag){

        // 5개 일치, 보너스 볼 일치인 경우 조회
        if(flag){
            return (int) resultTable.stream()
                    .filter(map -> map.containsKey(count))
                    .filter(map -> map.containsValue(flag))
                    .count();
        }

        // 5개 일치, 보너스 볼 불일치인 경우 조회
        if(count == 5) {
            return (int) resultTable.stream()
                    .filter(map -> map.containsKey(count))
                    .filter(map -> map.containsValue(false))
                    .count();
        }

        return (int) resultTable.stream()
                .filter(map -> map.containsKey(count))
                .count();
    }
}
