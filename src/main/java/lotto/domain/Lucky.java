package lotto.domain;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lucky {
    public List<Integer> compareNumbers(List<List<Integer>> user, List<Integer> com, int bonusNumber) {
        List<Integer> compareNumbers = new ArrayList<>();
        for (int i = 0; i < user.size(); i++) {
            int count = 0;
            for (int j = 0; j < user.get(i).size(); j++) {
                int num = user.get(i).get(j);
                if (com.contains(num)) {
                    count++;
                }
            }
            if (count == 5) {
                count += compareBonus(user.get(i), bonusNumber);
            }
            if (count > 2) {
                compareNumbers.add(count);
            }
        }
        return compareNumbers;
    }

    public int compareBonus(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            return 2;
        }
        return 0;
    }

    public HashMap<Integer, Integer> compareResult(List<Integer> compareNumbers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(5, 0);
        map.put(4, 0);
        map.put(3, 0);
        map.put(7, 0);
        map.put(1, 0);
        for (int i = 0; i < compareNumbers.size(); i++) {
            if (compareNumbers.get(i) == 3) {
                map.put(5, map.get(5) + 1);
            } else if (compareNumbers.get(i) == 4) {
                map.put(4, map.get(4) + 1);
            } else if (compareNumbers.get(i) == 5) {
                map.put(3, map.get(3) + 1);
            } else if (compareNumbers.get(i) == 7) {
                map.put(7, map.get(7) + 1);
            } else if (compareNumbers.get(i) == 6) {
                map.put(1, map.get(1) + 1);
            }
        }
        return map;
    }

    public void showResult(HashMap<Integer, Integer> compareResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + compareResult.get(5) + "개");
        System.out.println("4개 일치 (50,000원) - " + compareResult.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + compareResult.get(3) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + compareResult.get(7) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + compareResult.get(1) + "개");
    }

    public String profitResult(HashMap<Integer, Integer> compareResult, int price) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###.0");
        String profitResult;
        double result = 0;
        double sum = 0;
        sum += compareResult.get(5)*5000;
        sum += compareResult.get(4)*50000;
        sum += compareResult.get(3)*1500000;
        sum += compareResult.get(7)*30000000;
        sum += compareResult.get(1)*2000000000;
        result = (sum/price)*100;
        profitResult = decimalFormat.format(result);
        return profitResult;
    }

    public void showProfit(String profitResult) {
        System.out.println("총 수익률은 " + profitResult + "%입니다.");
    }
}
