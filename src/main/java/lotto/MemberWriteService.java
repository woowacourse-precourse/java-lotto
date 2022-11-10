package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MemberWriteService {

    // 금액 입력 기능
    public int writePay(String writePay) {
        try {
            return Integer.parseInt(writePay);
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
            return 0;
        }
    }

    // 당첨 로또 입력 기능
    public WinningLottoNumber winningLottoNumbers(String writeLottoNumber, String writeBonusNumber) {
        List<Integer> winningNumbers = Arrays.stream(writeLottoNumber.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("This Lotto Number is Exception !!");
        }

        if (!winningNumbers.stream().allMatch(number -> number >= 1 && number <= 45)) {
            throw new IllegalArgumentException("This Lotto Number is Exception !!");
        }

        int bonusNumber = 0;
        try {
            bonusNumber = Integer.parseInt(writeBonusNumber);
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }

        return WinningLottoNumber.createWinningLottoNumber(winningNumbers, bonusNumber);
    }


}
