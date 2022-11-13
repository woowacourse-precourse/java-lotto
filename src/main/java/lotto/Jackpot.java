package lotto;

import static lotto.util.InputImport.*;

public class Jackpot {

    public static void input_jackpot_number(){
        jackpot_number_output_and_validate(ReadLine());
    }

    private static void jackpot_number_output_and_validate(String jackpot_number){

        if (!Validation.jackpot_number_validation(jackpot_number)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        System.out.println("\n"+jackpot_number);
    }

}
