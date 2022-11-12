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
        FIVE(5000),
        FOUR(50000),
        THREE(1500000),
        TWO(30000000),
        ONE(2000000000);

        final private int bye;

        private int getBye() {
            return bye;
        }

        Bye(int bye) {
            this.bye = bye;
        }
    }

    private int myMoney = 0;


    public void inputWinNumbers(List<List<Integer>> numbers, List<Integer> winNumber, int bonusBall) {
        int count = 0;
        myMoney = numbers.size(); // 내가 입력한 금액 ( 8000 )
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
        }


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

        for (String s : mapTest.keySet()) {
            System.out.print(s);
            System.out.print(" - " + mapTest.get(s) + "개");
            System.out.println();
        }
        System.out.println("********************************");

        System.out.println("***********수익률 구하기**************");
        List<Integer> testList = new ArrayList<>();
        for (String s : mapTest.keySet()) {
            testList.add(mapTest.get(s));
        }
        calculateMoney(myMoney, testList);
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
        double add = ((double) total / myMoney * 100);
        add = Math.round(add*10)/10.0;
        System.out.println("총 수익률은 " + add + "%입니다.");
    }

    public void inputBonusNumber() {

    }
}
