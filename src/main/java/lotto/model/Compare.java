package lotto.model;

import java.util.List;

public class Compare {

    public int[] getResult(int inputMoney, List<List<Integer>> computerRandomNumbers, String[] numbers, int bonusNumber ) {

        int[] result = new int[5];
        int count;

        for (int i = 0; i < (inputMoney/1000) ; i++) {
            count = 0;
            count = getContainingNumber(computerRandomNumbers, numbers, count, i);

            reflectCountforResult(computerRandomNumbers, bonusNumber, result, count, i);
        }
        return result;
    }

    public int getContainingNumber(List<List<Integer>> computerRandomNumbers, String[] numbers, int count, int i) {
        for (int j = 0; j < 6 ; j++) {
            if (computerRandomNumbers.get(i).contains(Integer.parseInt(numbers[j]))) count++;
        }
        return count;
    }

    private void reflectCountforResult(List<List<Integer>> computerRandomNumbers, int bonusNumber, int[] result, int count, int i) {

        if (count == 3) result[0]++;
        if (count == 4) result[1]++;
        if (count == 5) {
            if (computerRandomNumbers.get(i).contains(bonusNumber)) {
                result[3]++;
            }
            result[2]++;
        }
        if (count == 6) result[4]++;
    }

}
