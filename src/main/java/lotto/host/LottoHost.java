package lotto.host;

import lotto.input.InputAgent;

import java.util.ArrayList;
import java.util.List;

public class LottoHost {
    InputAgent inputAgent = new InputAgent();

    public List<Integer> publishWinningLottoNumbers(List<Integer> emptyLottoNumbers) {
        System.out.println("당첨 번호를 입력해주세요.");
        emptyLottoNumbers.addAll(inputAgent.inputWinningNumbers());
        return emptyLottoNumbers;
    }

    public void publishWinningBonusNumber(List<Integer> lottoNumbers) {
        System.out.println("\n보너스 번호를 입력해주세요.");
        lottoNumbers.add(inputAgent.inputWinningBonusNumber());
    }

    public List<Integer> match(List<List<Integer>> generatedLottoNumbers, List<Integer> winningLottoNumbers) {
        List<Integer> result = new ArrayList<>(generatedLottoNumbers.size());

        for (List<Integer> generatedLottoNumber : generatedLottoNumbers) {
            int count = 0;
            for (Integer winningNumber : winningLottoNumbers) {
                count += generatedLottoNumber.stream()
                        .filter(e -> e.equals(winningNumber))
                        .count();
            }
            result.add(count);
        }
        return result;
    }
}
