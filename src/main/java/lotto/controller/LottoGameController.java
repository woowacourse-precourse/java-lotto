package lotto.controller;

import lotto.model.Lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.model.Lotto.*;
import static lotto.view.Input.*;
import static lotto.view.Output.statistics;

public class LottoGameController {

    public void LottoGame(){
        int money = input();

        List<List<Integer>> lottos = Lotto.randomLottoNum(Lotto.lottoNum(money)); // 개수 구하기

        for (List<Integer> lot : lottos) {
            System.out.println(lot);
        }
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> list = prizeNum(readLine()); // 당첨번호
        List<Integer> usersLotto = new Lotto(list).getNumbers();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNum = bonus(Integer.parseInt(readLine()));

        List<Integer> answer = lottoCount(lottos, usersLotto, bonusNum);
        String profile = rate(answer, money);

        statistics(answer, profile);
    }

}
