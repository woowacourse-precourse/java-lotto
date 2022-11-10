package lotto.Service;

import lotto.Model.BonusLotto;
import lotto.Model.Lotto;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoServiceImpl implements LottoService{

    private List<Lotto> lottos;
    private BonusLotto bonus;
    private Lotto ansLotto;

    @Override
    public void priceValidate(int price) {
        if(price % 1000 != 0) throw new IllegalArgumentException("[ERROR] 로또 구입 가격은 1000으로 나누어 떨어져야 합니다.");
    }

    @Override
    public void buyLottos(int price) {
        this.priceValidate(price);
        int cnt = price / 1000;
        lottos = new ArrayList<>();
        while(lottos.size() < cnt){
            lottos.add(new Lotto(generateRandomNum(6)));
        }

    }

    @Override
    public void generateLottos() {
        ansLotto = new Lotto(generateRandomNum(6));
        bonus = new BonusLotto(generateRandomNum(1).get(0));
    }

    @Override
    public List<Integer> generateRandomNum(int count) {
       return Randoms.pickUniqueNumbersInRange(1, 45, count);
    }
}
