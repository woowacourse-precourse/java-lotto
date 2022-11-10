package lotto.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoResult {
    public List<Integer> inputLottoNumber(){
        System.out.println("당첨번호를 입력해 주세요.");
        String lottoNumberInput=readLine();
        List<String> numbers = Stream.of(lottoNumberInput.split(",")).collect(Collectors.toList());
        List<Integer> lottoNumber=new ArrayList<>();
        for (String s : numbers) {
            lottoNumber.add(Integer.parseInt(s));
        }
        Lotto lotto = new Lotto(lottoNumber);
        return lottoNumber;
    }
}
