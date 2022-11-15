package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static <integer> void main(String[] args) {

        Message.Start();

        int money = inputNum();

        validMoney(money);

        int numberLotto = buyLotto(money);

        if (numberLotto > 0) {

            Message.Count(numberLotto);

        }

        HashSet<List> listLotto = randomLotto(numberLotto);

        Message.listNumber(listLotto);

        Message.win();

        List<Integer> inputNum = inputNumber();

        Lotto lotto = new Lotto(inputNum);

        Message.bonus();

        int bonusNum = inputNum();


        HashMap<Integer, Integer> resultLotto = containLotto(inputNum, listLotto, bonusNum);

        Message.lotto(resultLotto);

        double percentage = resultPercentage(resultLotto, money);

        Message.percentage(percentage);

    }

    public static int inputNum() {
        int num;

        try {

            num = Integer.parseInt(Console.readLine());
            System.out.println("");

        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 숫자 입력!");
            return 0;
        }

        return num;
    }

    public static int buyLotto(int money) {
        return money / 1000;
    }

    public static void validMoney(int money) {
        if (money % 1000 > 0) {

            System.out.println("[ERROR] 1,000단위의 수를 입력하세요");

            throw new IllegalArgumentException("[ERROR] 1,000단위의 수를 입력하세요");
        }
    }


    public static HashSet<List> randomLotto(int numLotto) {
        HashSet<List> numberLotto = new HashSet<>();
        for (int i = 0; i < numLotto; i++) {
            List<Integer> numbers = new ArrayList<>(
                    Randoms.pickUniqueNumbersInRange(1, 45, 6));

            Collections.sort(numbers);

            numberLotto.add(numbers);
        }

        return numberLotto;
    }

    public static List<Integer> inputNumber() {
        List<Integer> winNum = new ArrayList<>();

        String inputNum = Console.readLine();

        String[] winNumber = inputNum.split(",");

        for (String i : winNumber) {

            winNum.add(Integer.valueOf(i));
        }

        return winNum;
    }


    private static HashMap<Integer, Integer> containLotto(List<Integer> lotto, HashSet<List> listLotto, int bonusNum) {

        HashMap<Integer, Integer> result = new HashMap<>();
        List<Integer> numLotto = null;

        result.put(5000, 0);
        result.put(50000, 0);
        result.put(1500000, 0);
        result.put(30000000, 0);
        result.put(2000000000, 0);

        for (List i : listLotto) {
            numLotto = i;

            i.removeAll(lotto);

            if (i.size() == 3) {
                result.put(5000, result.get(5000) + 1);

            }
            if ((i.size() == 2)) {
                result.put(50000, result.get(50000) + 1);
            }


            if (i.size() == 1 && !(numLotto.contains(bonusNum))) {
                result.put(1500000, result.get(1500000) + 1);

            }
            if ((i.size() == 1) && (numLotto.contains(bonusNum))) {
                result.put(30000000, result.get(30000000) + 1);
            }
            if (i.size() == 0) {
                result.put(2000000000, result.get(2000000000) + 1);
            }

        }
        return result;
    }


    private static double resultPercentage(HashMap<Integer, Integer> result, int money) {
        double sumReward = 0;

        for (Map.Entry<Integer, Integer> reward : result.entrySet()) {
            sumReward += reward.getKey() * reward.getValue();
        }

        return (sumReward / money) * 100;

    }


}




