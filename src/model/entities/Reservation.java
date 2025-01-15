package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkin;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation() {

	}

	public Reservation(Integer roomNumber, Date checkin, Date checkOut) {
		
		if (!checkOut.after(checkin)) {
			throw new DomainException("check-Out date must be after check-in date");
		}
		
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkin, Date checkOut) {

		Date now = new Date();
		if (checkin.before(now) || checkOut.before(now)) {
			throw new DomainException("Reservation dates for update be future dates");

		}
		if (!checkOut.after(checkin)) {
			throw new DomainException("check-Out date must be after check-in date");
		}

		this.checkin = checkin;
		this.checkOut = checkOut;

	}

	@Override
	public String toString() {
		return "Room " + roomNumber + ", checkin: " + sdf.format(checkin) + ", checkOut: " + sdf.format(checkin)
				+ duration() + " nigths ";
	}

}
