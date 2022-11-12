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

        // winnerMap에 저장한 key값들을 어떻게 하면 bonusBall이랑 비교할 수 있을까?
        // [13, 18, 24, 35, 38] -> key
        // bonusBall을 int?로 받을까? String으로 받아서 비교할까?

        /* 보류
        for (String s : winner.keySet()) {
            System.out.println("이거 값 먼데? = " + s.charAt(0));
            System.out.println("이거 값value  먼데 = " + winner.get(s));

            if (winner.get(s) == 5) {
                System.out.println("s = " + s);
                winner.put(s, 4);
            }
        }
        */

//        for (int i = 0; i < numbers.size(); i++) {
//            if(numbers.get(i).contains(bonusBall)) {
//                System.out.println("bonus = " + numbers.get(i));
//            }
//        }

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
//        Collections.sort(mapValue);
//        if (mapValue.size() == 0) {
//            mapTest.put("0", 0);
//        }
        /*
        for (Integer integer : mapValue) {
            System.out.println("mapValue : " + integer);
        }
        for (Hi value : Hi.values()) {
            System.out.println("제발 0,6 서브스트링 : "+value.getHi().substring(0, 6));
            if (value.getHi().substring(0,6).equals(mapValue.get(0)+"개 일치,")) {
                System.out.println("5개잋치,,,,,,");
            } else if (value.getHi().substring(0,5).equals(mapValue.get(0)+"개 일치")) {
                System.out.println("5개만");
            }
        }*/


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
//        for (String s : mapTest.keySet()) {
//            System.out.print(s);
//            System.out.print(" - " + mapTest.get(s) + "개");
//            System.out.println();
//        }
        System.out.println("********************************");
//        for (String s : mapTest.keySet()) {
//            System.out.println("s는 몇 개 일치해 ? : " + s);
//            System.out.println("s일치하는 것 중 총 갯수는 몇 개야? : " + mapTest.get(s));
//        }

        
        
            /* 이게 진짜임 */
//        for (String s : mapTest.keySet()) {
//            for (Hi value : Hi.values()) {
//                if (value.getHi().substring(0, 5).equals(s)) {
//                    System.out.print(value.getHi());
//                    System.out.print(" - " + mapTest.get(s) + "개");
//                    System.out.println();
//                }
//            }
//        }

        List<Integer> moneyTest = new ArrayList<>(); // enum을 이용해서 차례대로 출력하는 것을 비교해서 뒤에 -개수 붙임
        for (Hi value : Hi.values()) {
//            System.out.print(value.getHi());
            for (String s : mapTest.keySet()) {
//                System.out.println();
//                System.out.println("s = " + s);
//                System.out.print("mapTest.get(s) = " + mapTest.get(s));

                if (mapTest.get(s) != 0) {
                    if (value.getHi().substring(0,5).equals(s)) {
//                        System.out.print(" - " + mapTest.get(s) + "개");
                    } else {
//                        System.out.print(" - 0개");
                    }
                }

                if (value.getHi().substring(0, 5).equals(s)) {
//                    System.out.print(" - " + mapTest.get(s) + "개");
                    moneyTest.add(mapTest.get(s));
                } else if (!(value.getHi().substring(0, 6).equals(s))) {
//                    System.out.print(" - 0개");
                    moneyTest.add(0);
                }
            }
            System.out.println();
        }
        System.out.println("***********수익률 구하기**************");
//        for (Integer integer : moneyTest) {
//            System.out.println("moneyTest " + integer);
//        }
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
