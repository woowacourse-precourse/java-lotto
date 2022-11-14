# 3주차 java-lotto 미션

- [미션 개요](../README.md)
- 계속 업데이트 중 - `살아있는 문서`
- 어플리케이션 2차 리팩터링 (ver 3.0)
- MVC 패턴 적용 상황 (ver 2.0)
- 문서 구성 (ver 1.0)
  - <번호> 기능
  - 기능 목록
  - 예외 처리
  - 도메인 로직에 대한 단위 테스트
  - (오류 처리)


## 🗄 어플리케이션 2차 리팩터링 (ver 3.0)
### 1. View 차원의 유효성 검증 / 도메인(Model) 로직 차원의 유효성 검증 분리
- Purchase, WinningNumbers, BonusNumber 클래스
  - input String 유효성 검증은 utils/Validator 로 분리
    - 하나의 Validator 여러 View 메소드 재활용 가능
  - 입력된 자료 구조(int, List<Integer> 등)에 대한 `비즈니스 로직(도메인 로직)` 유효성 검증만 Model 클래스에서 처리

### 2. 클래스의 생성자 매개변수로 클래스를 지정
- Model 들을 `일급 객체`화 하여 더 캡슐화되고 기능이 분리된 객체 지향 구현
  - ex) 매개변수에 직접 클래스 할당
```java
    /*
    Purchase purchase = new Purchase(inputAmount);
    int amount = purchase.getAmount();
    LottoTickets lottoTickets = new LottoTickets(amount);
    */

    Purchase purchase = new Purchase(inputAmount);
    LottoTickets lottoTickets = new LottoTickets(puchase);
```
  - ex) Lotto 클래스를 `일급 객체`화 함으로써 WinningNumbers, LottoTickets 의 Lotto 숫자 생성에 활용

### 3. Prize Enum 클래스 , Result 클래스 생성
- Enum 클래스를 key로 하는 HashMap에 등수별 결과값 int 저장
- output/SummaryView 결과값 반환에 활용

### 4. Controller 클래스 생성
- Application 클래스 main 메소드의 기능을 분담
- 전체 기능 크게 4개 별로 메소드 분리

### 5. 기타 변화
- 클래스 이름 및 메소드 이름 명료화 - `의미 있는 이름 짓기`
- 함수 분리
  - 한 함수가 한 가지 기능만 담당
- 문자열, 숫자 값 하드 코딩 리팩터링
  - `static final`로 상수화
  - 출력문 및 Exception 메세지에도 활용

## 🗂 MVC 패턴 적용 (ver 2.0)
### 1. Model
- 로또
  - 구입 금액 유효성 검증 및 인스턴스 필드 저장
  - 로또 번호 유효성 검증 및 인스턴스 필드 저장
  - 로또 묶음 클래스(Lottery)
    - 구입 수량만큼 원소의 수를 가진 List 생성
    - List의 각 원소는 로또 클래스
- 당첨 번호
  - 당첨 번호 유효성 검증 및 인스턴스 필드 저장
    - 당첨 번호로 로또 클래스 생성
- 보너스 번호
  - 보너스 번호 유효성 검증 및 인스턴스 필드 저장

### 2. View
- input
  - 구입 금액 입력
  - 당첨 번호 입력
  - 보너스 번호 입력
- output
  - 구매 내역 출력
  - 당첨 결과 출력
  - 수익률 출력

### 3. Controller
- 당첨 등수별 계산
  - 로또 묶음 만큼 looping 돌기
  - 등수 정보 인스턴스 필드에 갱신


## 🗒 구현할 기능 목록 (ver 1.0)

## 1. 구입 금액 입력
- [x] 로또 구입 금액을 입력하면 구입 수량을 반환한다
  - [x] 로또 1장의 가격은 1,000원
  - [x] 1,000원 단위로 입력
