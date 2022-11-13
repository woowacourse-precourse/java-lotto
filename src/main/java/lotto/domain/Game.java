package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {

    // 로또 구입금액 입력
    public int insertMoney(){
        System.out.println("구입 금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());

        return money;
    }

    public int buyLotto(int money){
        if (money % 1000 > 0){  // 천원단위로 나누어 떨어지지 않을 경우 예외처리
            throw new IllegalArgumentException("[ERROR] 금액이 잘못되었습니다.");
        }
        int lottoCount = money / 1000;
        return lottoCount;
    }

    public List<Lotto> createLotto(int lottoCount){
        LottoAutoMachine lottoAutoMachine = new LottoAutoMachine();
        List<Lotto> lottoBought = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++){
            Lotto lotto = new Lotto(lottoAutoMachine.pickNumbers());
            lottoBought.add(lotto);
        }
        return lottoBought;
    }

}
