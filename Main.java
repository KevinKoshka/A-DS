import creditcard.CreditCard;
import cypher.CaesarCypher;
import lists.SingleLinkedList;

import java.util.AbstractMap.SimpleEntry;

public class Main {
    public static void creditsTest() {
        CreditCard[] wallet = new CreditCard[3];
        
        wallet[0] = new CreditCard("John Bowman", "California Savings", "2345 1585 2678 2381", 5000);
        wallet[1] = new CreditCard("John Bowman", "California Federal", "9076 6759 3890 1596", 3500);
        wallet[2] = new CreditCard("John Bowman", "Banco Provincia", "0762 2345 1289 6327", 2500, 300);
    
        for (int val = 1; val <= 16; val++) {
            wallet[0].charge(3*val);
            wallet[0].charge(2*val);
            wallet[0].charge(val);
        }
    
        for (CreditCard card: wallet) {
            CreditCard.printSummary(card);
            while (card.getBalance() > 200.0) {
                card.makePayment(200);
                System.out.println("New balance = " + card.getBalance());
            }
        }
    }

    public static void cypherTest() {
        CaesarCypher newCypher = new CaesarCypher(12);
        String msg = "YOU WILL BE DESTROYED";
        System.out.println("Unencoded message: " + msg);
        System.out.println("Encoded message:   " + newCypher.encode(msg));
        System.out.println("Decoded message:   " + newCypher.decode(newCypher.encode(msg)));
    }

    public static void sllTest() {
        SimpleEntry<String, String> mica = new SimpleEntry<>("Name", "Micaela Premat");
        SimpleEntry<String, String> fede = new SimpleEntry<>("Name", "Federico Bracone");
        SimpleEntry<String, String> juli = new SimpleEntry<>("Name", "Juliana Fernández");
        SimpleEntry<String, String> orion = new SimpleEntry<>("Name", "Orión");
        SimpleEntry<String, String> astra = new SimpleEntry<>("Name", "Astra");
        SimpleEntry<String, String> parka = new SimpleEntry<>("Name", "Parka");

        SingleLinkedList<SimpleEntry<String, String>> myList = new SingleLinkedList<>();
        myList.insertFirst(fede);
        myList.insertFirst(orion);
        System.out.println(myList.toString());
        myList.insertLast(parka);
        myList.insertFirst(mica);
        myList.insertLast(astra);
        myList.insertFirst(juli);
        System.out.println(myList.toString());
        myList.removeFirst();
        System.out.println(myList.toString());
    }
    public static void main(String[] args) {
        Main.sllTest();
    }
}

