package rq222ah_Assign1.Exercise2;

import java.util.*;

import java.util.Iterator;

public class Onboard implements Ferry {

	private int pers;
	private int spaceForVehicle;
	private int money = 0;
	private static final int MAX_SPACE_VEHICLE = 200;
	private static final int MAX_SPACE_PASSENGER = 200;

	private List<Vehicle> vehicles;
	private List<Passenger> passengers;

	public Onboard() {
		pers = 0;
		spaceForVehicle = 0;
		vehicles = new ArrayList<Vehicle>();
		passengers = new ArrayList<Passenger>();
	}

	@Override
	public int countPassengers() {

		return pers;
	}

	@Override
	public int countVehicleSpace() {

		return spaceForVehicle / 5;
	}

	@Override
	public int countMoney() {
		if (spaceForVehicle == 0 || pers == 0) {
			return getMoney();
		}

		else {
			int temp = 0;
			for (Vehicle v : vehicles)
				temp += v.getTotalPrice();

			int moneyPassenger = 20 * passengers.size();
			temp += moneyPassenger;

			money = temp;
			return temp;
		}

	}

	public int getMoney() {
		return money;
	}

	@Override
	public Iterator<Vehicle> iterator() {

		return vehicles.iterator();
	}

	@Override
	public void embark(Vehicle id) {

		if (hasSpaceFor(id) && id.getsize() + pers <= MAX_SPACE_PASSENGER) {
			if (vehicles.contains(id)) {
				System.err.println("Vehicle with the number plat " + id + " has already been embarked. ");
			} else {
				pers += id.getsize();
				vehicles.add(id);
				spaceForVehicle += id.getVehicleSpace();

			}
		}

		else {
			if (id.getsize() + pers > MAX_SPACE_PASSENGER) {
				System.err.println("To many passengers in vehicle");
			} else {
				System.err.println("There is no more space for vehicle");
			}
		}

	}

	@Override
	public void embark(Passenger p) {
		if (hasRoomFor(p)) {
			if (passengers.contains(p)) {
				System.err.println("Passenger " + p + " has already been embarked");
			}
			pers++;
			passengers.add(p);
		} else {
			System.out.println("No space for more passenger");
		}
	}

	@Override
	public void disembark() {
		vehicles.clear();
		passengers.clear();
		spaceForVehicle = 0;
		pers = 0;
		countMoney();
		System.out.println("CASH IN" + getMoney());

	}

	@Override
	public boolean hasSpaceFor(Vehicle v) {

		return v.getVehicleSpace() + spaceForVehicle <= MAX_SPACE_VEHICLE;
	}

	@Override
	public boolean hasRoomFor(Passenger p) {

		return p.getSize() + pers <= MAX_SPACE_PASSENGER;
	}

	public String toString() {
		String status = countPassengers() + " Passengers on board\n" + vehicles.size() + " Vehicles on board\n"
				+ countMoney() + " kr.\n\n Passengers with no Vehicle: \n";
		Iterator<Passenger> itrPass = passengers.iterator();
		int count = 0;

		while (itrPass.hasNext()) {
			count++;
			Passenger pas = itrPass.next();
			status += "passenger " + count + ": " + pas.toString() + "\n";
		}
		return status;
	}
}