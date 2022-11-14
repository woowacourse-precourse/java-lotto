package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MakeLotto {
    public List<Integer> publishedLotto () {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 6) {
            int num = Randoms.pickNumberInRange(1,45);
            if (!(numbers.contains(num))) {
                numbers.add(num);
            }
        }

        numbers = numbers.stream().sorted().collect(Collectors.toList());
        return numbers;
    }

    public List<List<Integer>> publishedLottos(int n) {
        MakeLotto makeLotto = new MakeLotto();
        List<List<Integer>> answer = new ArrayList<>();
        for (int i =0; i < n; i++) {
            answer.add(makeLotto.publishedLotto());
        }

        return answer;
    }
}
