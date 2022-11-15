package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;

public class LottoUser {
    private long money;
    private final long initMoney;
    private LottoSystem lottoSystem;

    private List<Lotto> lottos;
    private List<WinInfo> winInfomations;

    public LottoUser(long money, LottoSystem lottoSystem) {
        validate(money);
        this.money = money;
        this.initMoney = money;
        this.lottoSystem = lottoSystem;
        this.lottos = new ArrayList<>();
        this.winInfomations = new ArrayList<>();
    }

    private void validate(long money){
        if(money < 0){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 0이상이여야 합니다");
        }
        if(money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 나누어 떨어져야 합니다.");
        }
    }

    public void buyLotto(){
        while(this.money >= Lotto.PRICE){
            money -= Lotto.PRICE;
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
            this.lottos.add(new Lotto(numbers));
        }
    }

    //소유한 모든 로또의 결과 확인 후 반환
    public List<WinInfo> checkWin(){
        this.winInfomations.clear();
        for(Lotto lotto : this.lottos){
            this.winInfomations.add(lottoSystem.judgeWin(lotto));
        }
        return this.winInfomations;
    }

    public List<Lotto> getLottos(){
        return this.lottos;
    }


    //소유한 모든 로또의 결과 반환
    public List<WinInfo> getWinInfomations(){
        return this.winInfomations;
    }

    //수익률 반환
    public double getReturnRate(){
        long sum = 0;
        for(WinInfo winInfo : this.winInfomations){
            sum += winInfo.getWinMoney();
        }
        return (double)sum / this.initMoney;
    }

    //소유한 로또의 당첨 통계 반환
    public Map<WinInfo,Integer> getStatistics() {
        return WinInfo.getStatistics(this.winInfomations);
    }
}
