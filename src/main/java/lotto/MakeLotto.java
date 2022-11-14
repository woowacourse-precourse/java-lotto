package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MakeLotto {
    public List<Integer> lottoNumber ;
    public int lottoBonusNumber ;
    private String splitTag =",";
    public MakeLotto(){
        System.out.println("당첨 번호를 입력해 주세요.");
        lottoNumber = new ArrayList<>(
                Arrays.asList(Console.readLine().split(splitTag)).stream()
                        .map(s -> Integer.parseInt(s))
                        .collect(Collectors.toList())

        );
        System.out.println("보너스 번호를 입력해 주세요.");
        lottoBonusNumber = Integer.valueOf(Console.readLine());
    }

}
