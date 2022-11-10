package view;

import camp.nextstep.edu.missionutils.Console;
import domain.Lotto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class InputLottoNumber {

    public static void inputLottoNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String Lotto = Console.readLine();
        List<Integer> lottoList = setLotto(Lotto);
        Lotto lotto = new Lotto(lottoList);
    }

    private static List<Integer> setLotto(String Lotto) {
        validateNotNumber(Lotto);
        String[] split = Lotto.split(",");
        List<Integer> lottoList = new ArrayList<>();
        for (String s : split) {
            lottoList.add(Integer.parseInt(s));
        }
        return lottoList;
    }

    public static void validateNotNumber(String Lotto) {
        IntStream chars = Lotto.chars();
        if(chars.filter(c -> c!=',').anyMatch(c -> c<'1' || c>'9')){
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 당첨번호 입력오류");
        }

    }

}
