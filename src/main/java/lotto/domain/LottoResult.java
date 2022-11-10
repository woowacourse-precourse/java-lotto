package lotto.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoResult {
    public List<Integer> inputLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String lottoNumberInput = readLine();
        List<String> numbers = Stream.of(lottoNumberInput.split(",")).collect(Collectors.toList());
        List<Integer> lottoNumber = new ArrayList<>();
        for (String s : numbers) {
            lottoNumber.add(Integer.parseInt(s));
        }
        Lotto lotto = new Lotto(lottoNumber);
        numberCheck(lottoNumber);
        return lottoNumber;
    }

    public void numberCheck(List<Integer> numbers) {
        for (int index = 0; index < numbers.size(); index++) {
            if (numbers.get(index) < 1 || numbers.get(index) > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 숫자를 확인 하세요.");
            }
        }
    }

    public int inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonus = readLine();
        int bonusNumber = Integer.valueOf(bonus);
        return bonusNumber;
    }
}
