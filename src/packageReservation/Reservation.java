package packageReservation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public long duration() {
        long dif = getCheckOut().getTime() - getCheckIn().getTime();

        return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);

    }

    public void updateDates(Date checkIn, Date checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {

        return "Room: "
                + roomNumber
                + ", check-in: "
                + sdf.format(checkIn)
                + ", checkout: "
                + ", "
                + duration()
                + " nights";
    }

}
