package lotto;

import java.util.*;

public class Manager {
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

    private int myMoney = 0;
    private static Map<String, Integer> correctNumber; // 당첨 번호를 저장할 Map
    private static Map<List<Integer>, Integer> checkLotto;
    private static List<Integer> countPrize; // 당첨 번호 갯수 (3개이상 맞춘 것만) 저장하는 List
    private static Map<String, Integer> mapTest;  // 3개이상 맞춘 것들만 모아서 몇 장인지 저장하는 Map

    public Manager() {
        correctNumber = new LinkedHashMap<>();
        checkLotto = new LinkedHashMap<>();
        countPrize = new ArrayList<>();
        mapTest = new LinkedHashMap<>();
    }

    // 로또 번호, winNumber랑 로또랑 비교해서 몇 개 일치하는지 저장하는 메서드
    private void saveLotto(List<List<Integer>> randomLottoNumbers, List<Integer> winNumber) {
        for (int i = 0; i < randomLottoNumbers.size(); i++) {
            for (int j = 0; j < randomLottoNumbers.get(i).size(); j++) {
                checkNumber(randomLottoNumbers, i, j, winNumber);
            }
        }
        for (List<Integer> integers : checkLotto.keySet()) {
            System.out.println("checkLotto.keySet() = " + integers);
        }
    }

    private void checkNumber(List<List<Integer>> randomLottoNumbers, int i, int j, List<Integer> winNumber) {
        if (randomLottoNumbers.get(i).contains(winNumber.get(j))) {
            checkLotto.put(randomLottoNumbers.get(i), checkLotto.getOrDefault(randomLottoNumbers.get(i), 0) + 1);
//                    System.out.println("numbers.get(i) = " + numbers.get(i));
            correctNumber.put(randomLottoNumbers.get(i).toString(), correctNumber.getOrDefault(randomLottoNumbers.get(i).toString(), 0) + 1);
        }
    }

    // 5개 이상 맞춘 로또들 중에 보너스 번호가 맞았는지 안 맞았는지 체크하는 메서드
    private void checkBonus(Map<List<Integer>, Integer> checkLotto, Map<String, Integer> correctNumber, int bonusBall) {
        for (List<Integer> integers : checkLotto.keySet()) {
            System.out.println("integersTest = " + integers);
            System.out.println("winnerMa123123123p = " + checkLotto.get(integers));
            if (checkLotto.get(integers) == 5 && integers.contains(bonusBall)) {
                System.out.println("integersBonusBall = " + integers);
                correctNumber.put(integers.toString(), 7);
            }
        }
    }

    // 3개 이상 맞춘 로또들이 몇 개인지 저장하는 것이다.
    private void checkPrize(Map<String, Integer> correctNumber) {
        for (String s : correctNumber.keySet()) {
            if (correctNumber.get(s) >= 3) {
                countPrize.add(correctNumber.get(s));
            }
        }
    }

    // mapTest 변수명 수정하기
    private void compareLastValue(List<Integer> countPrize, Map<String, Integer> mapTest) {
        for (Integer integer : countPrize) {
            for (Hi value : Hi.values()) {
                System.out.println("hi : "+value.getHi());
                System.out.println(integer);
                if (integer == 7 && value.getHi().substring(1, 6).equals("개 일치,")) {
                    System.out.println("test : " + value.getHi().substring(0, 5));
                    System.out.println("test2 : " + integer + "개 일치");
                    mapTest.put(value.getHi(), mapTest.getOrDefault(value.getHi(), 0) + 1);
                } else if (value.getHi().substring(0, 5).equals(integer + "개 일치")){
                    System.out.println("안녕하세요");
                    mapTest.put(value.getHi(), mapTest.getOrDefault(value.getHi(), 0) + 1);
                }
            } // 3개 이상 맞춘 것만 정렬해서 출력후 몇 장인지 구하는 과정
        }
    }

