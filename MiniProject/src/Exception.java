public class Exception {
    // **InvalidTransactionException**:
    // 입출금 금액이 0 이하이거나 잔액이 부족한 경우.
    public static class InvalidTransactionException extends RuntimeException {
        public InvalidTransactionException(String message) {
            super(message);
        }
    }

    // **AccountNotFoundException**:
    // 계좌 번호로 조회할 때 존재하지 않는 경우.
    public static class AccountNotFoundException extends RuntimeException {
        public AccountNotFoundException(String message) {
            super(message);
        }
    }

    // **BankOperationException**:
    // 고객이나 계좌 등록 시 최대 개수를 초과하는 경우.
    public static class BankOperationException extends RuntimeException {
        public BankOperationException(String message) {
            super(message);
        }
    }
}
