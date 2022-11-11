package lotto.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.validation.WinningValidation;

public class BonusInput extends Input {
    private final WinningValidation validation = new WinningValidation();
    private String input;
    // 당첨 번호 입력을 List<Integer> 형태로 가져오기 필요
    private List<Integer> winnings;

    @Override
    public String getInput() {
        input = readLine();
        winnings = new ArrayList<>();
        validation.isValidBonus(input, winnings);
        return input;
    }
}