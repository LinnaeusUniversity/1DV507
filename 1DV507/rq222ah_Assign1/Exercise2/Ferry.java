package rq222ah_Assign1.Exercise2;

import java.util.Iterator;

public interface Ferry {
	int countPassengers();

	int countVehicleSpace();

	int countMoney();

	Iterator<Vehicle> iterator();

	void embark(Vehicle v);

	void embark(Passenger p);

	void disembark();

	boolean hasSpaceFor(Vehicle v);

	boolean hasRoomFor(Passenger p);

	String toString();
}
