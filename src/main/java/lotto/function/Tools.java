package lotto.function;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tools {
    public static List<Integer> makeNumbers(){
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        return numbers;
    }

    public static void showNumbers(List<Integer> numbers){
        Collections.sort(numbers);
        System.out.println(numbers);
    }

    public static int whichPlaceIsIt(List<Integer> numbers,List<Integer> winner, int bonus){
        int count = 0;
        boolean gotBonus = false;
        for(int i=0;i<6;i++){
            if(numbers.contains(winner.get(i))) count += 1;
        }
        if(numbers.contains((bonus))) gotBonus = true;
        return decisePlace(count,gotBonus);
    }

    public static int decisePlace(int count,boolean gotBonus){
        if(count==6) return 1;
        if(count==5 && gotBonus) return 2;
        if(count==5 && !gotBonus) return 3;
        if(count==4) return 4;
        if(count==3) return 5;
        return 0;
    }

    public static void showPlaces(List<Integer> places){
        System.out.println("3개 일치 (5,000원) - "+places.get(5)+"개");
        System.out.println("4개 일치 (50,000원) - "+places.get(4)+"개");
        System.out.println("5개 일치 (1,500,000원) - "+places.get(3)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+places.get(2)+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+places.get(1)+"개");
    }

    public static void showYield(int lsize, List<Integer> places){
        double yield = 0;
        List<Integer> prize = List.of(0,2000000000,30000000,1500000,50000,5000);
        for(int i=1;i<6;i++){
            yield += places.get(i) * prize.get(i);
        }
        yield = yield/lsize/10;
        System.out.println("총 수익률은 " + String.format("%.1f", yield) +"%입니다.");
    }
}
