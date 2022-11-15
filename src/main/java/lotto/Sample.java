package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Sample {
    private static final String ILLEGAL_ARGUMENT_ERROR_MESSAGE = "[ERROR] Illegal Argument";
    public int stringToInt(String line){ // Lotto-valid-001, WinningStatistics-valid-002
        try{
            int number = Integer.parseInt(line);
            return number;
        } catch (NumberFormatException e){
            System.out.println(ILLEGAL_ARGUMENT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public int getPayMoney(String line){ // Lotto-valid-001
        int payMoney = stringToInt(line);
        if (payMoney % 1000 != 0) {
            System.out.println(ILLEGAL_ARGUMENT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
        return payMoney;
    }

    public List<Lotto> getLottos(int numberPurchase){ // Lotto-create-001
        List<Lotto> lottos = new ArrayList<>();
        for (int nowPurchase = 0; nowPurchase < numberPurchase; nowPurchase++){
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lotto.sort(Comparator.naturalOrder());
            lottos.add(new Lotto(lotto));
        }
        return lottos;
    }

    public Lotto getWinningNumber(String line){ // WinningStatistics-valid-001
        try {
            List<Integer> winningNumbers = Arrays.stream(line.split(",")).map(Integer::parseInt).collect(Collectors.toList());
            return new Lotto(winningNumbers);
        } catch (NumberFormatException e){
            System.out.println(ILLEGAL_ARGUMENT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }


    public int validBonusNumber(String line){ // WinningStatistics-valid-002
        int bonusNumber = stringToInt(line);
        if (bonusNumber < 1 || bonusNumber > 45){
            System.out.println(ILLEGAL_ARGUMENT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
        return bonusNumber;
    }





}
