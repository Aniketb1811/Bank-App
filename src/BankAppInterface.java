public interface BankAppInterface {
    String  fetchBalance(String password);

    String addMoney(double amount);

    String withdrawMoney(String password, double amount);

    String changePassword(String oldPassword, String newPassword);

    double calculateInterest(int years);
}
