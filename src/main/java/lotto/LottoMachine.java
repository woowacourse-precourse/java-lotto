package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LottoMachine {

    private List<Integer> winningNumber = new ArrayList<>();

    public List<Lotto> buyLotto(int money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money / 1000; i++) {
            lottos.add(createLotto());
        }

        return lottos;
    }
    public Lotto createLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public void setWinningNumber() {
        String input = Console.readLine();

    }

    private void checkWiningNumber(String input) {
        StringTokenizer st = new StringTokenizer(input, ",");
        if(st.countTokens() != 6)
            throw new IllegalArgumentException("[ERROR] 6개의 수를 입력해야 합니다.");
    }




}
