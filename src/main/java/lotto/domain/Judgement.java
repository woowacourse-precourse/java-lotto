package lotto.domain;

import lotto.UserInput;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Judgement {
    public int compare (List<Integer> lottos, List<Integer> userLotto, int bonus) {
        List<Integer> result = lottos
                .stream()
                .filter(value -> userLotto.stream().anyMatch(Predicate.isEqual(value)))
                .collect(Collectors.toList());

        if (lottos.contains(bonus) && result.size() == 5) {
            return 51;
        }
        return result.size();
    }
}