    public void inputWinNumbers(List<List<Integer>> numbers, List<Integer> winNumber, int bonusBall) {
//        int count = 0;
        for (Hi value : Hi.values()) {
            mapTest.put(value.getHi(), 0);
        }
        myMoney = numbers.size(); // 내가 입력한 금액 ( 8000 )
        saveLotto(numbers, winNumber);
        checkBonus(checkLotto, correctNumber, bonusBall);
        checkPrize(correctNumber);
        compareLastValue(countPrize, mapTest);
        for (String s : mapTest.keySet()) {
            System.out.print(s);
            System.out.print(" - " + mapTest.get(s) + "개");
            System.out.println();
        }

        System.out.println("***********수익률 구하기**************");
        List<Integer> testList = new ArrayList<>();
        for (String s : mapTest.keySet()) {
            testList.add(mapTest.get(s));
        }
        calculateMoney(myMoney, testList);


        /*
        Map<String, Integer> winner = new LinkedHashMap<>(); // 당첨 번호를 저장할 Map
        Map<List<Integer>, Integer> winnerMap = new LinkedHashMap<>();
        List<Integer> mapValue = new ArrayList<>(); // 당첨 번호 갯수 (3개이상 맞춘 것만) 저장하는 List
        Map<String, Integer> mapTest = new LinkedHashMap<>();  // 3개이상 맞춘 것들만 모아서 몇 장인지 저장하는 Map
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.get(i).size(); j++) {
                if (numbers.get(i).contains(winNumber.get(j))) {
                    winnerMap.put(numbers.get(i), winnerMap.getOrDefault(numbers.get(i), count) + 1);
//                    System.out.println("numbers.get(i) = " + numbers.get(i));
                    winner.put(numbers.get(i).toString(), winner.getOrDefault(numbers.get(i).toString(), count) + 1);
                }
            }
        } // 랜덤 로또값이랑 내가 입력한 번호랑 몇 개가 같은지 구하는 Map

        for (List<Integer> integers : winnerMap.keySet()) {
            System.out.println("integersTest = " + integers);
            System.out.println("winnerMa123123123p = " + winnerMap.get(integers));
            if (winnerMap.get(integers) == 5 && integers.contains(bonusBall)) {
                System.out.println("integersBonusBall = " + integers);
                winner.put(integers.toString(), 7);
            }
        } // 5개를 맞춘 로또들을 모아서 보너스 번호도 일치하는지 확인하는 작업,
        // 만약 5번호 맞추고 , 보너스 번호도 맞춘 거면 현실 기준 2등이기 때문임



        for (Hi value : Hi.values()) {
            mapTest.put(value.getHi(), 0);
        }


        for (String s : winner.keySet()) {
//            System.out.print("s = " + s + " ");
//            System.out.print("/ winner = " + winner.get(s) + "개 일치");
//            System.out.println();
            if (winner.get(s) >= 3) {
                mapValue.add(winner.get(s));
            }
        } // 3개 이상 맞 춘 것만 따로 모오는 과정


        for (Integer integer : mapValue) {
            for (Hi value : Hi.values()) {
                System.out.println("hi : "+value.getHi());
                System.out.println(integer);
//                if (value.getHi().substring(0, 6).equals(integer + "개 일치,")) {
                if (integer == 7 && value.getHi().substring(1, 6).equals("개 일치,")) {
                    System.out.println("test : " + value.getHi().substring(0, 5));
                    System.out.println("test2 : " + integer + "개 일치");
                    mapTest.put(value.getHi(), mapTest.getOrDefault(value.getHi(), 0) + 1);
                } else if (value.getHi().substring(0, 5).equals(integer + "개 일치")){
                    System.out.println("안녕하세요");
                    mapTest.put(value.getHi(), mapTest.getOrDefault(value.getHi(), 0) + 1);
                }
            } // 3개 이상 맞춘 것만 정렬해서 출력후 몇 장인지 구하는 과정
        }

         */

    }



    public void calculateMoney(int myMoney, List<Integer> winMoney) {
        myMoney = myMoney * 1000;
        System.out.println("myMoney = " + myMoney);
        Map<String, Integer> mapMoney = new LinkedHashMap<>();

        int count = 0;
        int total = 0;
        for (Bye value : Bye.values()) {
            System.out.println("value.getBye() = " + value.getBye());
            for (int i = count; i < winMoney.size(); i++) {
                System.out.println("winMoney = " + winMoney.get(i));
                count++;
                total += value.getBye() * winMoney.get(i);
                break;
            }
        }
        System.out.println("total = " + total);
        double add = ((double) total / myMoney) * 100;
        System.out.println("add = " + add);
        add = Math.round(add*10)/10.0;
        System.out.println("총 수익률은 " + add + "%입니다.");
    }

    public void inputBonusNumber() {

    }
}
