package exceptioncase;

import java.util.Arrays;
import java.util.List;
import constant.ConstantLottoProgram;
public class InputLottoNumberException {
    public static void exceptionsTest(String inpnut){
        isFitness(inpnut);
    }
    public static void bonusNumberTest(String bonusNumber,List<Integer> answerNumbers){
        bonusNumber = bonusNumber.replaceAll("[^\\d]", "");
        if(bonusNumber.equals(""))
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        int numericBonusNumber = Integer.parseInt(bonusNumber);
        if(numericBonusNumber>ConstantLottoProgram.RANGE_OF_LOTTO_NUMBER.getMax() ||
                numericBonusNumber<ConstantLottoProgram.RANGE_OF_LOTTO_NUMBER.getMin())
            throw new IllegalArgumentException("[ERROR] 1이상 45이하 숫자를 입력해주세요.");
        if(answerNumbers.contains(numericBonusNumber))
            throw new IllegalArgumentException("[ERROR] 기존 당첨번호와 중복입니다.");
    }
    private static void isFitness(String input){
        if(input.replaceAll("[^\\d+,+\\d+,+\\d+,+\\d+,+\\d+,+\\d]","").length() != input.length())
            throw  new IllegalArgumentException("[ERROR] 입력형식이 틀렸습니다.");
        islength(input);
    }
    private static void islength(String input){
        String[] inputNumbers = input.split(",");
        if(inputNumbers.length != ConstantLottoProgram.LOTTO_LENGTH.getLength())
            throw new IllegalArgumentException("[ERROR] 숫자를 6개만 입력해주세요.");
        isOverlapAndValue(inputNumbers);
    }
    private static void isOverlapAndValue(String[] inputNumbers){
        Arrays.sort(inputNumbers);
        for(int i=0; i<inputNumbers.length-1; i++){
            if(inputNumbers[i].equals(inputNumbers[i+1]))
                throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
        if(Integer.parseInt(inputNumbers[0])<ConstantLottoProgram.RANGE_OF_LOTTO_NUMBER.getMin())
            throw new IllegalArgumentException("[ERROR] 1 이상의 숫자를 입력해주세요.");
        if(Integer.parseInt((inputNumbers[inputNumbers.length-1]))>ConstantLottoProgram.RANGE_OF_LOTTO_NUMBER.getMax())
            throw new IllegalArgumentException("[ERROR] 45 이하의 숫자를 입력해주세요.");
    }
}
