package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoAnswer {
    private Lotto winningNumber;
    private Integer bonusNumber;

    /**
     * LottoAnswer 생성자
     *
     * @param numbersCommand 사용자의 당첨 번호 입력
     * @param bonusCommand   사용자의 보너스 번호 입력
     * @throws IllegalArgumentException 숫자 범위와 개수가 맞지 않거나, 숫자가 중복된 경우
     */
    public LottoAnswer(String numbersCommand, String bonusCommand) throws IllegalArgumentException {
        List<Integer> numbers = commandToNumbers(numbersCommand);
        Integer bonus = commandToBonus(bonusCommand);

        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException(LottoErrorCode.DUPLICATE_LOTTO_NUMBER.toString());
        }
        if (bonus < Lotto.LOTTO_START_NUMBER || bonus > Lotto.LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(LottoErrorCode.INVALID_LOTTO_RANGE.toString());
        }

        this.winningNumber = new Lotto(numbers);
        this.bonusNumber = bonus;
    }

    /**
     * 사용자의 당첨 번호 입력을 Integer 리스트로 반환
     *
     * @param numbersCommand 쉼표(,)로 구분된 당첨 번호 입력
     * @return Integer로 변환한 당첨 번호 리스트
     * @throws IllegalArgumentException 숫자가 아닌 값이 있을 경우
     */
    private List<Integer> commandToNumbers(String numbersCommand) throws IllegalArgumentException {
        List<String> numbersString = Arrays.asList(numbersCommand.split(","));
        List<Integer> numbers;

        try {
            numbers = numbersString.stream()
                    .map(s -> Integer.parseInt(s))
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoErrorCode.INVALID_LOTTO_RANGE.toString());
        }

        return numbers;
    }

    /**
     * 사용자의 보너스 번호 입력을 Integer로 반환
     *
     * @param bonusCommand 사용자의 보너스 번호 입력
     * @return Integer로 변환한 보너스 번호
     * @throws IllegalArgumentException 숫자가 아닌 값일 경우
     */
    private Integer commandToBonus(String bonusCommand) throws IllegalArgumentException {
        Integer bonus = 0;

        try {
            bonus = Integer.parseInt(bonusCommand);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoErrorCode.INVALID_LOTTO_RANGE.toString());
        }

        return bonus;
    }

    /**
     * 당첨 번호 중에서 인자로 주어진 로또와 일치하는 번호 개수 반환
     *
     * @param lotto 비교할 로또
     * @return 당첨 번호에서 일치하는 번호 개수
     */
    public int getCorrectCount(Lotto lotto) {
        return winningNumber.countCommonNumber(lotto);
    }

    /**
     * 인자로 주어진 로또 중 보너스 번호가 안에 있는지 여부 반환
     *
     * @param lotto 보너스 번호가 있는지 확인할 로또
     * @return 보너스 번호 보유 여부
     */
    public boolean isContainBonus(Lotto lotto) {
        return lotto.isContainNumber(bonusNumber);
    }
}