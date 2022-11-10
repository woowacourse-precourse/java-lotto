package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Manager {

    public void inputWinNumbers(List<List<Integer>> numbers, List<Integer> winNumber) {
        int count = 0;
        Map<String, Integer> winner = new HashMap<>();
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.get(i).size(); j++) {
                if (numbers.get(i).contains(winNumber.get(j))) {
                    System.out.println("numbers.get(i) = " + numbers.get(i));
                    winner.put(numbers.get(i).toString(),winner.getOrDefault(numbers.get(i).toString(), count) + 1);
                }
            }
        }
        System.out.println("count = " + count);

        for (String s : winner.keySet()) {
            System.out.print("s = " + s + " ");
            System.out.print("/ winner = " + winner.get(s) +"개 일치");
            System.out.println();
        }
    }

    public void inputBonusNumber() {

    }
}
