package view;

import camp.nextstep.edu.missionutils.Console;
import domain.Lotto;
import java.util.ArrayList;
import java.util.List;

public class InputLottoNumber {

    public static void inputLottoNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String Lotto = Console.readLine();
        String[] split = Lotto.split(",");
        List<Integer> lottoList = new ArrayList<>();
        for (String s : split) {
            lottoList.add(Integer.parseInt(s));
        }
        Lotto lotto = new Lotto(lottoList);
    }

}
