package lotto.datamodel.util;

import java.util.ArrayList;
import java.util.List;

public class Transform {
    public Transform() {
    }

    public List<Integer> numberTransform(String input) {
        List<Integer> winNumbers;
        try {
            String[] numbers = input.split(",");
            winNumbers = new ArrayList<>();
            for (String number : numbers) {
                winNumbers.add(Integer.parseInt(number));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 입력값은 ','와 숫자로 입력해야합니다.");
        }
        return winNumbers;
    }

    public int bonusTransform(String input) {
        int bonus;
        try{
            bonus = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
        return bonus;
    }
}
