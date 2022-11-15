package lotto.controller;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.Lotto.*;
import static lotto.view.Input.*;

public class LottoGameController {

    public void LottoGame(){
        int money = input();

        //Lotto lotto = new Lotto();
        List<List<Integer>> lottos = new ArrayList<List<Integer>>();
        ArrayList<Integer> prize = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        lottos = Lotto.makeLotto(Lotto.lottoNum(money)); // 개수 구하기

        for (List<Integer> lot : lottos) {
            System.out.println(lot);
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> list = prizeNum(readLine()); // 당첨번호
        List<Integer> usersLotto = new Lotto(list).getNumbers();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNum = bonus(Integer.parseInt(readLine()));

        List<Integer> answer = statistics(lottos, usersLotto, bonusNum);
        int sum = statisticsFinal(answer);

        rate(sum, money);
/*
        for(int n = 0; n < num; n++){
            lotto = createLotto();
            System.out.println(lotto.toString());
            lottos.add(lotto);
        }
        //System.out.println("lotts: " + lottos.toString());

        prize = prizeNum(); // 당첨번호 + 보너스 리스트
        //System.out.println("prize: " + prize.toString());

        result = statistics(lottos, prize);
        int sum = statisticsFinal(result);
        rate(sum, num);
*/
    }

}
