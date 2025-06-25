import java.util.Comparator;

public class TicketPriceComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        int price1 = t1.getPrice();
        int price2 = t2.getPrice();
        if (price1 < price2) {
            return -1;
        } else if (price1 > price2) {
            return 1;
        } else {
            return 0;
        }
    }
}

