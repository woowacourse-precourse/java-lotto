package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto extends Lotto {
    private int bounusNumber;

    public WinningLotto(List<Integer> game, int bounusNumber) {
        super(game);
        super.validateRange(bounusNumber);
        this.bounusNumber = bounusNumber;
    }

    public int getBounusNumber() {
        return bounusNumber;
    }

    public List<Integer> createNumbers(String input){
        try {
            return Arrays.stream(input.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        } catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 입력값은 숫자만 입력되어야합니다.");
        }
    }
}
