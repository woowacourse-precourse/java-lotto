package view;

import camp.nextstep.edu.missionutils.Console;
import constant.ErrorMessage;
import java.util.List;

public class InputBonusNumber {

    static int bonus;
    public static void inputBonusNumber(){
        System.out.println("보너스 번호를 입력해주세요.");
        String inputBonusNumber = Console.readLine();
        validateBonusNumber(inputBonusNumber);
    }

    public static int validateBonusNumber(String inputBonusNumber){
        int bonusNumber=0;
        bonusNumber = convertInteger(inputBonusNumber);

        isInRange(bonusNumber);

        isBonusNumberInWinningList(bonusNumber);

        return bonusNumber;
    }

    private static int convertInteger(String inputBonusNumber) {
        int bonusNumber;
        try{
           bonusNumber = Integer.parseInt(inputBonusNumber);
       }
       catch (Exception e){
           throw new IllegalArgumentException(ErrorMessage.ERROR_BONUS_NOTNUMBER.getMessage());
       }
        return bonusNumber;
    }

    private static void isInRange(int bonusNumber) {
        if(bonusNumber <1 || bonusNumber >45){
            throw new IllegalArgumentException(ErrorMessage.ERROR_BONUS_OVERRANGE.getMessage());
        }
    }

    public static void isBonusNumberInWinningList(int bonusNumber) {
        List<Integer> lottoList = InputWinningLottoNumber.getWinningLottoList();
        int rightBonusNumber = bonusNumber;
        if(lottoList.stream().anyMatch(n -> rightBonusNumber == n)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_BONUS_DUPLICATE_WINNING.getMessage());
        }
    }

    public static int getBonus() {
        return bonus;
    }
}
