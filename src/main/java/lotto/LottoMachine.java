package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoMachine {
    private List<Integer> normalNumbers;
    private int bonusNumber;

    public List<Integer> getNormalNumbers() {
        return normalNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public String getMoney() {
        System.out.println("구매금액을 입력해주세요.");
        String input = Console.readLine();
        return input;
    }

    public void validateMoney(String input) {
        int money;
        try {
            money = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값이 숫자가 아닙니다.");
        }

        if (money % 1000 > 0) {
            throw new IllegalArgumentException("[ERROR] 구매금액이 1000원 단위가 아닙니다.");
        }
    }

    public int getLottoCount(String input) {
        int money = Integer.parseInt(input);
        return money / 1000;
    }

    public List<Integer> getLottoNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return numbers;
    }

    public LottoContainer buy() {
        String input = getMoney();
        validateMoney(input);
        int lottoCount = getLottoCount(input);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = getLottoNumbers();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        LottoContainer lottoContainer = new LottoContainer(lottos);

        return lottoContainer;
    }

    public void setWinningNumbers() {
        setNormalNumbers();
        setBonusNumber();
    }

    public void setNormalNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateWinningNumber(input, 6);
        String[] tokenized = input.split(",");

        this.normalNumbers = new ArrayList<>();
        for (String token: tokenized) {
            normalNumbers.add(Integer.parseInt(token));
        }
    }

    public void setBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateWinningNumber(input, 1);
        this.bonusNumber = Integer.parseInt(input);
        validateBonusNumber();
    }

    public void validateWinningNumber(String input, int size) {
        List<String> tokenized = Arrays.asList(input.split(","));
        if (tokenized.size() != size) {
            throw new IllegalArgumentException("[ERROR] 번호의 개수가 " + size + "개가 되어야 합니다.");
        }
        for (String token : tokenized) {
            try {
                int winningNumber = Integer.parseInt(token);
                validateNumberValue(winningNumber);
            } catch(NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자 또는 ',' 이외의 문자가 포함되었습니다.");
            }
        }
        validateDuplicatedNumber(tokenized, size);
    }

    private void validateDuplicatedNumber(List<String> tokenized, int size) {
        Set<String> tokens = new HashSet<>();
        for (String token: tokenized) {
            tokens.add(token);
        }
        if (tokens.size() != size) {
            throw new IllegalArgumentException("[ERROR] 중복된 문자가 있습니다.");
        }
    }

    public void validateNumberValue(int winningNumber) {
        if (winningNumber < 1 || winningNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 숫자의 범위는 1 ~ 45 입니다.");
        }
    }

    public void validateBonusNumber() {
        if (normalNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호와 당첨 번호가 중복됩니다.");
        }
    }

}
