import java.util.UUID;

public class SBIAccount implements BankAppInterface{

    private String name;

    private String accountNo;

    private String password;

    private double balance;

    final String IFSCCode = "SBI0008891";

    final double rateOfInterest = 7.5;

    final double minBalance = 500.00;

    public SBIAccount() {
    }

    public SBIAccount(String name, String password, double balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.accountNo = String.valueOf(UUID.randomUUID());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    @Override
    public String fetchBalance(String password) {
        if(this.password.equals(password)){
            return "Your balance is : " + this.balance;
        }

        return "Incorrect Password!!!";
    }

    @Override
    public String addMoney(double amount) {
        this.balance += amount;
        return "Amount added successfully. Your balance is : " + this.balance;
    }

    @Override
    public String withdrawMoney(String password, double amount) {

        if(this.password.equals(password)){

            if(this.balance < amount){
                return "Insufficient funds!";
            }

            if( this.balance - amount < minBalance){
                return "Minimum balance should be 500 Rs.";
            }

            this.balance -= amount;
            return "Amount debited successfully. Your balance is : " + this.balance;
        }

        return "Incorrect password!!!";
    }

    @Override
    public String changePassword(String oldPassword, String newPassword) {
        if(this.password.equals(oldPassword)){
            if(newPassword.equals(oldPassword)){
                return "New password is same as old password. Try again!";
            }
            this.password = newPassword;
            return "Password changed successfully.";
        }

        return "Incorrect original password!";
    }

    @Override
    public double calculateInterest(int years) {
        return ((this.balance * rateOfInterest * years)/100.0);
    }

    @Override
    public String toString() {
        return "SBIAccount{" +
                "name='" + name + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", IFSCCode='" + IFSCCode + '\'' +
                ", rateOfInterest=" + rateOfInterest +
                ", minBalance=" + minBalance +
                '}';
    }
}
