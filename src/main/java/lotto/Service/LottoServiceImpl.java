package lotto.Service;

import lotto.Model.BonusLotto;
import lotto.Model.Lotto;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoServiceImpl implements LottoService{

    private List<Lotto> lottos;
    private BonusLotto bonus;
    private Lotto ansLotto;

    @Override
    public void priceValidate(int price) {
        if(price % 1000 != 0) throw new IllegalArgumentException("[ERROR] 로또 구입 가격은 1000으로 나누어 떨어져야 합니다.");
    }

    @Override
    public void buyLottos() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = Integer.parseInt(readLine());
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
        String ans_nums = readLine();
        ansLotto = new Lotto(Arrays.stream(ans_nums.split(","))
                                    .map(Integer::parseInt)
                                    .collect(Collectors.toList()));
        System.out.println("보너스 번호를 입력해 주세요");
        String bonus_num = readLine();
        bonus = new BonusLotto(Integer.parseInt(bonus_num));
    }

    @Override
    public List<Integer> generateRandomNum(int count) {
       return Randoms.pickUniqueNumbersInRange(1, 45, count);
    }

    @Override
    public String printResult() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("당첨 통계 \n");
        stringBuilder.append("--- \n");
        lottos.stream().map(this::calcLottos).forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    @Override
    public String calcLottos(Lotto lotto) {
        return lotto.toString();
    }
}
