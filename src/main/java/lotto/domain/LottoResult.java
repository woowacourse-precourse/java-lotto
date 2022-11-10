package lotto.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoResult {
    public List<Integer> inputLottoNumber(){
        System.out.println("당첨번호를 입력해 주세요.");
        String lottoNumber=readLine();
        List<String> numbers = Stream.of(lottoNumber.split(",")).collect(Collectors.toList());
        List<Integer> lotto=new ArrayList<>();
        for (String s : numbers) {
            lotto.add(Integer.parseInt(s));
        }
        return lotto;
    }
}
