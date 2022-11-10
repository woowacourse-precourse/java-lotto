package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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
    }

    //로또 구입
    private static String inputBudget() {
        String input = Console.readLine();

        validateInputBudget(input);

        return input;
    }

    private static void validateInputBudget(String input) {
        if(!Pattern.matches("^[0-9]*000$", input)) {
            throw new IllegalArgumentException("[ERROR] 1,000 단위의 숫자만 입력해 주세요.");
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
            throw new IllegalArgumentException("[ERROR] 로또의 발행 횟수와 로또 발행 리스트의 크기는 같아야 합니다.");
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
            throw new IllegalArgumentException("[ERROR] 1부터 45까지의 숫자를 콤마(,)를 이용해서 6개 적어주세요.");
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

        //System.out.println("prizeNum: "+Arrays.toString(prizeNum.toArray()));
        validatePrizeNum(prizeNum);
        //System.out.println("prizeNum: "+Arrays.toString(prizeNum.toArray()));

        return prizeNum;
    }

    private static void validatePrizeNum(List<Integer> prizeNum) {
        if(prizeNum.size()!=6) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 6개여야 합니다.");
        }
        for(int i=0; i<prizeNum.size(); i++) {
            int num = prizeNum.get(0);
            prizeNum.remove(0);
            //System.out.println("removed prizeNum: "+prizeNum);

            if(prizeNum.contains(num)) {
                throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 서로 달라야 합니다.");
            }

            prizeNum.add(num);
        }
    }
}
