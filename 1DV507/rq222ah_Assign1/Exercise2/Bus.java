package rq222ah_Assign1.Exercise2;

public class Bus extends Vehicle {

	private final int MAX_PASSENGER = 20;

	public Bus(int ppl, int id) {
		if (ppl <= MAX_PASSENGER) {
			super.space = 20;
			super.persCount = ppl;
			super.idNume = id;
			super.priceInTotal = 200 + (ppl * 10);
		} else
			System.err.println("NOT ENOUGH SPACES FOR PASSENGER");
	}

	@Override
	public int getTotalPrice() {

		return super.priceInTotal;
	}

	@Override
	public int getMaxPassanger() {
		return MAX_PASSENGER;
	}

	@Override
	public int getVehicleSpace() {
		return super.space;
	}

	@Override
	public int getId() {
		return super.idNume;
	}

}
