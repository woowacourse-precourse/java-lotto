package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static constants.Constants.*;

public class WinningLottoService {

    public static final String INPUT_SPLITTER = ",";

    public WinningLotto scanWinningNums() {
        List<Integer> nums = scanNumbers();
        int bonusNum = scanBonusNumber();
        return new WinningLotto(nums, bonusNum);
    }

    public List<Integer> scanNumbers() {
        System.out.println(SCAN_ANSWER_MSG);
        return changeToList(Console.readLine());
    }

    public int scanBonusNumber() {
        System.out.println(BLANK_BR + SCAN_BONUS_NUMBER_MSG);
        return changeToInteger(Console.readLine());
    }

    public List<Integer> changeToList(String scanNums) {
        List<Integer> lottoNumbers;
        try {
            lottoNumbers = Arrays.stream(scanNums.split(INPUT_SPLITTER)).mapToInt(Integer::valueOf)
                .sorted().boxed().collect(Collectors.toList());
        } catch (Exception NumberFormatException) {
            throw new IllegalArgumentException(INPUT_NOT_INTEGER);
        }
        return lottoNumbers;
    }

    public int changeToInteger(String scanNum) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(scanNum);
        } catch (Exception NumberFormatException) {
            throw new IllegalArgumentException(INPUT_NOT_INTEGER);
        }
        return bonusNumber;
    }


}
