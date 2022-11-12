package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class UserLotto {

    private final List<Integer> winNumbers;
    private final int bonusNumber;

    public UserLotto(String winNumbers, String bonusNumber) {
        this.winNumbers = List.copyOf(mapToList(winNumbers));
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private List<Integer> mapToList(String winNumbers) {
        return Arrays.stream(winNumbers.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

}
