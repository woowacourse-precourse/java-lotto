package lotto;

import java.util.*;
import java.text.NumberFormat;
import java.lang.IllegalArgumentException;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

enum ranking {
    FIRST, SECOND, THIRD, FOURTH, FIFTH, SIXTH
}
public class Application {
    static int inputmoney;
    static int lottoNum;
    static final int lottoLength = 6; //로또 길이 상수
    static final int lottoMin = 1; //로또 번호 최소값
    static final int lottoMax = 45; //로또 번호 최대값
    static List<Lotto> lottoList;
    static List<Integer> hitNumber;
    static int bonus;
    static List<Integer> countHitList;
    static HashMap<ranking, Integer> lottoRankInfo;
    static final HashMap<ranking, Integer> cashPrizeInfo = new HashMap<>() {{
        put(ranking.FIRST, 2000000000);
        put(ranking.SECOND, 30000000);
        put(ranking.THIRD, 1500000);
        put(ranking.FOURTH, 50000);
        put(ranking.FIFTH, 5000);
        put(ranking.SIXTH, 0);
    }};

    static int castInt(String str){
        int num = 0;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException ex){
            throw new IllegalArgumentException(); //Error message 추후 수정
        }
        return num;
    }

    static int singleNumberInput(){
        int inputNum = castInt(Console.readLine());
        return inputNum;
    }

    static List<Integer> createLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(lottoMin, lottoMax, lottoLength);
        Collections.sort(numbers);
        return numbers;
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

    static List<String> parsingStringInput(){
        String hitString = Console.readLine();
        List<String> hitStringParsed = Arrays.asList(hitString.split(","));
        return hitStringParsed;
    }

    static List<Integer> multiNumberInput(){
        List<String> stringParsed = parsingStringInput();
        List<Integer> multiNumberList = new ArrayList<>(lottoNum);
        for (int i = 0; i < lottoLength; i++) {
            multiNumberList.add(castInt(stringParsed.get(i)));
        }
        return multiNumberList;
    }

    static HashMap<ranking, Integer> initRankInfo(){
        HashMap<ranking, Integer> lottoRankInfo = new HashMap<>(ranking.values().length);
        for (ranking RANK : ranking.values()){
            lottoRankInfo.put(RANK, 0);
        }
        return lottoRankInfo;
    }

    static void printResult(HashMap<ranking, Integer> lottoRankInfo){
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.println("3개 일치 (5,000원) - " + lottoRankInfo.get(ranking.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoRankInfo.get(ranking.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoRankInfo.get(ranking.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoRankInfo.get(ranking.SECOND) + "개");
        System.out.println("6개 일치, 보너스 볼 일치 (2,000,000,000원) - " + lottoRankInfo.get(ranking.FIRST) + "개");
    }

    static int howMuchPrize(HashMap<ranking, Integer> lottoRankInfo){
        int cashprize = 0;
        for (Map.Entry<ranking, Integer> entry : lottoRankInfo.entrySet()){
            cashprize += entry.getValue() * cashPrizeInfo.get(entry.getKey());
        }
        return cashprize;
    }

    static void printEarningRate(int cashprize, int inputmoney){
        System.out.printf("총 수익률은 %.1f%%입니다", (double)cashprize / inputmoney);
    }

    public static void main(String[] args) {
        System.out.println("구매금액을 입력해주세요");
        inputmoney = singleNumberInput();
//        inputmoney = 8000;

        lottoNum = inputmoney / 1000;
        System.out.println(lottoNum + "개를 구매했습니다.");

        lottoList = createLottoList(lottoNum);
        printLottoList(lottoList);

        System.out.println("당첨 번호를 입력해주세요.");
        hitNumber = multiNumberInput();
//        hitNumber = Arrays.asList(1,2,3,4,5,6);

        System.out.println("보너스 번호를 입력해주세요.");
        bonus = singleNumberInput();
//        bonus = 7;

        lottoRankInfo = initRankInfo();
        printResult(lottoRankInfo);
        printEarningRate(howMuchPrize(lottoRankInfo), inputmoney);
    }
}
