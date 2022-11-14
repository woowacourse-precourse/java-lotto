package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class LottoShop {
    private static int purchasePrise;
    private static int lottoCnt;
    public static HashMap<WinningRank, Integer> rankingCnt = new LinkedHashMap<>();

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

    public static HashMap<WinningRank, Integer> confirmRank(List<Lotto> purchaseLottos, Lotto winningLottoNum, int bonus){
        rankInitialization();
        for(Lotto lotto : purchaseLottos){
            int rightNumCnt = howManyRightWinningNum(winningLottoNum, lotto);
            boolean isContainBonus = checkContainBonus(winningLottoNum, bonus);

            WinningRank rank = WinningRank.checkRank(rightNumCnt, isContainBonus);
            rankUpdate(rank);
        }

        return rankingCnt;
    }

    public static void rankUpdate(WinningRank rank){
        rankingCnt.put(rank, rankingCnt.get(rank)+1);
    }
    public static void rankInitialization(){
        for(WinningRank rank : WinningRank.values()){
            rankingCnt.put(rank, 0);
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

        return rightNumCnt;
    }

    public static double totalYield(){
        int benefit = 0;
        for(WinningRank rank : WinningRank.values()){
            int reward = rank.getReward();
            benefit += rankingCnt.get(rank) * reward;
        }

        double benefitPercent = benefit/(double)purchasePrise*100;
        return benefitPercent;
    }
}
