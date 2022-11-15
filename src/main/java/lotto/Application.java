package lotto;
import lotto.Constant.Ranking;
import lotto.Constant.ErrorMessage;
import lotto.Validate.HandleException;
import lotto.Input.Input;
import lotto.Output.Print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    static int inputmoney;
    static int lottoNum;
    public static final int lottoLength = 6; //로또 길이 상수
    static final int lottoMin = 1; //로또 번호 최소값
    static final int lottoMax = 45; //로또 번호 최대값
    static List<Lotto> lottoList;
    static final int hitNum = 6;
    static List<Integer> hitNumbers;
    static int bonus;
    static List<Integer> countHitList;
    static HashMap<Ranking, Integer> lottoRankInfo;
    static final HashMap<Ranking, Integer> cashPrizeInfo = new HashMap<>() {{
        put(Ranking.FIRST, 2000000000);
        put(Ranking.SECOND, 30000000);
        put(Ranking.THIRD, 1500000);
        put(Ranking.FOURTH, 50000);
        put(Ranking.FIFTH, 5000);
        put(Ranking.SIXTH, 0);
    }};

    static int castInt(String str){
        int num = 0;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException ex){
            System.out.println(ErrorMessage.INVALID_NOTANUMBER.print());
        }
        return num;
    }

    static List<Integer> createLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(lottoMin, lottoMax, lottoLength);
        List<Integer> sorted = new ArrayList<>(numbers);
        sorted.sort(Comparator.naturalOrder());

        return sorted;
    }

    static List<Lotto> createLottoList(int lottoNum){
        List<Lotto> lottoList = new ArrayList<>(lottoNum);
        for (int lottoIndex = 0; lottoIndex < lottoNum; lottoIndex++) {
            lottoList.add(new Lotto(createLotto()));
        }
        return lottoList;
    }

    static HashMap<Ranking, Integer> initRankInfo(){
        HashMap<Ranking, Integer> lottoRankInfo = new HashMap<>(Ranking.values().length);
        for (Ranking RANK : Ranking.values()){
            lottoRankInfo.put(RANK, 0);
        }
        return lottoRankInfo;
    }

    static HashMap<Ranking, Integer> getResult(HashMap<Ranking, Integer> lottoRankInfo, List<Lotto> lottoList, List<Integer> hitNumber, int bonus){
        Ranking RANK;
        for (Lotto lotto : lottoList) {
            RANK = lotto.countHit(hitNumber, bonus);
            lottoRankInfo.replace(RANK, lottoRankInfo.get(RANK) + 1);
        }
        return lottoRankInfo;
    }


    static int howMuchPrize(HashMap<Ranking, Integer> lottoRankInfo){
        int cashprize = 0;
        for (Map.Entry<Ranking, Integer> entry : lottoRankInfo.entrySet()){
            cashprize += entry.getValue() * cashPrizeInfo.get(entry.getKey());
        }
        return cashprize;
    }


    public static int getlottoNum(){
        return lottoNum;
    }

    public static void main(String[] args) {
        System.out.println("구매금액을 입력해주세요");
        inputmoney = Input.singleNumber();
        HandleException.NotDividedBy1000(inputmoney);

        lottoNum = inputmoney / 1000;
        System.out.println(lottoNum + "개를 구매했습니다.");

        lottoList = createLottoList(lottoNum);
        Print.LottoList(lottoList);

        System.out.println("당첨 번호를 입력해주세요.");
        hitNumbers = Input.multiNumber(hitNum);

        System.out.println("보너스 번호를 입력해주세요.");
        bonus = Input.singleNumber();

        lottoRankInfo = initRankInfo();
        lottoRankInfo = getResult(lottoRankInfo, lottoList, hitNumbers, bonus);
        Print.Result(lottoRankInfo);
        Print.EarningRate(howMuchPrize(lottoRankInfo), inputmoney);
    }
}
