package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import static lotto.Lotto.lottoNum;
import static lotto.Lotto.randomLottoNum;
import static lotto.view.Input.prizeNum;

public class LottoGameController {

    public void LottoGame(){
        int num = lottoNum();
        List<Integer> lotto = new ArrayList<>();
        List<List<Integer>> lottos = new ArrayList<List<Integer>>();
        ArrayList<Integer> prize = new ArrayList<>();

        for(int n = 0; n < num; n++){
            lotto = randomLottoNum();
            System.out.println(lotto.toString());
            lottos.add(lotto);
        }
        System.out.println("lotts: " + lottos.toString());

        prize = prizeNum(); // 당첨번호 + 보너스 리스트
        System.out.println("prize: " + prize.toString());

    }
}
