package lotto.service.LottoMachine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LotteryNumbersDraw {
    private static final String SEPARATOR = ",";
    public List<Integer> drawNumbers(String userInput) {
        try {
            String deletedBlankSpaceString = userInput.replaceAll("\\s", "");
            return Arrays.stream(deletedBlankSpaceString.split(SEPARATOR))
                    .map(Integer::parseInt).sorted().collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자와 공백 그리고'" + SEPARATOR + "' 만을 입력해주세요.");
        }
    }

    public int getBonusNumber(int bonus) {
        return bonus;
    }
}
