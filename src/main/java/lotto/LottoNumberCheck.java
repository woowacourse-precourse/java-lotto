package lotto;

import java.util.*;

public class LottoNumberCheck {
    public enum Hi {
        FiVE("3개 일치 (5,000원)"),
        FOUR("4개 일치 (50,000원)"),
        THREE("5개 일치 (1,500,000원)"),
        TWO("5개 일치, 보너스 볼 일치 (30,000,000원)"),
        ONE("6개 일치 (2,000,000,000원)");

        final private String hi;

        private String getHi() {
            return hi;
        }

        Hi(String hi) {
            this.hi = hi;
        }
    }

    public enum Bye {
        FIVE(5_000),
        FOUR(50_000),
        THREE(1_500000),
        TWO(30_000000),
        ONE(2_000000000);

        final private int bye;

        private int getBye() {
            return bye;
        }

        Bye(int bye) {
            this.bye = bye;
        }
    }

    private static Map<String, Integer> correctNumber; // 당첨 번호를 저장할 Map
    private static Map<List<Integer>, Integer> checkLotto;
    private static List<Integer> countPrizeNumber; // 당첨 번호 갯수 (3개이상 맞춘 것만) 저장하는 List
    private static Map<String, Integer> mapTest;  // 3개이상 맞춘 것들만 모아서 몇 장인지 저장하는 Map

    private static List<Integer> myPrizeMoney; // 당첨금을 다 합친다.
    private int myMoney = 0;

    public LottoNumberCheck() {
        correctNumber = new LinkedHashMap<>();
        checkLotto = new LinkedHashMap<>();
        countPrizeNumber = new ArrayList<>();
        mapTest = new LinkedHashMap<>();
        myPrizeMoney = new ArrayList<>();
    }
    private void initPrize(Map<String, Integer> mapTest) {
        for (Hi value : Hi.values()) {
            mapTest.put(value.getHi(), 0);
        }
    }


    public void compareWinNumberWithMyLotto(List<List<Integer>> lottoNumbers, List<Integer> winNumber, int bonusBall) {
        initPrize(mapTest);

        myMoney = lottoNumbers.size(); // 내가 입력한 금액 ( 8000 )
        System.out.println(myMoney);
        saveOneOrMoreMatchLotto(lottoNumbers, winNumber, bonusBall); // 로또들 저장 ( 몇 개 일치했는지 다 저장 )
        countWinningLotto(correctNumber); // 당첨된 로또들만 저장
    }

    // 로또 번호, winNumber랑 로또랑 비교해서 몇 개 일치하는지 저장하는 메서드

    private void saveOneOrMoreMatchLotto(List<List<Integer>> randomLottoNumbers, List<Integer> winNumber, int bonusBall) {
        for (int i = 0; i < randomLottoNumbers.size(); i++) {
            for (int j = 0; j < randomLottoNumbers.get(i).size(); j++) {
                compareMyLottoNumberWithWinNumber(randomLottoNumbers, i, j, winNumber);
            }
        }
        compareMyLottoNumberWithBonusNumber(checkLotto, correctNumber, bonusBall);
    }

    private void compareMyLottoNumberWithWinNumber(List<List<Integer>> randomLottoNumbers, int i, int j, List<Integer> winNumber) {
        if (randomLottoNumbers.get(i).contains(winNumber.get(j))) {
            checkLotto.put(randomLottoNumbers.get(i), checkLotto.getOrDefault(randomLottoNumbers.get(i), 0) + 1);
            correctNumber.put(randomLottoNumbers.get(i).toString(), correctNumber.getOrDefault(randomLottoNumbers.get(i).toString(), 0) + 1);
        }
    }
    // 5개 이상 맞춘 로또들 중에 보너스 번호가 맞았는지 안 맞았는지 체크하는 메서드

    private void compareMyLottoNumberWithBonusNumber(Map<List<Integer>, Integer> checkLotto, Map<String, Integer> correctNumber, int bonusBall) {
        for (List<Integer> integers : checkLotto.keySet()) {
            if (checkLotto.get(integers) == 5 && integers.contains(bonusBall)) {
                correctNumber.put(integers.toString(), 7);
            }
        }
    }
    // 3개 이상 맞춘 로또들이 몇 개인지 저장하는 것이다.

    private void countWinningLotto(Map<String, Integer> correctNumber) {
        for (String s : correctNumber.keySet()) {
            if (correctNumber.get(s) >= 3) {
                countPrizeNumber.add(correctNumber.get(s));
            }
        }
    }
    public void comparePrizeMoneyWithMyPrizeLotto() {
        getPrizeMoney(countPrizeNumber);
        calculateYield(myMoney, myPrizeMoney);
    }
    // mapTest 변수명 수정하기

    private void getPrizeMoney(List<Integer> countPrizeNumber) {
        for (Integer integer : countPrizeNumber) {
            for (Prize value : Prize.values()) {
                countPrizeMoneyOfMyLotto(integer, value);
            } // 3개 이상 맞춘 것만 정렬해서 출력후 몇 장인지 구하는 과정
        }
        combinePrizeMoney(mapTest);

        System.out.println("당첨 통계");
        System.out.println("---");
        for (String s : mapTest.keySet()) {
            System.out.print(s);
            System.out.print(" - " + mapTest.get(s) + "개");
            System.out.println();
        }
    }

    private void combinePrizeMoney(Map<String, Integer> mapTest) {
        for (String s : mapTest.keySet()) {
            myPrizeMoney.add(mapTest.get(s));
        }
    }

    private void countPrizeMoneyOfMyLotto(int integer, Prize value) {
        if (integer == 7 && value.getPrize().substring(1, 6).equals("개 일치,")) {
            mapTest.put(value.getPrize(), mapTest.getOrDefault(value.getPrize(), 0) + 1);
        } else if (integer != 7 && value.getPrize().substring(0, 5).equals(integer + "개 일치")){
            mapTest.put(value.getPrize(), mapTest.getOrDefault(value.getPrize(), 0) + 1);
        }
    }






    private void calculateYield(int myMoney, List<Integer> myPrizeMoney) {
        myMoney = myMoney * 1000;

        int count = 0;
        int total = 0;
        for (Bye value : Bye.values()) {
            total += value.getBye() * myPrizeMoney.get(count);
            count++;
        }
        double add = ((double) total / myMoney) * 100;
        add = Math.round(add*10)/10.0;
        System.out.println("총 수익률은 " + add + "%입니다.");
    }
}
