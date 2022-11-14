package lotto.domain.jackpot;

import lotto.domain.lotto.Lotto;
import lotto.domain.random.PickNumber;
import lotto.validation.Validation;

import static lotto.util.InputImport.*;

public class Jackpot {

    public static String jackpot_number_static;

    public static String bonus_number_static;

    public static void input_jackpot_number(){
        System.out.println("당첨 번호를 입력해 주세요.");
        jackpot_number_static = ReadLine();
        jackpot_number_output_and_validate(jackpot_number_static);
    }

    public static void jackpot_number_output_and_validate(String jackpot_number){

        if (!Validation.jackpot_number_validation(jackpot_number)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 하며 6자리를 입력해야합니다.");
        }

        input_bonus_number();
    }

    public static void input_bonus_number(){
        System.out.println("\n"+"보너스 번호를 입력해주세요.");
        bonus_number_static=ReadLine();
        bonus_number_output_and_validate(bonus_number_static);
    }

    public static void bonus_number_output_and_validate(String bonus_number){

        if (!Validation.bonus_number_validation(bonus_number)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45사이의 숫자여야하며 당첨번호와는 겹쳐선 안됩니다.");

        }
        compare_jackpot_and_lotto();
    }

    public static void compare_jackpot_and_lotto(){
        JackpotResult jr=new JackpotResult();
        Lotto.compare_prepare(PickNumber.get_purchased_lotto_list(),jackpot_number_static,bonus_number_static,jr);
    }
}