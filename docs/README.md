# 기능 목록

## 로또 사기
- [x] 구매 문구 출력 (`InputView`)
- [x] `UserService`를 통해 User 생성
    - [x] `Lotto` 클래스 `valiate` 구현
        - [x] 6개의 숫자인지 확인
        - [x] 1 ~ 45 사이의 숫자인지 확인
        - [x] 중복된 숫자가 있는지 확인
    - [x] `Lotto` 를 상속받은 `LotteryTicket` 클래스 구현
    - [x] `User` 클래스 구현
        - [x] `money` 1000원 단위 검증
        - [x] 로또 구매 메서드 구현
        - [x] 유저가 가진 로또티켓의 번호 정보만 담아 List로 반환
    - [x] `UserService` 의 `createUser` 메서드 구현
- [x] `LotterySellService`를 통해 로또 구매
    - [x] 판매된 로또 티켓을 저장하는 `LotteryTicketRepository` 싱글톤으로 구현
    - [x] 로또 티켓 생성 기능
    - [x] User의 구매 금액 만큼 로또 사기
- [x] 구매 로또 출력 (`OutputView`)
- [x] `UserController` 의 로또 구매 부분 구현

## 로또 추첨
- [x] `Lotto` 를 상속받은 `LotteryWinningNumber` 클래스 구현
- [ ] 당첨 번호 생성 기능 구현
    - [x] 로또 당첨 번호 입력 받기 (`InputView`)
    - [ ] 보너스 번호 입력 받기 (`InputView`)
    - [ ] `LotteryDrawService`를 통해 당첨 번호 생성
- [ ] `LotteryDrawService`를 통해 판매된 티켓의 당첨 여부 계산 기능 구현
- [ ] `LotteryController` 로또 추첨 구현

## 로또 결과 조회
- [ ] 유저가 구매한 로또 당첨 결과를 담는 `LotteryResult` 클래스 구현
- [ ] `LotteryCheckService` 를 통해 로또 당첨 결과 조회 기능 구현
- [ ] 구매 결과 문구 출력 (`OutputView`)
- [ ] `UserController` 유저 로또 결과 조회 부분 구현

---

# 클래스 목록
## Model (domain)
- `User`
- `LotteryTicket`
- `LotteryWinningNumber`
- `LotteryTicketRepository`
- `LotteryResult`

## View
- `InputView`
- `OutputView`

## Controller
- `UserController`
- `LotteryController`

## Service
- `UserService`
- `LotterySellService`
- `LotteryDrawService`
- `LotteryCheckService`