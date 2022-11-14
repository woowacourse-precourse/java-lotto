package lotto.model;

import java.util.List;

public class Compare {

    public int[] getResult(int inputMoney, List<List<Integer>> computerRandomNumbers, String[] numbers, int bonusNumber ) {

        int[] result = new int[5];
        int count;

        for (int i = 0; i < (inputMoney/1000) ; i++) {
            count = 0;
            count = getContainingNumber(computerRandomNumbers, numbers, count, i);
        }
        return result;
    }

    public int getContainingNumber(List<List<Integer>> computerRandomNumbers, String[] numbers, int count, int i) {
        for (int j = 0; j < 6 ; j++) {
            if (computerRandomNumbers.get(i).contains(Integer.parseInt(numbers[j]))) count++;
        }
        return count;
    }
}
