package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Problem problem=new Problem();
        try {
            problem.startProblem();
        }
        catch(Exception e){
            System.out.println("[ERROR] "+e.getMessage());
        }
    }
}
