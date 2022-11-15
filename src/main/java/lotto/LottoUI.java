package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoUI {
    private final Manager manager;

    public LottoUI(Manager manager) {
        this.manager = manager;

    }

    public void setPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine().trim();
        validateIsNumber(input);

        manager.setPurchasePrice(Integer.parseInt(input));
    }

    public Lotto getLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] input = Console.readLine().trim().split(",");

        List<Integer> lottoNumbers = Arrays.stream(input)
                .peek(eachNumber -> validateIsNumber(eachNumber))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        return new Lotto(lottoNumbers);
    }

    private void validateIsNumber(String each) {
        try {
            Integer.parseInt(each);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 입력이 숫자가 아닙니다.");
        }
    }
}
