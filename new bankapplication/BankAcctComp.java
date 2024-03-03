import java.util.Comparator;

public class BankAcctComp implements Comparator<Bankaccount> {

    @Override
    public int compare(Bankaccount ba1, Bankaccount ba2) {
        if (ba1.getBankacctnumber().equals(ba2.getBankacctnumber())) {
            return 0;
        } else if (Long.parseLong(ba1.getBankacctnumber()) < Long.parseLong(ba2.getBankacctnumber())) {
            return -1;
        } else {
            return 1;
        }
    }
}
