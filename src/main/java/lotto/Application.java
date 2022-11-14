package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        return convertToNumber(purchaseAmount);
    }

    static int convertToNumber(String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 양의 정수여야 합니다.");
        }
    }

    static int quantityOfLotto(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    static void validateEnoughMoney(int purchaseAmount) {
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입금액이 부족합니다.");
        }
    }

    static void validateChangeIsZero(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 남는 금액이 존재합니다.");
        }
    }

    static List<Integer> inputLottoNumbers(String numbers) {
        numbers = Console.readLine();
        return replaceSeparator(numbers);
    }

    static List<Integer> replaceSeparator(String numbers) {
        String[] eachNumbers = numbers.split(",");
        return collectLottoNumbers(eachNumbers);
    }

    static List<Integer> collectLottoNumbers(String[] eachNumbers) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int ordinalNumber = 0; ordinalNumber < eachNumbers.length; ordinalNumber++) {
            String eachNumber = eachNumbers[ordinalNumber];
            lottoNumbers.add(convertEachNumbers(eachNumber));
        }
        return lottoNumbers;
    }

    static int convertEachNumbers(String eachNumber) {
        try {
            return Integer.parseInt(eachNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 정수여야 합니다.");
        }
    }

    static void validateLottoNumbers(List<Integer> lottoNumbers) {
        validateNumber1To45(lottoNumbers);
        exceptDuplicatedNumber(lottoNumbers);
    }

    static void validateNumber1To45(List<Integer> lottoNumbers) {
        for (int eachNumber : lottoNumbers) {
            if (eachNumber < 1 || eachNumber > 45)
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45까지의 숫자입니다.");
        }
    }

    static void exceptDuplicatedNumber(List<Integer> lottoNumbers) {
        Set<Integer> existentNumber = new HashSet<>();
        for (int eachNumber : lottoNumbers) {
            if (existentNumber.contains(eachNumber))
                throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 존재합니다.");
            existentNumber.add(eachNumber);
        }
    }

    static int inputBonusNumber(String number) {
        number = Console.readLine();
        return convertBonusNumber(number);
    }

    static int convertBonusNumber(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수여야 합니다.");
        }
    }

    static void validateBonusNumbers(List<Integer> lottoNumbers, int bonusNumber) {
        validateNumber1To45(bonusNumber);
        exceptDuplicatedNumber(lottoNumbers, bonusNumber);
    }

    static void validateNumber1To45(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45)
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45까지의 숫자입니다.");
    }

    static void exceptDuplicatedNumber(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber))
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 중복된 숫자입니다.");
    }

    static Set<List<Integer>> generateUniqueLottoTickets(int numberOfTickets) {
        Set<List<Integer>> existentTicket = new HashSet<>();
        int numberOfGeneratedTickets = 0;
        while (numberOfGeneratedTickets < numberOfTickets) {
            List<Integer> generatedTicket = generateRandomLottoTicket();
            if (existentTicket.contains(generatedTicket))
                continue;
            existentTicket.add(generatedTicket);
            numberOfGeneratedTickets++;
        }
        return existentTicket;
    }

    static List<Integer> generateRandomLottoTicket() {
        List<Integer> LottoTicket = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return sortRandomLottoTicket(LottoTicket);
    }

    static List<Integer> sortRandomLottoTicket(List<Integer> LottoTicket) {
        Collections.sort(LottoTicket);
        return LottoTicket;
    }
}