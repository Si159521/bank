public class Customer {
    private String[] accountNum;
    private int accountCount;
    private double balance;
    private String id;

    public Customer(String id) {
        this.accountNum = new String[5]; //계좌는 5개까지만 생성 가능
        this.balance = 0;
        this.id = id;
        this.accountCount=0;
    }
    public Customer(){}

    public String[] getAccountNum() {
        return accountNum;
    }
    public double getBalance() { return balance; }
    public String getId() {
        return id;
    }
    public int getAccountCount(){ return accountCount; }
    public void setBalance(double balance) { this.balance = balance; }

    public void addAccountNum(String newAccountNum){
        if (accountCount < 5) {  // 최대 5개의 계좌만 생성 가능
            accountNum[accountCount] = newAccountNum;
            accountCount++;
        } else {
            System.err.println("최대 5개의 계좌만 생성할 수 있습니다.");
        }
    }
}
