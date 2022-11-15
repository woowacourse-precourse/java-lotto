package lotto;
import lotto.Constant.Ranking;
import lotto.Constant.ErrorMessage;
import lotto.Validate.HandleException;
import lotto.Input.Input;

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

//    static int singleNumberInput(){
//        int inputNum = castInt(Console.readLine());
//        return inputNum;
//    }

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
    static void printLottoList(List<Lotto> lottoList){
        for (Lotto lotto : lottoList)
            lotto.print();
    }

//    static List<String> parsingStringInput(int maxArgc){
//        String hitString = Console.readLine();
//        List<String> hitStringParsed = Arrays.asList(hitString.split(","));
//
//        HandleException.InputArgsNum(hitStringParsed, maxArgc);
//        return hitStringParsed;
//    }
//
//    static List<Integer> multiNumberInput(int maxArgc){
//        List<String> stringParsed = parsingStringInput(maxArgc);
//        List<Integer> multiNumberList = new ArrayList<>(lottoNum);
//        for (int i = 0; i < lottoLength; i++) {
//            multiNumberList.add(castInt(stringParsed.get(i)));
//        }
//
//        HandleException.DuplicatedNum(multiNumberList);
//        return multiNumberList;
//    }

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

    static void printResult(HashMap<Ranking, Integer> lottoRankInfo){
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.println("3개 일치 (5,000원) - " + lottoRankInfo.get(Ranking.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoRankInfo.get(Ranking.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoRankInfo.get(Ranking.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoRankInfo.get(Ranking.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoRankInfo.get(Ranking.FIRST) + "개");
    }

    static int howMuchPrize(HashMap<Ranking, Integer> lottoRankInfo){
        int cashprize = 0;
        for (Map.Entry<Ranking, Integer> entry : lottoRankInfo.entrySet()){
            cashprize += entry.getValue() * cashPrizeInfo.get(entry.getKey());
        }
        return cashprize;
    }

    static void printEarningRate(int cashprize, int inputmoney){
        System.out.printf("총 수익률은 %.1f%%입니다.\n", (double)cashprize / inputmoney*100);
    }

    public static int getlottoNum(){
        return lottoNum;
    }

    public static void main(String[] args) {
        System.out.println("구매금액을 입력해주세요");
        inputmoney = Input.singleNumber();
        //        inputmoney = 8000;
//        handleNotDividedBy1000(inputmoney);
        HandleException.NotDividedBy1000(inputmoney);


        lottoNum = inputmoney / 1000;
        System.out.println(lottoNum + "개를 구매했습니다.");

        lottoList = createLottoList(lottoNum);
        printLottoList(lottoList);

        System.out.println("당첨 번호를 입력해주세요.");
        hitNumbers = Input.multiNumber(hitNum);
        //        hitNumber = Arrays.asList(1,2,3,4,5,6);

        System.out.println("보너스 번호를 입력해주세요.");
        bonus = Input.singleNumber();
        //        bonus = 7;

        lottoRankInfo = initRankInfo();
        lottoRankInfo = getResult(lottoRankInfo, lottoList, hitNumbers, bonus);
        printResult(lottoRankInfo);
        printEarningRate(howMuchPrize(lottoRankInfo), inputmoney);
    }
}
