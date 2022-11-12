# 기능 목록

## 로또 사기
- [ ] 구매 문구 출력 (`InputView`)
- [ ] `UserService`를 통해 User 생성
  - [ ] `Lotto` 클래스 `valiate` 구현
  - [ ] `Lotto` 를 상속받은 `LotteryTicket` 클래스 구현
  - [ ] `User` 클래스 구현
  - [ ] `UserService` 의 `createUser` 메서드 구현
- [ ] `LotterySellService`를 통해 로또 구매
    - [ ] `LotteryTicketRepository` 싱글톤 구현
    - [ ] 로또 번호 생성 구현
    - [ ] User의 구매 금액 만큼 로또 사기
- [ ] 구매 로또 출력 (`OutputView`)
- [ ] `UserController` 의 로또 구매 부분 구현

## 로또 추첨
- [ ] `Lotto` 를 상속받은 `LotteryWinningNumber` 클래스 구현
- [ ] 로또 추첨 문구 출력 (`InputView`)
- [ ] `LotteryDrawService`를 통해 당첨 번호 생성 기능 구현
- [ ] 보너스 번호 입력 문구 출력 (`InputView`)
- [ ] `LotteryDrawService`를 통해 보너스 번호 생성 기능 구현
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