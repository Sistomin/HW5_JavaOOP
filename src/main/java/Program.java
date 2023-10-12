import models.TableModel;
import presenters.BookingPresenter;
import presenters.Model;
import presenters.View;
import views.BookingView;

import java.util.Date;
public class Program {

    /**
     * TODO: ДОМАШНЯЯ РАБОТА
     * Метод changeReservationTable должен ЗАРАБОТАТЬ!
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        View view = new BookingView();
        Model model = new TableModel();
        BookingPresenter presenter = new BookingPresenter(model, view);
        presenter.updateUIShowTables();

        view.reservationTable(new Date(), 3, "Станислав");
        view.changeReservationTable(1001, new Date(), 2, "Станислав");

        view.reservationTable(new Date(), 3, "Сергей");
        view.reservationTable(new Date(), 1, "Данил");
        view.reservationTable(new Date(), 4, "Крис");
        view.reservationTable(new Date(), 5, "Ольга");
        view.changeReservationTable(1004, new Date(), 1, "Станислав");
    }

}