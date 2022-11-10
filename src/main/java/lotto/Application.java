package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(Print.ASK_BUY);
        int publishNum = getPublishNum();
        System.out.println(publishNum+Print.ANSWER_BUY);
        
        List<Lotto> lottos = getLotto(publishNum);

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }

        System.out.println(Print.ASK_PRIZE);
        List<Integer> prize = getPrize();

        System.out.println(Print.ANALYSE_PRIZE);
        analyseLotto(lottos, prize);


    }

    //로또 구입
    private static String inputBudget() {
        String input = Console.readLine();

        validateInputBudget(input);

        return input;
    }

    private static void validateInputBudget(String input) {
        if(!Pattern.matches("^[0-9]*000$", input)) {
            throw new IllegalArgumentException(ErrMsg.VALIDATE_INPUT_BUDGET);
        }
    }

    private static int getBudget() {
        return Integer.parseInt(inputBudget());
    }

    private static int getPublishNum() {
        return getBudget()/1000;
    }
    
    //로또 발행
    private static List<Lotto> getLotto(int publishNum) {
        List<Lotto> lotto = new ArrayList<>();

        while(lotto.size() < publishNum) {
            lotto.add(new Lotto(getLottoNum()));
        }

        validateLotto(lotto, publishNum);

        return lotto;
    }

    private static void validateLotto(List<Lotto> lotto, int publishNum) {
        if(lotto.size()!=publishNum) {
            throw new IllegalArgumentException(ErrMsg.VALIDATE_LOTTO_SIZE);
        }
    }

    private static List<Integer> getLottoNum() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        sortNumbers(numbers);

        return numbers;
    }

    private static void sortNumbers(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
    }

    //로또 당첨
    private static List<Integer> getPrize() {
        List<Integer> prize = setPrizeNum();

        System.out.println(Print.ASK_BONUS);
        inputBonus(prize);

        return prize;
    }

    private static String inputPrizeNum() {
        String prizeNum = Console.readLine();

        validateInputPrizeNum(prizeNum);

        return prizeNum;
    }

    private static void validateInputPrizeNum(String prizeNum) {
        String regexGroup = "([1-9]|[1-3][0-9]|4[0-5])";
        String pattern = "^("+regexGroup+",){5}"+regexGroup;
        //String pattern = "^(([1-9]|[1-3][0-9]|4[0-5]),){5}([1-9]|[1-3][0-9]|4[0-5])";
        System.out.println("pattern: "+pattern);

        if(!Pattern.matches(pattern, prizeNum)) {
            throw new IllegalArgumentException(ErrMsg.VALIDATE_INPUT_PRIZE_NUM);
        }
    }

    private static String[] splitInputPrizeNum() {
        return inputPrizeNum().split(",");
    }

    private static List<Integer> setPrizeNum() {
        String[] splitInput = splitInputPrizeNum();
        List<Integer> prizeNum = new ArrayList<>();

        for(String input : splitInput) {
            prizeNum.add(Integer.parseInt(input));
        }

        validatePrizeNum(prizeNum);

        return prizeNum;
    }

    private static void validatePrizeNum(List<Integer> prizeNum) {
        if(prizeNum.size()!=6) {
            throw new IllegalArgumentException(ErrMsg.VALIDATE_PRIZE_NUM_SIX);
        }
        for(int i=0; i<prizeNum.size(); i++) {
            int num = prizeNum.get(0);
            prizeNum.remove(0);

            if(prizeNum.contains(num)) {
                throw new IllegalArgumentException(ErrMsg.VALIDATE_PRIZE_NUM_UNIQUE);
            }

            prizeNum.add(num);
        }
    }

    private static void inputBonus(List<Integer> prize) {
        String bonus = Console.readLine();

        validateInputBonus(bonus, prize);
    }

    private static void validateInputBonus(String bonus, List<Integer> prize) {
        String pattern = "^([1-9]|[1-3][0-9]|4[0-5])";

        if(!Pattern.matches(pattern, bonus)) {
            throw new IllegalArgumentException(ErrMsg.VALIDATE_BONUS_NUM_ONE);
        }

        int bonusNum = Integer.parseInt(bonus);

        if(prize.contains(bonusNum)) {
            throw new IllegalArgumentException(ErrMsg.VALIDATE_BONUS_NUM_UNIQUE);
        }

        prize.add(bonusNum);
    }

    public static void analyseLotto(List<Lotto> lottos, List<Integer> prize) {
        TreeMap<Prize, Integer> stats = setStats();

        for (Lotto lotto : lottos) {
            countSameNum(lotto, prize, stats);
        }

        System.out.println("로또 분석");
        stats.remove(Prize.ZERO);
        for (Prize p : stats.descendingKeySet()) {
            System.out.println(p.getPrizePrint() + " - " + stats.get(p) + "개");
        }
    }

    private static void printLottoStat(HashMap<Prize, Integer> stats) {
        System.out.println(Print.ANALYSE_PRIZE);

    }

    private static TreeMap<Prize, Integer> setStats() {
        TreeMap<Prize, Integer> stats = new TreeMap<>();

        stats.put(Prize.FIRST, 0);
        stats.put(Prize.SECOND, 0);
        stats.put(Prize.THIRD, 0);
        stats.put(Prize.FOURTH, 0);
        stats.put(Prize.FIFTH, 0);
        stats.put(Prize.ZERO, 0);

        return stats;
    }

    private static void countSameNum(Lotto lotto, List<Integer> prize, TreeMap<Prize, Integer> stats) {
        int count = 0;
        List<Integer> lottoNum = lotto.getNumbers();

        for(int i=0; i<prize.size()-1; i++) {
            if(lottoNum.contains(prize.get(i))) {
                count++;
            }
        }

        if(count==5 && lottoNum.contains(prize.get(6))) {
            stats.replace(Prize.SECOND, stats.get(Prize.SECOND)+1);
            return;
        }

        Prize prizeName = Prize.findPrize(count);
        stats.replace(prizeName, stats.get(prizeName)+1);
    }

}
