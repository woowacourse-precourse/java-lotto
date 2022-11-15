package lotto;

import java.util.HashSet;
import java.util.List;

public class validations {

    private static final int LOTTO_PRICE = 1_000;
    private static final int LOTTO_LENGTH = 6;


    // 구입 금액의 유효성을 체크하는 함수
    public static void checkCostValid(String cost){
        // 숫자로 입력했는지, 아니면 Exception
        try{
            long temp = Long.parseLong(cost);
        }
        catch(Exception e){
            Error.NOT_NUMERIC_ERROR.wrongInput();
        }
        // 1000단위가 아닌 경우
        if (Long.parseLong(cost) % LOTTO_PRICE != 0){
            Error.COST_ERROR.wrongInput();
        }
    }

    // 로또 번호 6자리 검증 함수
    public static void checkLength(List<Integer> numbers){
        if (numbers.size() != LOTTO_LENGTH){
            Error.LOTTO_LENGTH_ERROR.wrongInput();
        }
    }

    // 로또 번호 중복 체크 함수
    public static void checkDuplication(List<Integer> numbers){
        HashSet<Integer> checkDuplicate = new HashSet<Integer>();
        for (int n : numbers){
            if(!checkDuplicate.add(n)){
                Error.LOTTO_NUM_DUPLICATE_ERROR.wrongInput();
            }
        }
    }

    // 보너스 번호가 숫자인지 확인
    public static void checkBonusNumberIsNumeric(String bonusNumber){
        try{
            int temp = Integer.parseInt((bonusNumber));
        }
        catch (IllegalArgumentException e){
            Error.NOT_NUMERIC_ERROR.wrongInput();
        }
    }

    // 보너스 번호가 중복으로 입력 됐는지 확인
    public static void checkBonusNumberDuplicate(int bonusNumber, List numbers){
        if(numbers.contains(bonusNumber)){
            Error.LOTTO_NUM_DUPLICATE_ERROR.wrongInput();
        }
    }
    
    // 로또 번호가 1~45를 벗어났는지 확인
    public static void checkNumberRange(int number){
        if (number<1 || number>45){
            Error.RANGE_ERROR.wrongInput();
        }
    }

}
