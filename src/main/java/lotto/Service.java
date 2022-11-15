package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Service {

    public int getMoneyInput() {
        try {
            int input = Integer.parseInt(Console.readLine());
            if (!(input % 1000 == 0)) {
                throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
            }
            return input;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    public List<List<Integer>> createNumber(int moneyInput) {
        int numberOfCreate = moneyInput / 1000;
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < numberOfCreate; i++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto validate = new Lotto(lottoNumber);
            System.out.println(lottoNumber);
            lottoNumbers.add(lottoNumber);
        }

        return lottoNumbers;
    }

    public String getWinningNumberInput() {
        String input = Console.readLine().trim();
        if(!input.contains(",")){
            throw new IllegalArgumentException("[ERROR] 올바른 형식이 아닙니다.");
        }
        String[] winningNumbers = input.split(",");
        if(winningNumbers.length != 6){
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
        }
        Set<String> winningNumberSet = new HashSet<>(Arrays.asList(winningNumbers));
        if(winningNumberSet.size() != winningNumbers.length){
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
        }
        return input;
    }
}
