package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateCheck(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private static void duplicateCheck(List<Integer> result) {
        if (result.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 입력 숫자가 중복되었습니다.");
        }
        ;
    }

    public int[] castLotto(List<List<Integer>> lottoTickets, Bonus input) {
        int[] result = new int[]{0, 0, 0, 0, 0};
        for (List<Integer> lotto : lottoTickets) {
            int index = checkLotto(lotto, input);
            if (index < 0) {
                continue;
            }
            result[index]++;
        }
        return result;
    }

    public int checkLotto(List<Integer> lotto, Bonus input) {
        int result = getMatchingNumber(lotto);
        if (result == 5) {
            ContainStatus status = Bonus.isBonus(lotto);
            result += status.getContain1Value() * 2;
        }
        if (result < 3) {
            return -1;
        }

        return result - 3;
    }

    public ContainStatus isContainNumber(int LottoNumber) {

        return ContainStatus.setContainStatus(numbers.contains(LottoNumber));
    }

    public int getMatchingNumber(List<Integer> LottoNumbers) {
        int result = 0;

        for (Integer lottoNumber : LottoNumbers) {
            ContainStatus status = isContainNumber(lottoNumber);
            result += status.getContain1Value();
        }
        // TODO: 추가 기능 구현
        return result;
    }


/*  구현했지만 테스트에 통과하지 못한 메소드들.

    public void printNumbers() {
        System.out.println(this.numbers);
    }

    public static String validateMoney() {
        String input = readLine();
        String regex = "\\d+";

        if (!input.matches(regex)) {
            return "[ERROR] 금액을 올바르게 넣어주세요!";
        } else if (Integer.valueOf(input) % 1000 != 0) {
            return "[ERROR] 금액을 올바르게 넣어주세요!";
        }
        return input;
    }

    public static int getMoney(String input) {
        return Integer.valueOf(input);
    }

    public static int getTickets(int money) {
        int tickets = Integer.valueOf(money) / 1000;
        return tickets;
    }

    public static List<List<Integer>> generateNumbers(int tickets) {
        List<List<Integer>> lottoTickets = new ArrayList<>();
        for (int i = 0; i < tickets; i++) {
            List<Integer> number = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(number);
            lottoTickets.add(number);
        }
        return lottoTickets;
    }


    public static List<Integer> getNumbers(String input) {
        String[] numberSplit = input.split(",");
        List<Integer> lottoNumbers = new ArrayList<>();
        if (numberSplit.length > 6) {
            throw new IllegalArgumentException("[ERROR] 숫자를 정확히 입력해주세요");
        }
        for (int i = 0; i < 6; i++) {
            int num = Integer.parseInt(numberSplit[i]);
            lottoNumbers.add(num);
        }
        return lottoNumbers;
    }

    public static int getBonusNumber(String input) {
        String regex = "\\d+";
        if (input.length() > 1) {
            throw new IllegalArgumentException("[ERROR] 한 자리 숫자만 입력해주세요");
        }
        if (!input.matches(regex)) {
            throw new IllegalArgumentException("[ERROR] 한 자리 숫자만 입력해주세요");
        }
        int bonusNumber = Integer.valueOf(input);
        return bonusNumber;
    }

    public int[] castLotto(List<List<Integer>> lottoTickets, int bonusNumber) {
        int[] result = new int[5];
        List<Integer> lottoNumbers = this.numbers;
        for (List<Integer> ticket : lottoTickets) {
            ticket.retainAll(lottoNumbers);
            if (ticket.size() == 6) {
                result[0]++;
            } else if (ticket.size() == 5 && lottoNumbers.contains(bonusNumber)) {
                result[1]++;
            } else if (ticket.size() == 5) {
                result[2]++;
            } else if (ticket.size() == 4) {
                result[3]++;
            } else if (ticket.size() == 3) {
                result[4]++;
            }
        }
        return result;
    }
*/

}