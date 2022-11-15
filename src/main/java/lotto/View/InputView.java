package lotto.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private final String INPUT_DRAW_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";

    private final Validation validation;

    public InputView() {
        this.validation = new Validation();
    }

    public int inputMoney(){
        System.out.println(INPUT_MONEY_MESSAGE);
        String input = Console.readLine();
        if(validation.validatePurchase(input)){
            return Integer.parseInt(input);
        }
        return 0;
    }

    public List<Integer> inputDraw() {
        System.out.println(INPUT_DRAW_MESSAGE);
        List<String> input = Arrays.asList(Console.readLine().replace(" ", "").split(","));
        String joinInput = String.join("", input);
        validation.validateIsNumber(joinInput);
        List<Integer> draw = input.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return draw;
    }

    public int inputBonus() {
        System.out.println(INPUT_BONUS_MESSAGE);
        String input = Console.readLine().replace(" ", "");
        validation.validateIsNumber(input);
        return Integer.parseInt(input);
    }
}
