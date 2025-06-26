import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Москва", "Калининград", 12000, 10, 13);
    Ticket ticket2 = new Ticket("Москва", "Санкт-Петербург", 6000, 18, 19);
    Ticket ticket3 = new Ticket("Москва", "Сочи", 11000, 14,18);
    Ticket ticket4 = new Ticket("Москва", "Челябинск", 24000, 11,22);
    Ticket ticket5 = new Ticket("Москва", "Калининград", 9000, 16, 21);
    Ticket ticket6 = new Ticket("Москва", "Екатеринбург", 6000, 8, 10);
    Ticket ticket7 = new Ticket("Москва", "Волгоград", 8000, 15, 18);
    Ticket ticket8 = new Ticket("Москва", "Воронеж", 4000, 10, 11);

   @Test
   public void thePriceIsHigher() {
       int expected = 1;
       int actual = ticket1.compareTo(ticket2);

       Assertions.assertEquals(expected, actual);
   }

    @Test
    public void thePriceIsLess() {
        int expected = -1;
        int actual = ticket3.compareTo(ticket1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void thePriceIsTheSame() {
        int expected = 0;
        int actual = ticket2.compareTo(ticket6);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void InAscendingOrderOfPrice() {
        AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);
        tickets.add(ticket7);
        tickets.add(ticket8);


        TicketPriceComparator priceComparator = new TicketPriceComparator();

        Arrays.sort(tickets.findAll(), priceComparator);

        Ticket[] expected = { ticket8, ticket2, ticket6, ticket7, ticket5, ticket3, ticket1, ticket4 };
        Ticket[] actual = tickets.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTestOne() {
        AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);
        tickets.add(ticket7);
        tickets.add(ticket8);

        Ticket[] expected = {ticket7};
        Ticket[] actual = tickets.search("Москва", "Волгоград");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTestMany() {
        AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);
        tickets.add(ticket7);
        tickets.add(ticket8);

        Ticket[] expected = {ticket1, ticket5};
        Ticket[] actual = tickets.search("Москва", "Калининград");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ticketTimeComparatorTestAll() {
        AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);
        tickets.add(ticket7);
        tickets.add(ticket8);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Arrays.sort(tickets.findAll(), timeComparator);

        Ticket[] expected = {ticket2, ticket8, ticket6, ticket1, ticket7, ticket3, ticket5, ticket4};
        Ticket[] actual = tickets.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void theTicketIsTheCheapest() {
        AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);
        tickets.add(ticket7);
        tickets.add(ticket8);

        Ticket[] expected = {ticket8};
        Ticket[] actual = tickets.search("Москва", "Воронеж");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void theTicketIsTheMostExpensive() {
        AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);
        tickets.add(ticket7);
        tickets.add(ticket8);

        Ticket[] expected = {ticket4};
        Ticket[] actual = tickets.search("Москва", "Челябинск");

        Assertions.assertArrayEquals(expected, actual);
    }

}
