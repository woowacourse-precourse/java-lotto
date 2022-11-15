package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

    public static void main(String[] args) {

    }

    // num개의 lotto를 발행하는 함수
    public static List<Lotto> makeLottoNumber(List<Lotto> lottos, int num){
        for(int i = 0; i < num; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    public static int checkPayMoney(int money){
        if(money%1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 금액만 가능합니다.");
        }
        return money/1000;
    }

    public static int checkLottoSame(Lotto winningLotto, Lotto lotto){
        int same = 0;
        List<Integer> winNum = winningLotto.getNumbers();
        List<Integer> lottoNumbers = lotto.getNumbers();
        for(int i : lottoNumbers){
            if(winNum.contains(i)){
                same++;
            }
        }
        return same;
    }

    public static void printLottos(List<Lotto> lottos){
        for(Lotto lotto : lottos){
            List<Integer> numbers = lotto.getNumbers();
            Collections.sort(numbers);
            System.out.println(numbers.toString());
        }
    }

    // string배열을 int List로 변환하는 함수
    public static List<Integer> stringToIntList(String[] str){
        List<Integer> nums = new ArrayList<>();
        int[] numbers = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
        for(int i : numbers){
            nums.add(i);
        }
        return nums;
    }

    public static void revenuePrint(long useMoney, long revenue){
        System.out.println(revenue);
        double revPercent = revenue/(double)useMoney;
        String result = String.format("%.2f", revPercent);
        System.out.println("총 수익률은" + result + "%입니다");
    }

    public static int lottoRank(Lotto lotto,Lotto winningLotto, int bonus){
        int same = checkLottoSame(winningLotto, lotto);
        if(same == 5){
            List<Integer> nums = lotto.getNumbers();
            if(nums.contains(bonus)){
                return 2;
            }
            return 3;
        }
        if(same == 6){
            return 1;
        }
        return 8 - same;
    }

    public static long revenue(List<Lotto> lottos, Lotto winningLotto, int bonus){
        long revenue = 0;
        for(Lotto lotto : lottos){
            int rank = lottoRank(lotto, winningLotto, bonus);
            if(rank > 5){
                continue;
            }
            Rank[] values = Rank.values();
            revenue += values[rank - 1].getMoney();
        }
        return revenue;
    }

    public static void printWinning(List<Lotto> lottos, Lotto winningLotto, int bonus){
        int[] win = {0,0,0,0,0};
        for(Lotto lotto : lottos){
            int rank = lottoRank(lotto, winningLotto, bonus);
            if(rank > 5){
                continue;
            }
            win[rank-1]++;
        }
        for(int i = 0; i < 5; i++){
            Rank[] values = Rank.values();
            System.out.println(values[4-i].getPrinting() + " - " + win[i] + "개");
        }
    }
}