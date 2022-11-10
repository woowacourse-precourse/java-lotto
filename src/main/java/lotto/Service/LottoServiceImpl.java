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
        System.out.println("구입금액을 입력해 주세요.");
        this.priceValidate(price);
        int cnt = price / 1000;
        System.out.println(cnt+"개를 구매했습니다.");
        lottos = new ArrayList<>();
        while(lottos.size() < cnt){
            lottos.add(new Lotto(generateRandomNum(6)));
        }

    }

    @Override
    public void generateLottos() {
        System.out.println("당첨 번호를 입력해 주세요");
        ansLotto = new Lotto(generateRandomNum(6));
        System.out.println("보너스 번호를 입력해 주세요");
        bonus = new BonusLotto(generateRandomNum(1).get(0));
    }

    @Override
    public List<Integer> generateRandomNum(int count) {
       return Randoms.pickUniqueNumbersInRange(1, 45, count);
    }

    @Override
    public String calcLotto() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("당첨 통계");
        stringBuilder.append("---");

        return stringBuilder.toString();
    }
}
