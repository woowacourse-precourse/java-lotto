package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Store {
    public int money;d
    public int availableLotto;
    List<List<Integer>> lottoNumbers = new ArrayList<>();

    public List<Integer> createRandom6Number() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        System.out.println(numbers);
        return numbers;
    }

    public void getSetMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        this.money = Integer.parseInt(Console.readLine());
    }

    public boolean confirmMoney() {
        if (money % 1000 == 0) {
            return true;
        } else {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public void setAvailableLotto() {
        availableLotto = money / 1000;
    }

    public List<List<Integer>> publishLotto() {
        for(int i=0;i<availableLotto;i++)
        {
            lottoNumbers.add(createRandom6Number());
        }
        return lottoNumbers;
    }

    public List<Integer> getWinnerNum(){
        List<Integer> winningNums;
        try {
            String []str = Console.readLine().split(",");
            winningNums = Arrays.stream(str).map(Integer::valueOf).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]");
        }
        System.out.println();
        return winningNums;
    }
    public int getBonusNum(){
        int bonusnum = Integer.parseInt(Console.readLine());
        System.out.println();
        return bonusnum;
    }
}
