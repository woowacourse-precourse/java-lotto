package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoMachine {
    private final int LOTTO_PRICE = 1000;
    private int paid;
    private ArrayList<Lotto> lottos = new ArrayList<>();

    public LottoMachine() {}

    public void getInputMoney(){
        System.out.println("구입 금액을 입력해 주세요");
        int money = Integer.parseInt(Console.readLine());
        validateMoney(money);
        this.paid = Integer.parseInt(Console.readLine());
    }

    private void validateMoney(int money){
        if(money % LOTTO_PRICE != 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요");
        }
    }

    public List<Lotto> createLottoNumber(){
        int cnt = paid / LOTTO_PRICE;
        for(int i=0; i<cnt; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        paid = 0;
        return lottos;
    }


}
