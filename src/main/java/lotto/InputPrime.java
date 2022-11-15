package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputPrime {
    public int inputPrime(){
        String prime;
        int count;

        System.out.println("구입금액을 입력해 주세요.");
        prime = Console.readLine();
        if (checkPrime(prime) == 0){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
        if (checkPrime(prime) == 2)
            return -1;
        count = countLotto(prime);
        return count;
    }

    public int checkPrime(String prime){
        int primeI;

        try {
            primeI = Integer.parseInt(prime);
            if (primeI % 1000 != 0)
                return 0;
            return 1;
        }
        catch(NumberFormatException e){
            System.out.println("[ERROR] 숫자만 입력하세요.");
            return 2;
        }
    }

    public int countLotto(String prime){
        int count;

        count = Integer.parseInt(prime) / 1000;
        return count;
    }
}
