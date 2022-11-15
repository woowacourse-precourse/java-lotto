package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static lotto.Application.printErrorMessage;

public class WinningNumbers {
    private List<Integer> winningNumbers;


    private int bonusNumber;

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }



    public WinningNumbers(String input) {
        validate(input);
        this.winningNumbers = splitWinningNumbers(input);
    }

    public void pickBonusNumber(String input){
        int bonus=integerCheck(input);
        isInRange(bonus);
        isDuplicated(bonus);
        this.bonusNumber=bonus;

    }

    private void isDuplicated(int bonus) {
        if(winningNumbers.contains(bonus)){
            printErrorMessage("[ERROR] 당첨 번호는 중복되서는 안됩니다.");
            throw new IllegalArgumentException();
        }
    }


    private void validate(String s) {
        StringTokenizer tokenizer = new StringTokenizer(s, ",");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            int number = integerCheck(token);
            isInRange(number);
        }
    }


    private void isInRange(int number) {
        if (number < 1 || number > 45) {
            printErrorMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private int integerCheck(String num) {
        int winNum = 0;
        try {
            winNum = Integer.parseInt(num);
        } catch (NumberFormatException e) {
            printErrorMessage("[ERROR] 숫자 형식으로만 입력해주세요.");
        }
        return winNum;
    }

    private List<Integer> splitWinningNumbers(String s) {
        List<Integer> splitInput = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(s, ",");
        while (tokenizer.hasMoreTokens()) {
            int num = Integer.parseInt(tokenizer.nextToken());
            if (splitInput.contains(num)) {
                printErrorMessage("[ERROR] 당첨 번호는 중복되서는 안됩니다.");
                throw new IllegalArgumentException();
            }
            splitInput.add(num);
        }
        return splitInput;
    }


}
