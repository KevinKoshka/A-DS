package creditcard;

/**
 * A simple model for a consumer credit card.
 * 
 * @author Kevin Coscarelli
 */

public class CreditCard {
    private String customer;
    private String bank;
    private String account;
    private int limit;
    protected double balance;

    /**
     * Constructs a new credit card instance.
     * @param cust          The name of the customer (e.g.: "John Bowman")
     * @param bk            The name of the bank (e.g.: "California Springs")
     * @param acnt          The account number (e.g.: "1234 5678 9101 1121")
     * @param lim           The credit card limit
     * @param initialBal    The initial balance (optional)
     */
    public CreditCard(String cust, String bk, String acnt, int lim, double initialBal) {
        customer = cust;
        bank = bk;
        account = acnt;
        limit = lim;
        balance = initialBal;
    }

    public CreditCard(String cust, String bk, String acnt, int lim) {
        this(cust, bk, acnt, lim, 0.0);
    }
    
    public String getCustomer() {
        return customer;
    }
    public String getBank() {
        return bank;
    }
    public String getAccount() {
        return account;
    }
    public int getLimit() {
        return limit;
    }
    public double getBalance() {
        return balance;
    }
    /**
     * Charges the given price to the card, assuming sufficient credit limit.
     * @param price The amount to be charged.
     * @return true if charge was accepted; false if charge was denied
     */
    public boolean charge(double price) {
        if (price + balance > limit) {
            return false;
        }
        balance += price;
        return true;
    }
    /**
     * Processes customer payment that reduces balance.
     * @param amount the amount of payment made
     */
    public void makePayment(double amount) {
        balance -= amount;
    }

    public static void printSummary(CreditCard card) {
        System.out.println("Customer = " + card.customer);
        System.out.println("Bank = " + card.bank);
        System.out.println("Account = " + card.account);
        System.out.println("Balance = " + card.balance);
        System.out.println("Limit = " + card.limit);
    }
}