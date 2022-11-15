package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;

import lotto.domain.Judgment;

public class UserInterFace {
    private static final String NOT_A_INTEGER_ERROR_MESSAGE = "[ERROR] 정수를 입력해야 합니다.";
    private static final String DUPLICATE_BONUS_ERROR_MESSAGE = "[ERROR] 당첨 번호와 중복됩니다.";
    
    public int inputInteger() {
        try {
            String input = Console.readLine();
            int result = Integer.valueOf(input);
            return result;
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException(NOT_A_INTEGER_ERROR_MESSAGE);
        }
    }
    
    public void printLottos(List<List<Integer>> lottos) {
        print(lottos.size() + "개를 구매했습니다.\n");

        for (int index = 0; index < lottos.size(); index++) {
            List<Integer> lotto = lottos.get(index);
            print(lotto.toString() + "\n");
        }
        
        print("\n");
    }
    
    public void print(String text) {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            bufferedWriter.write(text);
            bufferedWriter.flush();
        } catch (IOException error) {
            error.printStackTrace();
        }

    }
    
    public List<Integer> inputWinningNumbers() {
        print("당첨 번호를 입력해 주세요.\n");
        String input = Console.readLine();
        Judgment judgment = new Judgment();
        judgment.check5Commas(input);
        List<String> dividedInput = Arrays.asList(input.split(","));
        List<Integer> numbers = judgment.changeToInteger(dividedInput);
        judgment.checkSize(numbers, 6);
        judgment.checkNumbersRange(numbers, 1, 45);
        return numbers;
    }
    
    public int inputValidBonus(List<Integer> winningNumbers) {
        Judgment judgment = new Judgment();
        int input = inputInteger();
        judgment.checkRange(input, 1, 45);
        
        for (int index = 0; index < winningNumbers.size(); index++) {
            if (winningNumbers.get(index).equals(input)) {
                throw new IllegalArgumentException(DUPLICATE_BONUS_ERROR_MESSAGE);
            }
        }
        
        return input;
    }
}
