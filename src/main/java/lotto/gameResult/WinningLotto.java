package lotto.gameResult;

import java.util.List;
import java.util.HashSet;

public class WinningLotto {
    public static int fifthClassNumber;
    public static int fourthClassNumber;
    public static int thirdClassNumber;
    public static int secondClassNumber;
    public static int firstClassNumber;

    public static void fifthClassFind(List<List<Integer>> lottoBundle, List<Integer> numbers) {
        for(int i=0; i<lottoBundle.size(); i++) {
            HashSet<Integer> check = new HashSet<>(lottoBundle.get(i));
            check.addAll(numbers);
            if (check.size() == 9) {
                fifthClassNumber += 1;
            }
        }
    }
    
    public static void fourthClassFind(List<List<Integer>> lottoBundle, List<Integer> numbers) {
        for(int i=0; i<lottoBundle.size(); i++) {
            HashSet<Integer> check = new HashSet<>(lottoBundle.get(i));
            check.addAll(numbers);
            if (check.size() == 8) {
                fourthClassNumber += 1;
            }
        }
    }
    
    public static void thirdClassFind(List<List<Integer>> lottoBundle, List<Integer> numbers) {
        for(int i=0; i<lottoBundle.size(); i++) {
            HashSet<Integer> check = new HashSet<>(lottoBundle.get(i));
            check.addAll(numbers);
            if (check.size() == 7) {
                thirdClassNumber += 1;
            }
        }
    }

    public static void secondClassFind(List<List<Integer>> lottoBundle, List<Integer> numbers, int bonus) {
        for(int i=0; i<lottoBundle.size(); i++) {
            HashSet<Integer> myNumber = new HashSet<>(lottoBundle.get(i));
            HashSet<Integer> winNumber = new HashSet<>(numbers);
            myNumber.removeAll(winNumber);
            if (myNumber.size()==1 && myNumber.contains(bonus)) {
                secondClassNumber += 1;
            }
        }
        thirdClassNumber -= secondClassNumber;
    }

    public static void firstClassFind(List<List<Integer>> lottoBundle, List<Integer> numbers) {
        for(int i=0; i<lottoBundle.size(); i++) {
            HashSet<Integer> check = new HashSet<>(lottoBundle.get(i));
            check.addAll(numbers);
            if (check.size() == 6) {
                firstClassNumber += 1;
            }
        }
    }

    public static void winningDetails(List<List<Integer>> lottoBundle, List<Integer> numbers, int bonus) {
        fifthClassFind(lottoBundle, numbers);
        fourthClassFind(lottoBundle, numbers);
        thirdClassFind(lottoBundle, numbers);
        secondClassFind(lottoBundle, numbers, bonus);
        firstClassFind(lottoBundle, numbers);
    }
}
