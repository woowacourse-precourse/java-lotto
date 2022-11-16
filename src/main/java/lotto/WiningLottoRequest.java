package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WiningLottoRequest {

    public List<Integer> winningNumber(String input) {

        List<String> lottoNumber = new ArrayList<String>(Arrays.asList(input.split(",")));
        List<Integer> intLottoNumber;

        //중복 숫자 제거, 문자열 입력 오류 반환
        try{
            intLottoNumber = lottoNumber.stream()
                    .map(s -> Integer.parseInt(s))
                    .collect(Collectors.toList());
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return intLottoNumber.stream().sorted().collect(Collectors.toList());

    }

    public int bonusNumber(String Input) {
        try{
            Integer.parseInt(Input);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(Input);
    }

}
