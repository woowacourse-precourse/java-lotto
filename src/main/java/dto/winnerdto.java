package dto;

import camp.nextstep.edu.missionutils.Console;
import java.lang.*;
import java.util.*;
import java.util.stream.Collectors;

public class winnerdto {
    private List<Integer> winnumbers;
    private int bonusnumber;

    public winnerdto() throws Exception {
        this.winnumbers = readwinnumbers();
        validate_winnumbers(this.winnumbers);
        this.bonusnumber = readbonusnumber();
        validate_bonusnum(this.bonusnumber);
        }

    public List<Integer> getWinnumbers()  {return winnumbers;  }
    public int           getBonusnumber() {return bonusnumber; }

    public List<Integer> readwinnumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String temp = Console.readLine();
        String[] arr = temp.split(",");
        List<Integer> numbers = Arrays.stream(arr).map(Integer::parseInt).collect(Collectors.toList());
        Collections.sort(numbers);
        return numbers;
    }
    public int readbonusnumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = Integer.parseInt(Console.readLine());
        return bonus;
    }

    private void validate_winnumbers(List<Integer> numbers) throws Exception {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 당첨 번호는 중복되지 않는 숫자 6개로 이루어져야 합니다.");
            throw new IllegalArgumentException();
        }

        Set<Integer> numSet = new HashSet<>(numbers);
        if(numSet.size() != numbers.size()) {
            System.out.println("[ERROR] 당첨 번호는 중복되지 않는 숫자 6개로 이루어져야 합니다.");
            throw new IllegalArgumentException();
        }


        for(int n : numbers) {
            if (n < 1 || n > 45) {
                System.out.println("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }
    private void validate_bonusnum(int bonus) throws Exception{
        if (this.winnumbers.contains(bonus)) {
            System.out.println("[ERROR] 당첨 번호는 중복되지 않는 숫자 6개로 이루어져야 합니다.");
            throw new IllegalArgumentException();
        }
        if (bonus < 1 || bonus > 45){
            System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
