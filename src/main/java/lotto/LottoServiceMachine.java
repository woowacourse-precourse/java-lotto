package lotto;
import camp.nextstep.edu.missionutils.Console;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;


import constant.PrizeMoney;
import static constant.LottoNumber.*;
import static constant.RequireCorrectNumber.*;
import static constant.PrizeMoney.*;
public class LottoServiceMachine {


    private List<Integer> winningNumber;
    private List<Integer> bonusNumber;

    public LottoServiceMachine(){
    }
    @Override
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
        InputUtility.isValidLength(splitInput, requireCount);
        InputUtility.isAllDigit(splitInput);
        List<Integer> splitNumber = InputUtility.convertToIntegerList(splitInput);
        isValidLottoRange(splitNumber);
        InputUtility.testNoDuplicate(splitNumber);
        return splitNumber;
    }
    private void isValidLottoRange(List<Integer> splitNumber){
        for(Integer number : splitNumber){
            if(number<MIN_LOTTO_NUMBER.getValue() || number>MAX_LOTTO_NUMBER.getValue())
                throw new IllegalArgumentException("[ERROR] 로또 번호의 범위가 "
                        +MIN_LOTTO_NUMBER.getValue()+" ~ "
                        +MAX_LOTTO_NUMBER.getValue()+"를 벗어났습니다.");
        }
    }
    private void isNormalNumberInBonusNumber(){
        for(Integer number : bonusNumber){
            if(winningNumber.contains(number)){
                throw new IllegalArgumentException("[ERROR] 보너스 번호가 기존 당첨번호와 중복됩니다.");
            }
        }
    }
    public void putInLottoToMachine(List<Lotto> buyerLottos){
        HashMap<String,Integer> prizeCount = new HashMap<>(){{
            put("FIRST",0);
            put("SECOND",0);
            put("THIRD",0);
            put("FOURTH",0);
            put("FIFTH",0);
        }};
        int inputMoney = buyerLottos.size()*LOTTO_PRICE.getValue();
        int prizeMoney = 0;

        for(Lotto lotto : buyerLottos){
            String prize = whatLottoPrize(lotto);
            if(prize.equals("")){
                continue;
            }
            prizeCount.put(prize,prizeCount.get(prize)+1);
            prizeMoney += PrizeMoney.valueOf( prize+"_MONEY").getValue();
        }
        double gainRatio = (double)prizeMoney*100/inputMoney;

        printPrizes(prizeCount);
        System.out.println(String.format("총 수익률은 %.1f%%입니다.",gainRatio));
    }
    private void printPrizes(HashMap<String,Integer> prizeCount){
        System.out.println(String.format("3개 일치 (%,d원) - %d개",FIFTH_MONEY.getValue(),prizeCount.get("FIFTH")));
        System.out.println(String.format("4개 일치 (%,d원) - %d개",FOURTH_MONEY.getValue(),prizeCount.get("FOURTH")));
        System.out.println(String.format("5개 일치 (%,d원) - %d개",THIRD_MONEY.getValue(),prizeCount.get("THIRD")));
        System.out.println(String.format("5개 일치, 보너스 볼 일치 (%,d원) - %d개",SECOND_MONEY.getValue(),prizeCount.get("SECOND")));
        System.out.println(String.format("6개 일치 (%,d원) - %d개",FIRST_MONEY.getValue(),prizeCount.get("FIRST")));
    }
    public String whatLottoPrize(Lotto lottoNumber){
        List<Integer> numbers = lottoNumber.getLottoNumber();
        int normalMatchCount = 0;
        int bonusMatchCount = 0;

        for(Integer number : numbers){
            if(winningNumber.contains(number)){
                normalMatchCount++;
            }
            if(bonusNumber.contains(number)){
                bonusMatchCount++;
            }
        }
        if(normalMatchCount == FIRST_CORRECT.getValue()){
            return "FITST";
        }
        if(normalMatchCount == SECOND_CORRECT.getValue() && bonusMatchCount == 1){
            return "SECOND";
        }
        if(normalMatchCount == THIRD_CORRECT.getValue()){
            return "THIRD";
        }
        if(normalMatchCount == FOURTH_CORRECT.getValue()){
            return "FOURTH";
        }
        if(normalMatchCount == FIFTH_CORRECT.getValue()){
            return "FIFTH";
        }
        return "";
    }

}
