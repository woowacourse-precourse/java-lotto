package lotto.UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Input {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer> luckyNumber;
    Scanner sc = new Scanner(System.in);

    public Input() {
    }

    public int howMuchLotto() throws IOException {
        int money = Integer.parseInt(br.readLine());
        return countLotto(money);
    }

    public int countLotto(int money){
        if(money % 1000 != 0){
            System.out.println("[ERROR] 잘못된 금액 입력 에러 발생");
            throw new IllegalArgumentException();
        }
        int count = money / 1000;
        return count;
    }

    public List<Integer> getLuckyNumber() throws IOException {
        luckyNumber = new ArrayList<>();
        String line = sc.nextLine();
        String[] str = line.split(",");
        for(int i = 0; i < str.length; i++){
            if(luckyNumber.contains(Integer.parseInt(str[i]))) {
                System.out.println("[ERROR] 중복 번호 입력 에러 발생");
                throw new IllegalArgumentException();
            }
            luckyNumber.add(Integer.parseInt(str[i].trim()));
        }
        return luckyNumber;
    }

    public int getBonusNumber() throws IOException {
        int bonusNumber = Integer.parseInt(br.readLine());
        if(luckyNumber.contains(bonusNumber)) {
            System.out.println("[ERROR] 당첨 번호와 보너스 번호 입력 에러 발생");
            throw new IllegalArgumentException();
        }
        return bonusNumber;
    }
}
