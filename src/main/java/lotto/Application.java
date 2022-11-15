package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;
import java.text.NumberFormat;
import java.lang.IllegalArgumentException;
import java.lang.Exception;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import net.bytebuddy.pool.TypePool;

enum ranking {
    FIRST, SECOND, THIRD, FOURTH, FIFTH, SIXTH
}

enum ErrorMessage {
    INVALID_NOTANUMBER("Input is not a number"),
    INVALID_INPUTARGSNUM("Invalid number of input arguments"),
    INVALID_DUPLICATED("Input has Duplicated number"),
    INVALID_1000X("Input value is not a multiple of 1000");
    final private String ErrMes;
    public String print(){
        return ErrMes;
    }
    private ErrorMessage(String ErrMes){
        this.ErrMes = "[ERROR] "+ ErrMes;
    }
}
public class Application {
    static int inputmoney;
    static int lottoNum;
    static final int lottoLength = 6; //로또 길이 상수
    static final int lottoMin = 1; //로또 번호 최소값
    static final int lottoMax = 45; //로또 번호 최대값
    static List<Lotto> lottoList;
    static final int hitNum = 6;
    static List<Integer> hitNumbers;
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
            System.out.println(ErrorMessage.INVALID_NOTANUMBER.print());
        }
        return num;
    }

    static int singleNumberInput(){
        int inputNum = castInt(Console.readLine());
        return inputNum;
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
    static void printLottoList(List<Lotto> lottoList){
        for (Lotto lotto : lottoList)
            lotto.print();
    }

    static List<String> parsingStringInput(int maxArgc){
        String hitString = Console.readLine();
        List<String> hitStringParsed = Arrays.asList(hitString.split(","));
        if (hitStringParsed.size() != maxArgc)
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUTARGSNUM.print());
        return hitStringParsed;
    }

    static List<Integer> multiNumberInput(int maxArgc){
        List<String> stringParsed = parsingStringInput(maxArgc);
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

    static HashMap<ranking, Integer> getResult(HashMap<ranking, Integer> lottoRankInfo, List<Lotto> lottoList, List<Integer> hitNumber, int bonus){
        ranking RANK;
        for (Lotto lotto : lottoList) {
            RANK = lotto.countHit(hitNumber, bonus);
            lottoRankInfo.replace(RANK, lottoRankInfo.get(RANK) + 1);
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
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoRankInfo.get(ranking.FIRST) + "개");
    }

    static int howMuchPrize(HashMap<ranking, Integer> lottoRankInfo){
        int cashprize = 0;
        for (Map.Entry<ranking, Integer> entry : lottoRankInfo.entrySet()){
            cashprize += entry.getValue() * cashPrizeInfo.get(entry.getKey());
        }
        return cashprize;
    }

    static void printEarningRate(int cashprize, int inputmoney){
        System.out.printf("총 수익률은 %.1f%%입니다.\n", (double)cashprize / inputmoney*100);
    }

    static void handleNotDividedBy1000(int inputmoney){
        if (inputmoney % 1000 != 0)
            throw new IllegalArgumentException(ErrorMessage.INVALID_1000X.print());
    }
    public static void main(String[] args) {
        System.out.println("구매금액을 입력해주세요");
        inputmoney = singleNumberInput();
        //        inputmoney = 8000;
        handleNotDividedBy1000(inputmoney);

        lottoNum = inputmoney / 1000;
        System.out.println(lottoNum + "개를 구매했습니다.");

        lottoList = createLottoList(lottoNum);
        printLottoList(lottoList);

        System.out.println("당첨 번호를 입력해주세요.");
        hitNumbers = multiNumberInput(hitNum);
        //        hitNumber = Arrays.asList(1,2,3,4,5,6);

        System.out.println("보너스 번호를 입력해주세요.");
        bonus = singleNumberInput();
        //        bonus = 7;

        lottoRankInfo = initRankInfo();
        lottoRankInfo = getResult(lottoRankInfo, lottoList, hitNumbers, bonus);
        printResult(lottoRankInfo);
        printEarningRate(howMuchPrize(lottoRankInfo), inputmoney);
    }
}
