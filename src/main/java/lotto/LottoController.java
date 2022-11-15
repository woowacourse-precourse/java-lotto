package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class LottoController {

    public void startLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validate(input);
        int money = Integer.parseInt(input);
        int count = money / 1000;
        System.out.println(count + "개를 구매했습니다.");
        List<Lotto> lottos = makeLotto(count);
        for (int i=0;i<count;i++){
            System.out.println(lottos.get(i).getNumbers());
        }
        getInput();
    }

    public void getInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        inputValueVerificate(input);
        List<Integer> numbers = new ArrayList<>();
        for (String number:input.split(",")){
            numbers.add(Integer.parseInt(number));
        }
        Lotto userLotto = new Lotto(numbers);
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonuseInput = Console.readLine();
        bonusValidate(bonuseInput, userLotto);
    }

    public List<Lotto> makeLotto(int count){
        List <Lotto> lottos = new ArrayList<>();
        for (int i=0;i<count;i++){
            Lotto lotto = new Lotto(createRandomNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }

    public void bonusValidate(String input, Lotto userLotto) {
        if (!isNumeric(input)){
            throw new IllegalArgumentException();
        }
        int bonusNum = Integer.parseInt(input);
        for (Integer number:userLotto.getNumbers()) {
            if (number == bonusNum) {
                throw new IllegalArgumentException();
            }
        }
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public void validate(String input) {
        if (!isNumeric(input)){
            throw new IllegalArgumentException();
        }
        int money = Integer.parseInt(input);
        if (money%1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public void inputValueVerificate(String input) {
        String pattern = "^\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2}";
        if (!Pattern.matches(pattern, input)) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> createRandomNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
