package lotto;

public class View {

    private void isRealNumber (String inputStatement) {
        for (char element: inputStatement.toCharArray()) {
            if (element < 49 || element > 57) throw new IllegalArgumentException();
        }
    }
}
