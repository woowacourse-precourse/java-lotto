package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Set;

public class GameStart {

    private static final int lottoLength = 6;
    public void play(Set<List<Integer>> lottoNumbers) {

        System.out.println("\n당첨 번호를 입력해주세요.");
        String inputValue = Console.readLine();
        List<String> winningLottoNumber = isValidWinningNumbers(List.of(inputValue.trim().split(",")));
        System.out.println(winningLottoNumber);

        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();


    }

    private List<String> isValidWinningNumbers (List<String> inputSplitValues) throws IllegalArgumentException {

        if (inputSplitValues.size() != 6) {
            throw new IllegalArgumentException();
        }

        for(int index = 0; index < lottoLength; index++) {
            if(!isNumeric(inputSplitValues.get(index))) {
                throw new IllegalArgumentException();
            }
        }
        return inputSplitValues;
    }

    private boolean isNumeric(String lottoNum) {

        return Integer.parseInt(lottoNum) >= 1 && Integer.parseInt(lottoNum) <= 45;
    }
}
