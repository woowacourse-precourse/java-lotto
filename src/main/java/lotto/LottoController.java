package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public void startLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validate(input);
        int money = Integer.parseInt(input);
        int count = money / 1000;
        System.out.println(count + "개를 구매했습니다.");
        List<Lotto> lottos = makeLotto(count);
        for (int i=0;i<count;i++){
            System.out.println(lottos.get(i).getNumbers());

        }
    }

    public List<Lotto> makeLotto(int count){
        List <Lotto> lottos = new ArrayList<>();
        for (int i=0;i<count;i++){
            Lotto lotto = new Lotto(createRandomNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }

    public boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public void validate(String input) {
        if (!isNumeric(input)){
            throw new IllegalArgumentException();
        }
        int money = Integer.parseInt(input);
        if (money%1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> createRandomNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
