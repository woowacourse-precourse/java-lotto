package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Lotto> lottos = new ArrayList<>();
    private List<Integer> winningNumber;
    private Integer bonusNumber;

    public User(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void inputWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] numbers = Console.readLine().split(",");
        for(String num: numbers){
            winningNumber.add(Integer.parseInt(num));
        }
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = Integer.parseInt(Console.readLine());

    }

}
