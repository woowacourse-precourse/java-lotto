package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import static lotto.Lotto.lottoNum;
import static lotto.Lotto.randomLottoNum;

public class LottoGameController {

    public void LottoGame(){
        int num = lottoNum();
        List<Integer> lotto = new ArrayList<>();

        for(int n = 0; n < num; n++){
            lotto = randomLottoNum();
            System.out.println(lotto.toString());

        }

    }
}
