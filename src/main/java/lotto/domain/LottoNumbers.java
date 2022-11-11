package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.Exceptions;

public class LottoNumbers {
    private List<Integer> lottoNumbers;

    public List<Integer> convertStringArrToIntegerList(String numbers) {
        return List.of(numbers.split(",")).stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    public List<Integer> createRandomNumbers(){
        List<Integer> numbers = new ArrayList<>();
        try{
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        }catch(IllegalArgumentException e){
            System.out.println("[ERROR]");
            throw new IllegalArgumentException();
        }
        return numbers;
    }

}
