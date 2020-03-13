package rq222ah_Assign1.Exercise2;

public abstract class Vehicle {

	protected int persCount;
	protected int priceInTotal;
	protected int idNume;
	protected int space;

	protected int getsize() {
		return persCount;
	}

	public abstract int getTotalPrice();

	public abstract int getMaxPassanger();

	public abstract int getVehicleSpace();

	public abstract int getId();

}
