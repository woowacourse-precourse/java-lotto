package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoShop {
    private static int purchasePrise;
    private static int lottoCnt;

    public LottoShop(int purchasePrise){
        this.purchasePrise = purchasePrise;
        this.lottoCnt = purchasePrise/1000;
    }

    public static Lotto createLotto(){
        List<Integer> newLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        // 오름차순 정렬
        Arrays.stream(newLotto.toArray()).sorted().collect(Collectors.toList());

        // 입력한 로또 번호를 Lotto 인스턴스를 생성해 저장
        return new Lotto(newLotto);
    }
    
    public static List<Lotto> publishLotto(){
        List<Lotto> newLottos = new ArrayList<>();

        for(int i=0; i<lottoCnt; i++){
            newLottos.add(createLotto());
        }

        return newLottos;
    }
}
