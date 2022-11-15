package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.view.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class User {
    private List<Lotto> lottos = new ArrayList<>();
    private List<Integer> winningNumber = new ArrayList<>();
    private Integer bonusNumber;
    public User(List<Lotto> lottos) {
        this.lottos = lottos;
    }
    public void inputWinningNUmber() {
        Printer.inputWinningNumber();
        String input = Console.readLine();
        List<String> numbers = List.of(input.split(","));

        validateLottoNum(numbers);
        for(String str: numbers) {
            winningNumber.add(Integer.parseInt(str));
        }
    }
    public List<Integer> getWinningNumber() {
        return winningNumber;
    }
    public void inputBonusNumber() {
        Printer.inputBonusNumber();
        String bonusInput = Console.readLine();
        validateBonusNum(bonusInput);
        bonusNumber = Integer.parseInt(bonusInput);
    }
    public Integer getBonusNumber() {
        return bonusNumber;
    }
    private void validateLottoNum(List<String> numbers) {
        if(numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개 입력해야 합니다.");
        }
        // Set으로 변환
        if(Set.copyOf(numbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 중복되지 않아야 합니다.");
        }
        for(int i = 0; i < numbers.size(); i++) {
            String num = numbers.get(i);
            if(num.matches("[^0-9]")) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다. ");
            }
            int bonusNum = Integer.parseInt(num);
            if(bonusNum < 1 || bonusNum > 45) {
                throw new IllegalArgumentException("[ERROR] 1 ~ 45 숫자만 입력 가능합니다.");
            }
        }
    }

    private void validateBonusNum(String num) {
        if(winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 중복되지 않아야 합니다.");
        }
        if(num.matches("[^0-9]]")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다. ");
        }
        int bonusNum = Integer.parseInt(num);
        if(bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException("[ERROR] [ERROR] 1 ~ 45 숫자만 입력 가능합니다.");
        }
    }
}
