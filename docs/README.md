# 로또

## 구현 기능 목록
- 숫자 랜덤 뽑기
    - 1~45 범위
    - 6개
    - 사용자가 구매한 로또 수 만큼
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.
    
    
- 사용자에게 숫자 입력받기
    - 로또 구매 금액
    - 번호는 쉼표를 기준으로
    - 보너스 번호
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console의 readLine()`을 활용한다.
    
    
- 사용자 숫자와 로또 당첨 숫자 비교
    - 당첨 내역
    - 수익률 계산
    
    
- 예외상황
    - 사용자 로또 구매 금액이 1,000원으로 나누어 떨어지지 않는 경우
    - 숫자 외의 입력값
    - 로또 번호 개수(6개)
    - 로또 번호 숫자 쉼표 구분
    - 번호 중복
    - `IllegalArgumentException` 발생
    - [ERROR] 문구 설정
    
    
- 테스트 케이스 작성

### 요구 사항
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- Java Enum을 적용한다.
- 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
    - 단위 테스트 작성이 익숙하지 않다면 `test/java/lotto/LottoTest`를 참고하여 학습한 후 테스트를 구현한다.

- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.


### Lotto 클래스

- 제공된 `Lotto` 클래스를 활용해 구현해야 한다.
- `Lotto`에 매개 변수가 없는 생성자를 추가할 수 없다.
- `numbers`의 접근 제어자인 private을 변경할 수 없다.
- `Lotto`에 필드(인스턴스 변수)를 추가할 수 없다.
- `Lotto`의 패키지 변경은 가능하다.

```java
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
```
