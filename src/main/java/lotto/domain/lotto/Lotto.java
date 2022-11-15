package lotto.domain.lotto;

import lotto.domain.jackpot.JackpotResult;
import lotto.domain.prize.PrizeResult;
import lotto.util.ResultOutput;

import java.util.Arrays;
import java.util.List;
//예기치 못한 오류 테스트 커밋
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validate_duplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수가 여섯개가 아닙니다.");
        }
    }

    private void validate_duplication(List<Integer> numbers) {
        for (int i=0;i<numbers.size()-1;i++){
            int check_now = numbers.get(i);
            if(duplication_check(numbers,check_now,i)){
                throw new IllegalArgumentException("[ERROR] 로또 번호에 중복이 존재해선 안됩니다.");
            }
        }
    }

    private static boolean duplication_check(List<Integer> numbers,int check_now,int index){
        for (int i=0;i<numbers.size();i++){
            if (check_now==numbers.get(i)&&index!=i){
                return true;
            }
        }
        return false;
    }

    public static void compare_prepare(List<List<Integer>> purchased_lotto,
                                                String jackpot_number,
                                                        String bonus_number,
                                                                JackpotResult jr){

        for (List<Integer> one_of_lotto : purchased_lotto) {
            Lotto lotto = new Lotto(one_of_lotto);
            compare_list_to_list(lotto, jackpot_number, bonus_number,jr);
        }
        ResultOutput.all_result_output();
    }

    public static void compare_list_to_list(Lotto lotto, String jackpot_number
                                                    ,String bonus_number,JackpotResult jr){
        List<String> jackpot_number_list= Arrays.asList(jackpot_number.split(","));
        List<Integer> lotto_list = lotto.numbers;

        for (String jackpot : jackpot_number_list) {
            compare_jackpot_number(Integer.parseInt(jackpot), lotto_list,jr);
        }
        if (jr.return_jackpot_count()!=6){
            compare_bonus_number(Integer.parseInt(bonus_number),lotto_list,jr);
        }
        int hit_jk = jr.return_jackpot_count();
        int hit_bn = jr.return_bonus_count();
        PrizeResult.prize_set_by_count(hit_jk,hit_bn);
        jr.reset_count();
    }

    public static void compare_jackpot_number(int jackpot, List<Integer> lotto_list,
                                                                        JackpotResult jr){
        for (Integer lotto_num : lotto_list) {
            if (jackpot == lotto_num) {
                jr.hit_jackpot();
                break;
            }
        }
    }

    public static void compare_bonus_number(int bonus,List<Integer> lotto_list,
                                                                    JackpotResult jr){
        if (lotto_list.contains(bonus)){
            jr.hit_bonus();
        }
    }
}