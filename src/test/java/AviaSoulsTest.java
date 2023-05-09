import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    @Test
    public void shouldSortTicketsByPrice() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("MSK", "MMK", 5000, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "MMK", 8000, 14, 16);
        Ticket ticket3 = new Ticket("MSK", "SPB", 3000, 9, 10);
        Ticket ticket4 = new Ticket("MSK", "VVO", 15000, 8, 16);
        Ticket ticket5 = new Ticket("MSK", "VVO", 25000, 10, 18);
        Ticket ticket6 = new Ticket("MSK", "SPB", 3000, 11, 12);
        Ticket ticket7 = new Ticket("MSK", "VVO", 20000, 11, 19);
        Ticket ticket8 = new Ticket("MSK", "VVO", 15000, 9, 16);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket4, ticket8, ticket7, ticket5};
        Ticket[] actual = manager.search("MSK", "VVO");

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldSortTicketsByPriceNoFound() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("MSK", "MMK", 5000, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "MMK", 8000, 14, 16);
        Ticket ticket3 = new Ticket("MSK", "SPB", 3000, 9, 10);
        Ticket ticket4 = new Ticket("MSK", "VVO", 15000, 8, 16);
        Ticket ticket5 = new Ticket("MSK", "VVO", 25000, 10, 18);
        Ticket ticket6 = new Ticket("MSK", "SPB", 3000, 11, 12);
        Ticket ticket7 = new Ticket("MSK", "VVO", 20000, 11, 19);
        Ticket ticket8 = new Ticket("MSK", "VVO", 15000, 9, 16);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("MSK", "RGK");

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldSortTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("MSK", "MMK", 8000, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "MMK", 5000, 14, 17);
        Ticket ticket3 = new Ticket("MSK", "SPB", 3000, 9, 10);
        Ticket ticket4 = new Ticket("MSK", "VVO", 15000, 8, 17);//9
        Ticket ticket5 = new Ticket("MSK", "VVO", 25000, 6, 18);//12
        Ticket ticket6 = new Ticket("MSK", "SPB", 3000, 11, 12);
        Ticket ticket7 = new Ticket("MSK", "VVO", 20000, 11, 19);//8
        Ticket ticket8 = new Ticket("MSK", "VVO", 15000, 9, 19);//10

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket7, ticket4, ticket8, ticket5};
        Ticket[] actual = manager.search("MSK", "VVO", comparator);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSortTicketsWithComparatorNoResults() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("MSK", "MMK", 8000, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "MMK", 5000, 14, 17);
        Ticket ticket3 = new Ticket("MSK", "SPB", 3000, 9, 10);
        Ticket ticket4 = new Ticket("MSK", "VVO", 15000, 8, 17);//9
        Ticket ticket5 = new Ticket("MSK", "VVO", 25000, 6, 18);//12
        Ticket ticket6 = new Ticket("MSK", "SPB", 3000, 11, 12);
        Ticket ticket7 = new Ticket("MSK", "VVO", 20000, 11, 19);//8
        Ticket ticket8 = new Ticket("MSK", "VVO", 15000, 9, 19);//10

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.search("MSK", "RGK", comparator);

        Assertions.assertArrayEquals(expected, actual);

    }

}