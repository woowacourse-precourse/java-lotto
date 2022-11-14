package lotto;

import java.util.HashSet;
import java.util.List;

public class UserInputException extends Exception {
    public static boolean numberCheck(String input) throws IllegalArgumentException {
        try {
            if (input.split("[0-9]").length > 0) throw new IllegalArgumentException();
            return false;
        } catch (IllegalArgumentException e) {
            System.out.print("[ERROR] 입력한 금액이 숫자인지 확인하세요.");
            return true;
        }
    }

    public static boolean moneyMinCheck(String input) throws IllegalArgumentException {
        try {
            if (Integer.parseInt(input) < 1000) throw new IllegalArgumentException();
            return false;
        } catch (IllegalArgumentException e) {
            System.out.print("[ERROR] 최소 1000원부터 게임 가능합니다.");
            return true;
        }
    }

    public static boolean moneyUnitCheck(String input) throws IllegalArgumentException {
        try {
            if (Integer.parseInt(input) % 1000 != 0) throw new IllegalArgumentException();
            return false;
        } catch (IllegalArgumentException e) {
            System.out.print("[ERROR] 입력한 금액이 1000원으로 나누어 떨어지는지 확인하세요.");
            return true;
        }
    }

    public static boolean lengthCheck(String input, int length) throws IllegalArgumentException {
        try {
            String[] checkTarget = input.split(",");
            if (checkTarget.length != length) throw new IllegalArgumentException();
            return false;
        } catch (IllegalArgumentException e) {
            System.out.printf("[ERROR] 번호를 %d개 입력했는지 확인하세요.", length);
            return true;
        }

    }

    public static boolean delimiterCheck(String input) throws IllegalArgumentException {
        try {
            int delimiterCount = 0;
            int digitCount = 0;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == ',') delimiterCount++;
                if (Character.isDigit(input.charAt(i))) digitCount++;
            }
            if (delimiterCount == 0 || digitCount == 0) throw new IllegalArgumentException();
            return false;
        } catch (IllegalArgumentException e) {
            System.out.print("[ERROR] 당첨번호를 숫자와 ',' 로 입력했는지 확인하세요.");
            return true;
        }
    }

    public static boolean rangeCheck(String input) throws IllegalArgumentException {
        try {
            String[] checkTarget = input.split(",");
            for (String targetI : checkTarget) {
                int targetNumber = Integer.parseInt(targetI);
                if (targetNumber < 1 || targetNumber > 45) throw new IllegalArgumentException();
            }
            return false;
        } catch (IllegalArgumentException e) {
            System.out.print("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            return true;
        }
    }

    public static boolean duplicateCheck(String input) throws IllegalArgumentException {
        try {
            String[] checkTarget = input.split(",");
            HashSet<Integer> numberPool = new HashSet<>();
            for (String targetI : checkTarget) {
                numberPool.add(Integer.parseInt(targetI));
            }
            if (numberPool.size() != checkTarget.length) throw new IllegalArgumentException();
            return false;
        } catch (IllegalArgumentException e) {
            System.out.print("[ERROR] 입력한 당첨 번호에 중복 숫자가 있는지 확인하세요.");
            return true;
        }
    }

    public static boolean duplicateBonusCheck(List<Integer> winningNumbers, String bonusNumber) {
        try {
            if (winningNumbers.contains(Integer.parseInt(bonusNumber))) throw new IllegalArgumentException();
            return false;
        } catch (IllegalArgumentException e) {
            System.out.print("[ERROR] 보너스 번호는 직전에 입력한 당첨 번호들과 달라야합니다.");
            return true;
        }
    }

}
