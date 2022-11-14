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

    public static void confirmRank(List<Lotto> purchaseLottos, Lotto winningLottoNum, int bonus){
        for(Lotto lotto : purchaseLottos){
            int rightNumCnt = howManyRightWinningNum(winningLottoNum, lotto);
            boolean isContainBonus = checkContainBonus(winningLottoNum, bonus);
        }
    }

    public static boolean checkContainBonus(Lotto winningLottoNum, int bonus){
        List<Integer> winningLottoNums = winningLottoNum.getNumber();
        if(winningLottoNums.contains(bonus)) return true;

        return false;
    }

    public static int howManyRightWinningNum(Lotto winningLottoNum, Lotto lotto){
        List<Integer> winningLottoNums = winningLottoNum.getNumber();
        List<Integer> lottoNums = lotto.getNumber();

        lottoNums.retainAll(winningLottoNums);
        int rightNumCnt = lottoNums.size();
        System.out.println("몇개나 맞았나? : " + rightNumCnt);

        return rightNumCnt;
    }
}
