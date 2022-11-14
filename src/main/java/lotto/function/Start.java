package lotto.function;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import static lotto.function.Tools.*;
import static lotto.function.Tools.showYield;
import static lotto.function.Validation.*;

public class Start {

    public void run(){
        int price = howMuch();
        List<List<Integer>> Lotto = showLotto(price);
        List<Integer> winner = typeWinningNumber();
        int bonus = typeBonusNumber(winner);
        showStatistics(Lotto,winner,bonus);
    }

    public static int howMuch(){
        System.out.println("구입금액을 입력해 주세요.");
        int price = 0;
        String input = Console.readLine();
        try{
            price = Integer.parseInt(input);
        } catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 입력한 값이 숫자가 아닙니다.");
        }
        validatePurchase(price);
        return price;
    }

    public static List<List<Integer>> showLotto(int price){
        int trials = price/1000;
        System.out.println(trials +"개를 구매했습니다.");
        List<List<Integer>> Lotto = new ArrayList<>();
        for(int i=0;i<trials;i++){
            List<Integer> numbers = makeNumbers();
            Lotto.add(numbers);
            showNumbers(numbers);
        }
        return Lotto;
    }

    public static List<Integer> typeWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winner = new ArrayList<>();
        try{
            winner = Stream.of(Console.readLine().split(",")).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
        } catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 입력은 숫자와 쉼표로만 이루어져야 합니다.");
        }
        Collections.sort(winner);
        validateNumbers(winner);
        return winner;
    }

    public static int typeBonusNumber(List<Integer> winner){
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus=0;
        try {
            bonus = Integer.parseInt(Console.readLine());
        } catch(Exception e){
            throw new IllegalArgumentException("[ERROR] 입력한 값이 숫자가 아닙니다.");
        }
        validateBonus(winner,bonus);
        return bonus;
    }

    public static void showStatistics(List<List<Integer>> Lotto, List<Integer> winner, int bonus){
        System.out.println("당첨 통계");
        System.out.println("---");
        List<Integer> places = new ArrayList<>(Arrays.asList(0,0,0,0,0,0));
        int lsize = Lotto.size();
        for(int i=0;i<lsize;i++){
            int place = whichPlaceIsIt(Lotto.get(i),winner,bonus);
            places.set(place,places.get(place)+1);
        }
        showPlaces(places);
        showYield(lsize,places);
    }
}
