package lotto.service.LottoMachine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LotteryNumbersDraw {
    private final String inputDrawNumbers;
    private List<Integer> drawNumbers;
    private static final String SEPARATOR = ",";

    public LotteryNumbersDraw(String inputDrawNumbers) {
        this.inputDrawNumbers = inputDrawNumbers;
    }

    public void setDrawNumbers() {
        try {
            String deletedBlankSpaceString = inputDrawNumbers.replaceAll("\\s", "");
            this.drawNumbers = Arrays.stream(deletedBlankSpaceString.split(SEPARATOR))
                    .map(Integer::parseInt).sorted().collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자와 공백 그리고'" + SEPARATOR + "' 만을 입력해주세요.");
        }
    }

    public List<Integer> getDrawNumbers() {
        return this.drawNumbers;
    }

    public int getBonusNumber(int bonus) {
        return bonus;
    }
}
