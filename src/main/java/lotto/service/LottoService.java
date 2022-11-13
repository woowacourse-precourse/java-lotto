package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.LottoString;
import lotto.global.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class LottoService {

    public List<Integer> makeRandomNumber(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public int validePrice(String price) {
        IntStream.range(0, price.length()).filter(
                i -> !Character.isDigit(price.charAt(i))).forEach(i -> {
            throw new IllegalArgumentException(LottoString.UNMATCH_PRICE_UNIT);
        });
        int priceInt = Integer.parseInt(price);
        if(priceInt % 1000 != 0){
            throw new IllegalArgumentException(LottoString.UNMATCH_PRICE_UNIT);
        }
        return priceInt;
    }

    public List<Integer> validateUserInput(String userInput) {
        StringTokenizer stringTokenizer = new StringTokenizer(userInput, ",");
        List<Integer> numbers = new ArrayList<>();

        while(stringTokenizer.hasMoreTokens()){
            String nextToken = stringTokenizer.nextToken();
            Integer number = isLottoNumber(nextToken);
            numbers.add(number);
        }
        if(numbers.size() != 6){
            throw new IllegalArgumentException(ErrorMessage.NUMBER_INPUT_ERROR);
        }

        return numbers;
    }

    private Integer isLottoNumber(String number){
        boolean isNumber = number.chars().allMatch(Character::isDigit);
        if(isNumber == false){
            throw new IllegalArgumentException(ErrorMessage.NUMBER_INPUT_ERROR);
        }
        int intNumber = Integer.parseInt(number);
        if(intNumber < 1 || intNumber > 45){
            throw new IllegalArgumentException(ErrorMessage.NUMBER_INPUT_ERROR);
        }
        return intNumber;
    }
}
