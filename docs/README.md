## 🎰 로또 (박정윤)

### < 기능 구현 목록 >

### 메인 MVP (로또 게임 프로세스)

- [x] <입력> 로또 구입 금액
    - `포맷` 구입금액을 입력해 주세요.
    - `포맷` 8000
    - [x] `예외 처리`
        - [x] 숫자가 아닌 값이 들어온 경우
        - [x] 입력이 1000보다 작은 경우
        - [x] 1,000원으로 나누어 떨어지지 않는 경우
        - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료
- [x] <출력> 발행한 로또 수량 및 번호
    - 오름차순으로 정렬
    - `포맷` 8개를 구매했습니다.
    - `포맷` [8, 21, 23, 41, 42, 43]
- [x] <입력> 당첨 번호
    - `포맷` 당첨 번호를 입력해 주세요.
    - `포맷` 1,2,3,4,5,6
    - [x] `예외 처리`
        - [x] 숫자가 아닌 값이 들어온 경우
        - [x] 입력한 숫자가 6개가 아닌 경우
        - [x] 숫자가 1과 45를 벗어나는 경우
        - [x] 숫자에 중복이 있는 경우
        - 잘못된 값인 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료
- [x] <입력> 보너스 번호
    - `포맷` 보너스 번호를 입력해 주세요.
    - `포맷` 7
    - [x] `예외 처리`
        - [x] 숫자가 아닌 값이 들어온 경우
        - [x] 숫자가 1과 45를 벗어나는 경우
        - [x] 숫자에 중복이 있는 경우
        - 잘못된 값인 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료
- [x] <출력> 당첨 내역
    - `포맷` 당첨 통계
    - `포맷` ---
    - `포맷` 3개 일치 (5,000원) - 1개
    - `포맷` 총 수익률은 62.5%입니다.
        - 수익률은 소수점 둘째 자리에서 반올림

### 로또 번호 생성

- [x] 랜덤 숫자 6개

### 로또 게임 로직

- [x] 당첨 기준과 금액
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원

<br>

### < 프로그램 요구사항 체크리스트 >

- [x] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현. 2까지만 허용.
- [x] 3항 연산자를 쓰지 않는다.
- [x] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게.
- [x] JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인.
- [x] 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현.
- [x] else 예약어를 쓰지 않는다.
- [x] Java Enum을 적용.
- [x] 도메인 로직에 단위 테스트를 구현. UI(System.out, System.in, Scanner) 로직은 제외.

<br>

### < 폴더 구조 >

```
├─main
│  └─java
│      └─lotto
│          │  Application.java        - 로또 게임 애플리케이션 실행 
│          │
│          ├─controller
│          │      LottoGame.java      - domain-view를 연결하여 게임 순서 결정
│          │
│          ├─domain
│          │      GenerateNumbers.java   - 랜덤 6개 숫자 리스트를 만드는 객체 (구현체)
│          │      GenerateRandomNumbersImpl.java   - 랜덤 6개 숫자 리스트를 만드는 객체의 인터페이스
│          │      Lotto.java          - 로또 객체
│          │      LottoResult.java    - 당첨 내역
│          │      Lottos.java         - 구매한 로또 객체
│          │      Rank.java           - 순위에 따른 당첨 개수, 보너스 일치 여부, 상금 enum 객체
│          │      WinningLotto.java   - 당첨 번호를 가지고 있는 객체 
│          │
│          ├─util
│          │      Transform.java      - data의 형태를 변환하고 형변환하는 util 함수
│          │
│          ├─validator
│          │      LottoValidator.java     - 로또 숫자에 대한 예외 처리
│          │      NumberValidator.java    - 한 개 숫자에 대한 예외 처리
│          │
│          └─view
│                  InputView.java     - Console에서 Player의 input을 받기
│                  OutputView.java    - Console에서 Player에게 output 보여주기
│
└─test
    └─java
        └─lotto
            │  ApplicationTest.java
            │  LottoTest.java
            │
            ├─domain
            │      WinningLottoTest.java
            │
            └─util
                    TransformTest.java
```

---

> 지금부터는 프로그램을 구현하면서 고민하고 도전한 것들에 대해 소개해드리겠습니다.
> 내용이 과하다고 생각될 수 있으나, README.md 파일은 프로그램에 대한 명세를 위한 자료이지만 동시에 프로그램 구현에 대한 소개도 포함될 수 있다고 판단하여 내용을 추가하게 되었습니다.

