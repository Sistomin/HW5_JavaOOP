package presenters;

import models.Table;

import java.util.Collection;
import java.util.Date;


public class BookingPresenter implements ViewObserver {

    private final Model model;
    private final View view;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        view.setObserver(this);
    }

    /**
     * Получение списка всех столиков
     */
    private Collection<Table> loadTables(){
        return model.loadTables();
    }

    /**
     * Отобразить список столиков
     */
    public void updateUIShowTables(){
        view.showTables(loadTables());
    }

    /**
     * Отобразить результат бронирования столика
     * @param reservationNo номер бронирования
     */
    private void updateUIShowReservationTableResult(int reservationNo){
        view.showReservationTableResult(reservationNo);
    }

    // добавил
    /**
     * Отобразить результат замены бронирования столика
     * @param oldReservation номер старого бронирования
     */
    private void updateUIShowCancelReservationTableResult(int oldReservation){
        view.showCancelReservationTableResult(oldReservation);
    }


    /**
     * Произошло событие, пользователь нажал на кнопку резерва столика
     * @param orderDate дата резерва
     * @param tableNo номер столика
     * @param name имя клиента
     */
    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try {
            int reservationNo = model.reservationTable(orderDate, tableNo, name);
            updateUIShowReservationTableResult(reservationNo);
        }
        catch (RuntimeException e){
            updateUIShowReservationTableResult(-1);
        }
    }

    // добавил
    @Override
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        try {
            int OldreservationNo = model.changeReservationTable(oldReservation, reservationDate, tableNo, name);
            updateUIShowCancelReservationTableResult(oldReservation);
            view.reservationTable(reservationDate, tableNo, name);
        }
        catch (RuntimeException e){
            view.reservationTable(reservationDate, tableNo, name);
            updateUIShowCancelReservationTableResult(-1);
        }
    }
}
