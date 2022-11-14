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
        validateAnswer(scanNumbers);
        return scanNumbers;
    }

    private void validateAnswer(List<Integer> scanNumbers) {
        checkRange(scanNumbers);
        checkSize(scanNumbers);
        checkDuplicate(scanNumbers);
    }

    private void checkDuplicate(List<Integer> scanNumbers) {
        List<Integer> distinctNumbers = new ArrayList<>();
        for (int num : scanNumbers) {
            if (distinctNumbers.contains(num))
                throw new IllegalArgumentException(ANSWER_DUPLICATE_ERROR);
            distinctNumbers.add(num);
        }
    }

    private void checkRange(List<Integer> scanNumbers) {
        for (int num : scanNumbers) {
            if (num < LOTTO_RANGE_START || LOTTO_RANGE_END < num)
                throw new IllegalArgumentException(ANSWER_RANGE_ERROR);
        }
    }

    private void checkSize(List<Integer> scanNumbers) {
        if (scanNumbers.size() == LOTTO_NUMS_SIZE) return;

        if (scanNumbers.size() < LOTTO_NUMS_SIZE)
            throw new IllegalArgumentException(ANSWER_COUNT_LOWER_ERROR);

        throw new IllegalArgumentException(ANSWER_COUNT_OVER_ERROR);
    }

    public int scanBonusNumber(List<Integer> lottoNumbers) {
        System.out.println(BLANK_BR + SCAN_BONUS_NUMBER_MSG);
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(Console.readLine());
        } catch (Exception NumberFormatException) {
            throw new IllegalArgumentException(INPUT_NOT_INTEGER);
        }
        validateBonusNumber(bonusNumber, lottoNumbers);
        return bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> lottoNumbers) {
        checkRange(List.of(bonusNumber));
        checkBonsDuplicate(bonusNumber, lottoNumbers);
    }

    private void checkBonsDuplicate(int bonusNumber, List<Integer> lottoNumbers) {
        if (lottoNumbers.contains(bonusNumber))
            throw new IllegalArgumentException(BONUS_DUPLICATE_ERROR);
    }

}
