package lotto;

import camp.nextstep.edu.missionutils.Console;

public class View {
    public void printLine(String s) {
        try {
            System.out.println(s);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    public void print(String s) {
        try {
            System.out.print(s);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    public int inputPrice() {
        int i;
        try {
            i = Integer.parseInt(Console.readLine());
            if(i%1000 != 0){
                throw new IllegalArgumentException();
            }
            return Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println("[Error] 로또 구입 금액이 올바르지 않습니다.");;
        }
    }
}
