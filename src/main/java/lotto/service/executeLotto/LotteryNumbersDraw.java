package lotto.service.executeLotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LotteryNumbersDraw {
    // userInput 3, 5, 7, 8, 19, 36
    // string 에서 불필요한 띄어쓰기는 제거하고 값을 받기
    private final String userInput;

    public LotteryNumbersDraw(String userInput) {
        this.userInput = userInput;
    }

    public List<Integer> drawNumbers() {
        String deletedBlankSpaceString = userInput.replaceAll("\\s", "");
        return Arrays.stream(deletedBlankSpaceString.split(","))
                .map(Integer::parseInt).sorted().collect(Collectors.toList());
    }

    public int getBonusNumber(int bonus) {
        return bonus;
    }
}
