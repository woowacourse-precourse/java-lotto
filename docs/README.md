# 요구사항 목록

## 기능 목록
- 사용자입력값: camp.nextstep.edu.missionutils.Console의 readLine() 사용
- 랜덤값 추출:camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange() 사용

#### 구입금액 입출력 기능(A)
- [ ] "구입금액을 입력해 주세요." 출력(A-1)
- [ ] 구입금액 입력받음(A-2)
- [ ] 사용자 입력에 따른 예외처리(EXC-A)


#### 로또번호 생성(B)
- [ ] 6개의 로또번호 생성(B-1)
    - 1개의 로또는 숫자만으로 이루어진 6개 List
    - 6개의 숫자 서로 다른 숫자(중복x)
    - 1~45사이의 숫자
- [ ] 생성된 로또번호 오름차순 정렬(B-2)

##### 구매내역에 따른 로또번호 출력(C)
- [ ] "N개를 구매했습니다." 출력(C-1)
- [ ] N개의 로또 번호 출력(C-2)

#### 당첨번호, 보너스 번호 입출력(D)
- [ ] "당첨 번호를 입력해 주세요." 출력(D-1)
- [ ] 6개의 숫자 입력받음(D-2)
  - ","를 구분자로 사용화
- [ ] 유효성 검사(EXC-B)
- [ ] 6개 숫자 정렬
- [ ] "보너스 번호를 입력해 주세요." 출력(D-3)
- [ ] 보너스 번호 입력(D-4)
- [ ] 번호 입력시 예외처리(EXC-B)

#### 당첨결과 (E)
- [ ] 3개 일치(E-1)
- [ ] 4개 일치(E-2)
- [ ] 5개 일치(E-3)
- [ ] 5개 일치, 보너스볼 일치(E-4)
- [ ] 6개 일치(E-5)
- [ ] 수익률 계산(E-6)
- [ ] 결과값 출력(E-7)



## 예외처리 목록(EXC)
- 사용자가 잘못된 값을 입력한경우는 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 메시지 출력 후 프로그램 종료

#### 구입금액 입출력 예외처리(EXC-A)
- [ ] 구입금액이 1000원으로 나누어 떨어지지 않는경우(EXC-A-1)
  - IllegalArgumentException, "[ERROR] 로또 구입금액은 1000원단위의 금액만 입력가능합니다." 
- [ ] 그 외 숫자가 아닌 문자가 섞여있는경우(EXC-A-2)
  - IllegalArgumentException, "[ERROR] 숫자만 입력가능합니다.(ex - 14000)" 
- [ ] 1000원이상이 아닌경우(EXC-A-3)
  - - IllegalArgumentException, "[ERROR] 구매금액은 1000원이상이어야합니다."

#### 당첨번호 입력시 예외처리(EXC-B)
- [ ] 1~45 사이의 숫자가 아닌경우(EXC-B-1)
  - IllegalArgumentException, "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
- [ ] 1~6숫자, 보너스번호 중 중복된 숫자가 있는경우(EXC-B-2)
  - IllegalArgumentException, "[ERROR] 중복된 숫자는 입력이 불가합니다."
- [ ] 그 외 숫자가 아닌 문자가 섞여있는경우(EXC-A-2 재사용)
- [ ] 구분자 "," 형식에 맞지 않는경우
  - IllegalArgumentException, "[ERROR] 다음예제와 같이 입력하여 주십시오.(ex - 1,2,3,4,5,6)"


## 리팩토링 목록
- [ ] Valid class내의 함수는 삭제하고 객체에 맞게 유효성 검사 함수 재구성(RF-1)
  - [ ] Purchase class내 유효성 함수 로직 추가(Valid에 있는것 이동)(RF-1-2)
- [ ] 유효성 검사 로직은 공통적으로 사용하는것이 아니라면 객 객체에 속해야한다.(RF-2)
  - [ ] Valid함수내 있는 Lotto 번호 관련 유효성 검사 리팩토링(RF-2-1)
  - [ ] view 패키지 내 클래스들 안에서 유효성검사는 올바르지 않다.->각 도메인에 속하도록 구성한다.(RF-2-2)
- [ ] ConsoleMessage 리팩토링 (RF-3)
  - [ ] MESSAGE_PURCHASE_LOTTO 리네이밍 (RF-3-1)
  - ~개를 구매했습니다 상수화 (RF-3-2)

## 프로그래밍 요구사항

1. 클래스(객체)를 분리하는 연습
2. 도메인 로직에 대한 단위 테스트를 작성하는 연습

- indent depth는 2까지 허용
- 3항연산자 사용 X
- 함수는 하나의 일만 하도록 구성
- 함수는 15라인이 넘어가서는 안됨
- else, switch/case 사용 X
- Enum 사용
- 도메인 로직에 단위테스트구현
  - UI(System.out, System.in, Scanner) 로직은 제외한다.
- camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
- 제공된 Lotto class 사용
  - Lotto에 매개 변수가 없는 생성자를 추가할 수 없다.
  - numbers의 접근 제어자인 private을 변경할 수 없다.
  - Lotto에 필드(인스턴스 변수)를 추가할 수 없다.
  - Lotto의 패키지 변경은 가능하다.