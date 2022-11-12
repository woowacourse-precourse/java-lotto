package lotto;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
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
        winningNumber = new ArrayList<>();
        bonusNumber = new ArrayList<>();
    }
    public void createWinningNumber(){
        String lottoNumberString = Console.readLine();

    }
    public List<Integer> splitLottoInput(String lottoNumbers){
        String[] splitInput = lottoNumbers.split(",");
        isValidLength(splitInput, REQUIRE_LOTTO_NUMBER_COUNT.getValue());
        isAllDigit(splitInput);
        List<Integer> splitNumber = convertSplitInput(splitInput);
        isValidRange(splitNumber);
        isNoDuplicate(splitNumber);
        return splitNumber;
    }
    private void isValidLength(String[] splitInput, int testLength){
           if(splitInput.length!=testLength){
               throw new IllegalArgumentException("ERROR : ,로 분리되는 인자의 수가 잘못됐습니다");
           }
    }
    private void isAllDigit(String[] splitInput){
        for(String number : splitInput){
            if(!number.chars().allMatch(Character::isDigit)){
                throw new IllegalArgumentException("ERROR : 분리된 문자열이 숫자가 아닙니다.");
            }
        }
    }
    private List<Integer> convertSplitInput(String[] splitInput){
        List<Integer> splitNumber = new ArrayList<>();
        for(String number : splitInput){
            splitNumber.add(Integer.parseInt(number));
        }
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
