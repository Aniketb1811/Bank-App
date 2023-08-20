import javax.sound.midi.Soundbank;

public class Main {
    public static void main(String[] args) {
        SBIAccount Aniket = new SBIAccount("Aniket", "Aniket123", 5000);

        System.out.println(Aniket);

        //fetch balance
        System.out.println(Aniket.fetchBalance("Aniket")); //incorrect password
        System.out.println(Aniket.fetchBalance("Aniket123")); //correct password

        //addMoney
        System.out.println(Aniket.addMoney(100000));

        //withdrawMoney
        System.out.println(Aniket.withdrawMoney("Aniket", 50000)); //Incorrect password
        System.out.println(Aniket.withdrawMoney("Aniket123", 2000000)); //wrong amount
        System.out.println(Aniket.withdrawMoney("Aniket123", 105000));
        System.out.println(Aniket.withdrawMoney("Aniket123", 50000));

        //changePassword
        System.out.println(Aniket.changePassword("Aniket123", "Aniket123")); //new pwd is same as old pwd
        System.out.println((Aniket.changePassword("Aniket", "Aniket99")));  //wrong old pwd
        System.out.println((Aniket.changePassword("Aniket123", "Aniket99"))); //correct information

        //calculate RoI
        System.out.println(Aniket.calculateInterest(5));

    }
}