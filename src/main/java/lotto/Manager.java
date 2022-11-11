package lotto;

import java.util.*;

public class Manager {
    public enum Hi {
        THREE("3개 일치 (5,000원)"),
        FOUR("4개 일치 (50,000원)"),
        FIVE("5개 일치 (1,500,000원)"),
        BONUS("5개 일치, 보너스 볼 일치 (30,000,000원)"),
        SIX("6개 일치 (2,000,000,000원)");

        final private String hi;

        private String getHi() {
            return hi;
        }

        Hi(String hi) {
            this.hi = hi;
        }
    }


    public void inputWinNumbers(List<List<Integer>> numbers, List<Integer> winNumber) {
        int count = 0;
        Map<String, Integer> winner = new LinkedHashMap<>();
        List<Integer> mapValue = new ArrayList<>();
        Map<String, Integer> mapTest = new LinkedHashMap<>();
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.get(i).size(); j++) {
                if (numbers.get(i).contains(winNumber.get(j))) {
//                    System.out.println("numbers.get(i) = " + numbers.get(i));
                    winner.put(numbers.get(i).toString(),winner.getOrDefault(numbers.get(i).toString(), count) + 1);
                }
            }
        }
        for (String s : winner.keySet()) {
            System.out.print("s = " + s + " ");
            System.out.print("/ winner = " + winner.get(s) + "개 일치");
            System.out.println();
            if (winner.get(s) >= 3) {
                mapValue.add(winner.get(s));
            }
        }
        Collections.sort(mapValue);



        for (Integer integer : mapValue) {
            int result = 0;
            mapTest.put(""+integer, mapTest.getOrDefault(""+integer,0) + 1);
        }
        System.out.println("********************************");
        for (String s : mapTest.keySet()) {
            System.out.println(s);
            System.out.println(mapTest.get(s));
        }

        for (Hi value : Hi.values()) {
            System.out.print(value.getHi());
            for (String s : mapTest.keySet()) {
                if (value.getHi().substring(0,1).equals(s)) {
                    System.out.print(" - " + mapTest.get(s) + "개");
                } else if (!(value.getHi().substring(0,1).equals(s))) {
                    System.out.print(" - 0개" );
                }
            }
            System.out.println();
        }
        System.out.println("***********수익률 구하기**************");


    }

    public void inputBonusNumber() {

    }
}
