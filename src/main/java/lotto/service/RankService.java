package lotto.service;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinLotto;
import lotto.error.ErrorMsg;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RankService {

    public Lotto generateWinningLotto(String numbers, String bonus) throws IllegalArgumentException{
        try {
            List<Integer> winningNumbers = Arrays.stream(numbers.split(","))
                    .map(Integer::parseInt).collect(Collectors.toList());
            int bonusNumber = Integer.parseInt(bonus);

            return new WinLotto(winningNumbers, bonusNumber);
        }catch (Exception e){
            throw new IllegalArgumentException(ErrorMsg.INPUT_ERROR.toString());
        }
    }
}
