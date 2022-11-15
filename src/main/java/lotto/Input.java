package lotto;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    private String input;
    public void purchaseAmount(){
        System.out.println(LottoPrint.purchaseAmount.getDescription());
        this.input =readLine();
        purchaseAmountValidation(input);
    }

    public void winningNumber(){
        System.out.println(LottoPrint.winningNumbers.getDescription());
        this.input = readLine();
        lottoInputValidation(input);
    }

    public void bonusNumber(List<Integer> numbers){
        System.out.println(LottoPrint.bonusNumber.getDescription());
        this.input = readLine();
        bonusInputValidation(this.input, numbers);
    }


    public String getInput() {
        return input;
    }

    public static void purchaseAmountValidation(String purchaseAmount) {
        if (!purchaseAmount.matches("[0-9]+")){
            throw new IllegalArgumentException(ErrorPrint.purchaseAmount.getErrorMessage());
        }
    }

    public static void lottoInputValidation(String lottoInput) {
        if (!lottoInput.matches("[0-9,]+")){
            throw new IllegalArgumentException(ErrorPrint.lottoInput.getErrorMessage());
        }
    }

    public static void bonusInputValidation(String bonusInput, List<Integer> numbers) {
        int bonusNumber = Integer.parseInt(bonusInput);
        if (!bonusInput.matches("[0-9]")){
            throw new IllegalArgumentException(ErrorPrint.bonusNumber.getErrorMessage());
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorPrint.bonusNumber.getErrorMessage());
        }
        if (numbers.contains(bonusNumber)){
            throw new IllegalArgumentException(ErrorPrint.bonusNumber.getErrorMessage());
        }
    }
}
