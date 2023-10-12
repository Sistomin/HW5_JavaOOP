package presenters;

import java.util.Date;
public interface ViewObserver {

    void onReservationTable(Date orderDate, int tableNo, String name);

    // добавил
    void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);

}
