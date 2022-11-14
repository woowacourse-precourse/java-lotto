package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.utils.Messages.ERROR_MESSAGE;

public class LottoNumber {

    public static List<Integer> createLotto(){
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return numbers;
    }

    public static List<Integer> winningNumberToList(String input){
        List<Integer> winningNumberList = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return winningNumberList;
    }

    public static boolean validateDuplicateBonusNumber(Lotto lotto, int bonusNumber){
        try{
            validateDuplicateNumber(lotto, bonusNumber);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static void validateDuplicateNumber(Lotto lotto, int bonusNumber){
        List<Integer> lottoNumber = lotto.getLottoNumber();
        if(lottoNumber.contains(bonusNumber)){
            throw new IllegalArgumentException(ERROR_MESSAGE + "보너스 넘버가 중복됩니다.");
        }
    }

}