### 예외 처리
- [x] 빈 입력일 경우
- [x] 숫자 입력이 아닌 경우
- [x] 1,000원으로 나누어 떨어지지 않는 경우
### 테스트
- [x] 예외 처리 테스트
- [x] 입력 금액에 대한 발행 수 테스트


## 2. 로또 만들기
- [x] 로또 클래스를 만든다
  - [x] 들어온 List 값 유효성 검사
  - [x] 올바른 List 반환 메소드 추가
### 예외 처리
- [x] 6개의 숫자가 아닌경우
- [x] 1<=lotto<=45가 아닌 경우
- [x] 모두 다른 숫자가 아닐 경우
### 테스트
- [x] 예외 처리 테스트
- [x] 올바른 입력에 대한 로또 값 반환 테스트


## 3. 로또 묶음 발행
- [x] 구입 수량만큼 로또 묶음을 발행한다
  - [x] List<Lotto> 자료형을 사용
  - [x] 구입 수량만큼 로또 객체를 만들어 List에 넣는다
  - [x] 로또 번호는 오름차순으로 정렬
### 예외 처리
- [x] Lotto 객체 성성자 내 validate 사용
### 테스트
- [x] 구입 수량만큼 올바르게 생성되는지 테스트
- [x] 생선된 List의 원소가 모두 Lotto 객체인지 테스트
### 오류 처리
- [x] immutable list에 대한 처리를 한다
  - [x] unmodifiableList를 선언
  - [x] new ArrayList로 unmodifiableList copy
  - [x] copy된 newList sorting


## 4. 발행 결과 출력
- [x] 발행한 로또 수량 및 번호 출력
  - [x] 로또 수량 정보 출력
  - [x] Lottery 객체의 size 만큼 looping 돌며 번호 출력


## 5. 당첨 번호, 보너스 번호 입력
- [x] 당첨 번호 / 보너스 번호를 입력받는다
  - [x] 당첨 번호 추첨 시 중복되지 않는 숫자 6개 + 보너스 번호 1개를 뽑는다
  - [x] 번호는 쉼표(,)를 기준으로 구분
### 예외 처리
- 당첨 번호
  - [x] 쉼표로 구분되지 않았을 경우
  - [x] 번호 6자리 아닐 경우
  - [x] 숫자가 아닌 경우
  - [x] Lotto 객체를 생성하며 lotto 클래스 내부 validate 처리
- 보너스 번호
  - [x] 빈 값을 입력한 경우
  - [x] 숫자 맞는지
  - [x] 범위 유효한지
  - [x] 당첨 번호와 중복 여부
### 테스트
- [x] 예외 처리 테스트
- [x] 올바른 입력에 대한 당첨 번호List / 보너스 번호값 반환 테스트


## 6. 당첨 여부 확인
- [x] 구매한 로또 번호와 당첨 번호, 보너스 번호를 비교한다
  - [x] 당첨은 1등 부터 6등까지
  - [x] Lottery 객체의 size 만큼 looping 돌기
    - [x] 1등부터 6등까지 각각 등수 갯수를 갱신


## 7. 당첨 결과 출력
- [x] 당첨 내역 및 수익률을 출력한다
- [x] Enum 클래스를 적용한다
  - [x] 당첨 내역 출력
  - [x] 수익률 출력
    - [x] 수익률은 소수점 첫째 자리까지(둘째 자리에서 반올림)
- [x] 게임을 종료한다
### 오류 처리
- [x] exception을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료
  - [x] Application 전체를 try-catch 문으로 감싸기
  - [x] catch문에 IllegalArgumentException
    - [x] 에러 메시지 출력하기
    - [x] 에러 로그 남기기
  - [x] 혹시 모를 에러에 대비히 부모 Exception 클래스 다중 catch문 처리
    - [x] 에러 로그 남기기


## 기타. 고려사항
### 예외 처리
- [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시킨다
  - [x] "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료
### 테스트
- [x] 도메인 로직에 단위 테스트 구현 / 단, UI(System.out, System.in, Scanner) 로직은 제외
- [x] 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현
