# 📈 기능 목록

## 구현 기능 목록

### ✅ 출력 기능

- [X] : 발행한 로또 수량을 출력한다
- [X] : 발행한 로또 번호를 출력한다,
- [X] : 당첨 내역을 출력한다
- [X] : 수익률을 출력한다, (소수점 둘째 짜리에서 반올림 한다)

### ✅ 입력할 내용 설명 기능 및 입력 기능

- [X] : "구입금액을 입력해 주세요."와 함께 콘솔 창에 입력 기능 넣는다
- [X] : "당첨 번호를 입력해 주세요."와 함께 콘솔 찰에 입력 기능을 넣는다
- [X] : "보너스 번호를 입력해 주세요."와 함께 콘솔 찰에 입력 기능을 넣는다

### ✅ 입력 예외 처리 기능

- 예외 상황시 에러문구를 출력한다. 단, 에러문구는 "[ERROR]"로 시작해야 한다
    - "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
- 구매할 금액 에러 체크
    - [X] : [ERROR] 숫자가 아닌 경우
    - [X] : [ERROR] 구매 금액이 1000으로 나누어 떨어지지 않는 경우
- 당첨번호 입력 체크
    - [ ] : [ERROR] 사용자가 숫자를 입력하지 않은 경우
    -  [ ] : [ERROR] 사용자가 6개 미만 혹은 초과의 번호를 입력한 경우
- 보너스 번호 에러 체크
    - [X] : [ERROR] 숫자가 아닌 경우 -> 아스키 코드 이용
    - [X] : [ERROR] 1~45 범위가 아닌 경우
- 생성된 로또번호 에러 체크
    - [X] : [ERROR] 생성된 숫자리스트 사이즈가 6이 아닌 경우
    - [X] : [ERROR] 생선된 숫자리스트에 중복된 것이 있는 경우
    - [X] : [ERROR] 생성된 숫자가 1~45 범위가 아닌 경우

### ✅ 사용자 로또 번호 생성 및 저장 기능

- [X] : 사용자에게 돈을 받으면 로또번호를 생성하는 기능
- [X] : 로또 번호는 오름차순으로 정렬한다
- [X] : 사용자가 로또 번호 저장기능

### ✅ 사용자 로또 번호 판단 기능

- [X] : 저장된 로또 번호가 "당청 번호"와 일치 내열을 통계를 낸다
- [X] : 저장된 로또 번호가 "보너스 번호"와 일치 한지 통계를 낸다
- [X] :  해당 통계 정보를 저장한다
- [X] : 통계 정보 바탕으로 수익률을 계산한다

## 로직 흐름

1. 구입 금액을 입력함 -> 여기서 로또 개수를 판단함
2. 구입 금액에 맞춰서, 6개씩 랜덤 번호를 생성함
3. 당첨 번호를 입력함
4. 보너스 번호를 입력함
5. "생성한 랜덤 번호"가 "당청 번호"와 "보너스 번호"와 일치하는지 판단한다
6. 또한 수익률을 계산한다
6. 그 결과를 출력함

## 🎯 프로그래밍 요구 사항

- [X] JDK 11 버전에서 실행 가능해야 한다. **JDK 11에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- [X] 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- [X] `build.gradle` 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [X] [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수하며 프로그래밍한다.
- [X] 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- [X] 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
- [ ] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
- [ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- [ ] 3항 연산자를 쓰지 않는다.
- [ ] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [ ] JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.

### 추가된 요구 사항

- [ ] 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- [ ] else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- [ ] Java Enum을 적용한다.
- [ ] 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
    - 단위 테스트 작성이 익숙하지 않다면 `test/java/lotto/LottoTest`를 참고하여 학습한 후 테스트를 구현한다.

### 라이브러리

- [ ] [`camp.nextstep.edu.missionutils`](https://github.com/woowacourse-projects/mission-utils)에서 제공하는 `Randoms`
  및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

#### 사용 예시

```java
List<Integer> numbers=Randoms.pickUniqueNumbersInRange(1,45,6);
```

### Lotto 클래스

- [ ] 제공된 `Lotto` 클래스를 활용해 구현해야 한다.
- [ ] `Lotto`에 매개 변수가 없는 생성자를 추가할 수 없다.
- [ ] `numbers`의 접근 제어자인 private을 변경할 수 없다.
- [ ] `Lotto`에 필드(인스턴스 변수)를 추가할 수 없다.
- [ ] `Lotto`의 패키지 변경은 가능하다.

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

---

## ✏️ 과제 진행 요구 사항

- [ ] 미션은 [java-lotto](https://github.com/woowacourse-precourse/java-lotto) 저장소를 Fork & Clone해 시작한다.
- [ ] **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
- [ ] **Git의 커밋 단위는 앞 단계에서 `docs/README.md`에 정리한 기능 목록 단위**로 추가한다.
    - [ ] [커밋 메시지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 가이드를 참고해 커밋 메시지를 작성한다.
- [ ] 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고한다.











































