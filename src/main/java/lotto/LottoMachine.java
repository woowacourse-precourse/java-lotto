package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.LottoConst.LOTTO_NUMBER_COUNT;
import static lotto.LottoConst.LOTTO_PRICE;

public class LottoMachine {
    static int userMoney;
    static int lottoCount;
    static Map<Rank, Integer> rankCount = new HashMap<>();

    LottoMachine(int userMoney){
        Error.purchasePrice(userMoney);

        this.userMoney = userMoney;
        this.lottoCount = userMoney / LOTTO_PRICE;
    }

    static Lotto createLotto(){
        List<Integer> newLotto;
        newLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Arrays.stream(newLotto.toArray())
                .sorted()
                .collect(Collectors.toList());

        return new Lotto(newLotto);
    }

    static List<Lotto> createLottos(){
        List<Lotto> newLottos = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++){
            newLottos.add(createLotto());
        }
        return newLottos;
    }

    static int howMachWithWinningNumber(Lotto winningLotto, Lotto lotto){
        List<Integer> winningLottoList = winningLotto.getNumbers();
        List<Integer> lottoList = lotto.getNumbers();

        List<Integer> mergeLottoNumbers = mergeList(winningLottoList, lottoList);
        Set<Integer> LottoNumbersSet = new HashSet<>(mergeLottoNumbers);

        return LOTTO_NUMBER_COUNT*2 - LottoNumbersSet.size();
    }

    static List<Integer> mergeList(List<Integer> list1, List<Integer> list2){
        List<Integer> mergeList = new ArrayList<>();
        Collections.addAll(mergeList, list1.toArray(new Integer[0]));
        Collections.addAll(mergeList, list2.toArray(new Integer[0]));

        return mergeList;
    }

    static void initRank(){
        for(Rank rank : Rank.values()){
            rankCount.put(rank,0);
        }
    }

    static void updateRank(Rank rank) {
        rankCount.put(rank, rankCount.get(rank) + 1);
    }

}
