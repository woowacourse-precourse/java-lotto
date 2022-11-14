package lotto.gameResult;

import java.util.List;
import java.util.HashSet;

public class WinningLotto {
    public static int fifthNumber;
    public static int fourthNumber;
    public static int thirdNumber;
    public static int secondNumber;
    public static int firstNumber;

    public static void threeNumberFind(List<List<Integer>> lottoBundle, List<Integer> winningNumber) {
        for(int i=0; i<lottoBundle.size(); i++) {
            HashSet<Integer> check = new HashSet<>();
            check.addAll(lottoBundle.get(i));
            check.addAll(winningNumber);
            if (check.size() == 9) {
                fifthNumber += 1;
            }
        }
    }
    
    public static void fourNumberFind(List<List<Integer>> lottoBundle, List<Integer> winningNumber) {
        for(int i=0; i<lottoBundle.size(); i++) {
            HashSet<Integer> check = new HashSet<>();
            check.addAll(lottoBundle.get(i));
            check.addAll(winningNumber);
            if (check.size() == 8) {
                fourthNumber += 1;
            }
        }
    }
    
    public static void fiveNumberFind(List<List<Integer>> lottoBundle, List<Integer> winningNumber) {
        for(int i=0; i<lottoBundle.size(); i++) {
            HashSet<Integer> check = new HashSet<>();
            check.addAll(lottoBundle.get(i));
            check.addAll(winningNumber);
            if (check.size() == 7) {
                thirdNumber += 1;
            }
        }
    }

    
}
