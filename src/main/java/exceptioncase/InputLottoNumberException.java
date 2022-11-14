package exceptioncase;

import java.util.Arrays;
import java.util.List;
import constant.ConstantLottoProgram;
public class InputLottoNumberException {
    public static boolean exceptionsTest(String inpnut){
        if(isFitness(inpnut))
            return true;
        return ConstantLottoProgram.ERROR_CODE.isErrorState();
    }
    public static boolean bonusNumberTest(String bonusNumber,List<Integer> answerNumbers){
        bonusNumber = bonusNumber.replaceAll("[^\\d]", "");
        if(bonusNumber.equals("")){
            System.out.println("[ERROR] 입력형식이 틀렸습니다.");
            return ConstantLottoProgram.ERROR_CODE.isErrorState();
        }
        int numericBonusNumber = Integer.parseInt(bonusNumber);
        if(numericBonusNumber>ConstantLottoProgram.RANGE_OF_LOTTO_NUMBER.getMax() ||
                numericBonusNumber<ConstantLottoProgram.RANGE_OF_LOTTO_NUMBER.getMin()){
            System.out.println("[ERROR] 1이상 45이하 숫자를 입력해주세요.");
            return ConstantLottoProgram.ERROR_CODE.isErrorState();
        }
        if(answerNumbers.contains(numericBonusNumber)){
            System.out.println("[ERROR] 기존 당첨번호와 중복입니다.");
            return ConstantLottoProgram.ERROR_CODE.isErrorState();
        }
            return true;
    }
    private static boolean isFitness(String input){
        if(input.replaceAll("[^\\d+,+\\d+,+\\d+,+\\d+,+\\d+,+\\d]","").length() != input.length()){
            System.out.println("[ERROR] 입력형식이 틀렸습니다.");
            return ConstantLottoProgram.ERROR_CODE.isErrorState();
        }
        return islength(input);
    }
    private static boolean islength(String input){
        String[] inputNumbers = input.split(",");
        if(inputNumbers.length != ConstantLottoProgram.LOTTO_LENGTH.getLength()){
            System.out.println("[ERROR] 숫자를 6개만 입력해주세요.");
            return ConstantLottoProgram.ERROR_CODE.isErrorState();
        }
        return isOverlapAndValue(inputNumbers);
    }
    private static boolean isOverlapAndValue(String[] inputNumbers){
        Arrays.sort(inputNumbers);
        for(int i=0; i<inputNumbers.length-1; i++){
            if(inputNumbers[i].equals(inputNumbers[i+1])){
                System.out.println("[ERROR] 중복된 숫자가 있습니다.");
                return ConstantLottoProgram.ERROR_CODE.isErrorState();
            }
        }
        if(Integer.parseInt(inputNumbers[0])<ConstantLottoProgram.RANGE_OF_LOTTO_NUMBER.getMin()){
            System.out.println("[ERROR] 1 이상의 숫자를 입력해주세요.");
            return ConstantLottoProgram.ERROR_CODE.isErrorState();
        }
        if(Integer.parseInt((inputNumbers[inputNumbers.length-1]))>ConstantLottoProgram.RANGE_OF_LOTTO_NUMBER.getMax()){
            System.out.println("[ERROR] 45 이하의 숫자를 입력해주세요.");
            return ConstantLottoProgram.ERROR_CODE.isErrorState();
        }
        return true;
    }
}
