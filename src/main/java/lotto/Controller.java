package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Controller {
    public int getCount(int money) {
        int count = 0;
        if (money % 1000 != 0) {
            System.out.println("[ERROR] 1,000원 단위가 아닙니다.");
            throw new IllegalArgumentException();
        }
        count = money / 1000;
        return count;
    }

    public List<Integer>[] issueLotto(int count) {
        List<Integer>[] issuedList = new List[count];
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            issuedList[i] = numbers;
        }
        return issuedList;
    }

    public Lotto issueWinningNumber(List<Integer> numbers) {
        Lotto winningLotto = new Lotto(numbers);
        return winningLotto;
    }
}
