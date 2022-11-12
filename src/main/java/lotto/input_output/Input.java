package lotto.input_output;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    /*
### Input

- [ ] Lotto 당첨 번호 입력받기 List<Integer>로 반환
- [ ] 보너스 번호 입력받기
- [ ] User 구매 금액 입력받기

     */
    protected static List<Integer> returnList(){ //Lotto 당첨 번호 입력받기 List<Integer>로 반환
        String[] input  = Console.readLine().split(",");
        return Arrays.stream(input).mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());
    }

}
