package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.ValidationInView;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    private final ValidationInView validator = new ValidationInView();

    public int getPurchaseAmount(){
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
        String input = Console.readLine();
        validator.checkNumericValue(input);
        return Integer.parseInt(input);
    }

    public List<Integer> getWinningNumbers(){
        System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);
        String line = Console.readLine();
        List<String> inputs = parse(line);
        validator.checkNumericValueList(inputs);
        return convertToIntegerFromString(inputs);
    }

    private List<Integer> convertToIntegerFromString(List<String> inputs){
        List<Integer> outputs = new ArrayList<>();
        for(String input : inputs){
            outputs.add(Integer.parseInt(input));
        }
        return outputs;
    }

    private List<String> parse(String line){
        String values[] = line.split(",");
        List<String> inputs = new ArrayList<>();
        for(int i = 0; i < values.length; i++){
            inputs.add(values[i].trim());
        }
        return inputs;
    }

    public int getBonusNumber(){
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        String input = Console.readLine();
        validator.checkNumericValue(input);
        return Integer.parseInt(input);
    }

}
