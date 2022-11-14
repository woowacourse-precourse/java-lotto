package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static constants.Constants.*;

public class WinningLottoService {

    public static final String INPUT_SPLITTER = ",";

    public WinningLotto scanWinningNums() {
        List<Integer> nums = scanNumbers();
        int bonusNum = scanBonusNumber(nums);
        return new WinningLotto(nums, bonusNum);
    }

    public List<Integer> scanNumbers() {
        System.out.println(SCAN_ANSWER_MSG);
        List<Integer> scanNumbers;
        try {
            scanNumbers = Arrays.stream(Console.readLine().split(INPUT_SPLITTER)).mapToInt(Integer::valueOf)
                .sorted().boxed().collect(Collectors.toList());
        } catch (Exception NumberFormatException) {
            throw new IllegalArgumentException(INPUT_NOT_INTEGER);
        }
        return scanNumbers;
    }

    public int scanBonusNumber(List<Integer> lottoNumbers) {
        System.out.println(BLANK_BR + SCAN_BONUS_NUMBER_MSG);
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(Console.readLine());
        } catch (Exception NumberFormatException) {
            throw new IllegalArgumentException(INPUT_NOT_INTEGER);
        }
        return bonusNumber;
    }


}