📎 [자세한 회고 포스팅](https://hello-judy-world.tistory.com/182)

### 🚀 새롭게 도전한 것들 (혹은 구현하면서 고려한 점)

1️⃣ **Random Numbers**

이전 미션인 숫자 야구 게임과 동일하게 랜덤한 숫자를 받아오는 기능이 필요했다.

이전과 달라진 점은

- 숫자 야구 게임: 게임 인스턴스 하나에 랜덤 숫자가 한 번만 불러온다. 그리고 그 숫자가 유지된다.
- 로또: 게임 인스턴스 하나에 랜덤 숫자를 생성하는 메서드를 여러번 호출한다.

그래서 인스턴스 생성 시 랜덤 숫자가 인스턴스 변수에 할당되던 코드에서 클래스의 메서드를 호출해서 랜덤 숫자를 받는 코드로 변경했다.

2️⃣ **validator 상속**

현재 나는 숫자 1개에 대한 validation과 숫자 여러 개에 대한 validation으로 validator를 분리해서 구현하고 있다.

이때 input 값이 숫자인지 확인하는 코드가 중복되었다.

1. input 들어온 숫자가 숫자가 맞는지 확인
2. `1,2,3,4,5,6` 로 들어온 input을 `[1,2,3,4,5,6]` 형태로 만든 리스트가 숫자로 이루어졌는지 확인

그래서 NumberValidator를 NumbersValidator에서 상속받아 구현했다.
(최대한 중복 코드를 줄이고 객체 지향으로 설계하고 싶어 노력하지만 아직 부족하고 이 방법이 맞는지 확신이 없다!! 하지만 계속 노력하고 공부해나가자!!)

3️⃣ **Enum type**

<br>

### 🧐 구현하면서 고민했던 것들

1️⃣ **validation은 누구의 역할일까?**

항상 고민했다. validation은 어디서 해야 할까. 현재 폴더 구조에서 Controller, Domain, View 중 누군가 담당해야 한다.

이전 숫자 야구 게임에서는 프로그램의 가장 앞단에서 걸러주어야 한다고 생각하여 View에서 대부분 validation 해주었다.

이번에는 View에서는 정말 input만 받고 완전히 Controller와 Domain으로 그 책임을 넘겨주려고 했지만

❗View에서 사용자 입력에 대해 최소한의 유효성은 확인해주어야 한다.

현재 프로그램에서 최소한의 유효성(ex.숫자를 입력받는다.)과 도메인 요구사항(ex.1000으로 나누어 떨어진다.)로 나뉜다.

🚩**결론** : <u>입력을 받는 최소한의 예외 처리는 View에서 나머지 규칙에 따른 예외 처리는 필요한 위치에서!</u>

유효성 검사를 두 가지 성격으로 나누니 고민이 해결되었다!! 그리고 이런 것을 결정하는 것은 정답은 없고 개발자의 설계에 따라 달라진다.

<br>

### 😫 험난한 트러블 슈팅

1️⃣ **ImmutableCollections**

- `시도 1` 랜덤 숫자 리스트를 불변 -> 가변으로 변경해서 정렬

프로그래밍 요구사항에 맞추어 camp.nextstep.edu.missionutils에서 제공하는 Randoms를 사용하고 있다. 이때 나는 랜덤 6개의 숫자 리스트를 정렬해서 변경하고자 했다.

불변 컬렉션을 수정하고자 해서 오류가 나고 있다. 그래서 주어진 Randoms 클래스의 구현체를 확인해보니 subList로 List의 일부를 잘라 사용하고 있었다. 이때 ArrayList의 SubList는 자신이
생성된 parent 값을 가지고 있다고 한다.
그래서 수정할 수 없는 리스트라면 수정할 수 있는 리스트를 생성해주었다.

```
public List<Integer> generateRandomNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, LOTTO_COUNT);
        List<Integer> modifiableLottoNumbers = new ArrayList<Integer>(lottoNumbers);
        Collections.sort(modifiableLottoNumbers);
        return modifiableLottoNumbers;
    }
```

- `시도 2` 원본 데이터를 수정하지 않고 정렬

랜덤 숫자 리스트를 정렬하기 위해서 원본 데이터를 수정할 수 있는 형태로 생성했다. 하지만 시간이 지나고 고민하니 객체의 설계상 랜덤 숫자 데이터는 변경되면 안 된다는 생각이 들었다.

❗또한 원본 데이터의 수정을 가하지 않는 방법이 더욱 좋은 코드라고 생각했다.

그래서 원본 데이터의 수정 없이 정렬하는 형태를 다시 찾아 발견한 게 Stream API이다. Stream API를 제대로 사용해본 적이 없어 자바의 정석을 펼쳐 공부했다. 그리고 최종적으로 코드를 완성해서 원본
데이터를 지키며 정렬할 수 있었다.

```
public List<Integer> generateRandomNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, LOTTO_COUNT);
        List<Integer> sortedLottoNumbers = lottoNumbers.stream().sorted().collect(Collectors.toList());
        return sortedLottoNumbers;
    }
```

2️⃣ **예외 처리**

이번 미션의 가장 험난한 트러블 슈팅이었다. 주어진 요구사항 문서를 제대로 파악하는 것에 중요성을 깨달았고 여러 디버깅을 해보면서 문제를 결국 해결해내는 뿌듯함을 얻었다.
주어진 테스트 코드를 뜯어보니 output()에 [ERROR]가 포함되었는지로 테스트 성공 여부를 판단하고 있다.

그래서 output()이 어떤 값이 넘어오고 있는지 출력해봤다. output()에 아무 값도 넘어오지 않는다. 이유를 곰곰이 생각해보며 위에 다른 케이스에도 output()을 출력해보았다. Application에서
로직을 실행시켜 출력된 값들이 output()에 전부 담겨있었다.

그리고 Application.java에서 에러가 나왔을 때 그 에러 메세지 출력을 Application.java에서 해줘야 하는 것을 깨달았다.

```java
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            LottoGame lottoGame = new LottoGame();
            lottoGame.startLottoGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

