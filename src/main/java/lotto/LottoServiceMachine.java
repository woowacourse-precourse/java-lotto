package lotto;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;




import static constant.LottoNumber.MAX_LOTTO_NUMBER;
import static constant.LottoNumber.MIN_LOTTO_NUMBER;
import static constant.LottoNumber.REQUIRE_LOTTO_NUMBER_COUNT;
import static constant.LottoNumber.AVAIL_BONUS_NUMBER_COUNT;
public class LottoServiceMachine {


    private List<Integer> winningNumber;
    private List<Integer> bonusNumber;

    public LottoServiceMachine(){
    }
    public String toString(){

        System.out.println(winningNumber);
        System.out.println(bonusNumber);
        return null;
    }
    public void getWinningLottoNumber(){
        winningNumber = getWinningNumberByCount(REQUIRE_LOTTO_NUMBER_COUNT.getValue());
        bonusNumber = getWinningNumberByCount(AVAIL_BONUS_NUMBER_COUNT.getValue());
    }
    public List<Integer> getWinningNumberByCount(int requireCount){
        String lottoNumberString = Console.readLine();
        List<Integer> splitWinningNumber = splitLottoInput(lottoNumberString, requireCount);
        return splitWinningNumber;
    }
    public List<Integer> splitLottoInput(String lottoNumbers, int requireCount){
        String[] splitInput = lottoNumbers.split(",");
        StringConverter.isValidLength(splitInput, requireCount);
        StringConverter.isAllDigit(splitInput);
        List<Integer> splitNumber = StringConverter.convertToIntegerL(splitInput);
        isValidRange(splitNumber);
        isNoDuplicate(splitNumber);
        return splitNumber;
    }


    private void isValidRange(List<Integer> splitNumber){
        for(Integer number : splitNumber){
            if(number<MIN_LOTTO_NUMBER.getValue() || number>MAX_LOTTO_NUMBER.getValue())
                throw new IllegalArgumentException("ERROR : 로또 번호의 범위가 "
                        +MIN_LOTTO_NUMBER.getValue()+" ~ "
                        +MAX_LOTTO_NUMBER.getValue()+"를 벗어났습니다.");
        }
    }
    private void isNoDuplicate(List<Integer> splitNumber){
        HashSet<Integer> hashsetNumber = new HashSet<>(splitNumber);
        if(hashsetNumber.size() != splitNumber.size()){
            throw new IllegalArgumentException("Error : 중복되는 숫자가 있습니다.");
        }
    }
}
