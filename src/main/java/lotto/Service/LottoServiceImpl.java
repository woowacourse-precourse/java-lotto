package lotto.Service;

import lotto.Model.*;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoServiceImpl implements LottoService{

    private final List<Lotto> lottos;
    private BonusLotto bonus;
    private Lotto ansLotto;
    private final Map<String, Integer> lottosMap;
    private final Profit profit;
    private Cash cash;
    public LottoServiceImpl(){
        this.lottos = new ArrayList<>();
        this.lottosMap = new HashMap<>();
        this.profit = new Profit();
    }

    @Override
    public void buyLottos() {
        System.out.println("구입금액을 입력해 주세요.");
        cash = new Cash(readLine());
        if(cash.getLottoCnt() == 0) return;
        System.out.println(cash.getLottoCnt()+"개를 구매했습니다.");
        while(lottos.size() < cash.getLottoCnt()){
            List <Integer> lotto = generateRandomNum(6).stream().sorted().collect(Collectors.toList());
            lottos.add(new Lotto(lotto));
            System.out.println(lotto);
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
    public void printResult() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("당첨 통계 \n");
        stringBuilder.append("--- \n");
        lottos.forEach(this::calcLottos);
        for(Rank rank : Rank.values()){
            stringBuilder.append(Rank.getGradeForDisplay(rank.toString())).append(" - ").append(lottosMap.getOrDefault(rank.toString(), 0)).append("개\n");
        }
        stringBuilder.append("총 수익률은 ").append(profit.getProfits(cash.getMoney())).append("%입니다.");
        System.out.println(stringBuilder);
    }

    @Override
    public void calcLottos(Lotto lotto) {
        int count = (int) lotto.getNumbers().stream().filter(o -> ansLotto.getNumbers().stream().anyMatch(Predicate.isEqual(o))).count();
        int bouns_cnt = (int) lotto.getNumbers().stream().filter(o -> o.equals(bonus.getNum())).count();
        if(!Rank.getGrade(count,bouns_cnt).equals("NONE")){
            int money = Rank.valueOf(Rank.getGrade(count,bouns_cnt)).getMoney();
            profit.setMoney(profit.getMoney() + money);
            lottosMap.put(Rank.getGrade(count,bouns_cnt),lottosMap.getOrDefault(Rank.getGrade(count,bouns_cnt),0)+1);
        }
    }

    @Override
    public boolean isPlay() {
        return this.lottos.size() > 0;
    }
}
