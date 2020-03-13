package rq222ah_Assign1.Exercise2;

public class Bicycle extends Vehicle {

	private final int MAX_PASSENGER = 1;

	public Bicycle(int id) {
		super.space = 1;
		super.priceInTotal = 40;
		super.idNume = id;

	}

	@Override
	public int getTotalPrice() {

		return super.priceInTotal;
	}

	@Override
	public int getVehicleSpace() {

		return super.space;
	}

	@Override
	public int getId() {

		return idNume;
	}

	@Override
	public int getMaxPassanger() {

		return MAX_PASSENGER;
	}

}
