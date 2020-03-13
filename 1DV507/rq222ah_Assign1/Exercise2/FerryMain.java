package rq222ah_Assign1.Exercise2;

public class FerryMain {

	public static void main(String[] agrs) {
		Onboard ferry = new Onboard();
		Vehicle myCar = new Car(3, 1);
		Vehicle XXXXXX = new Bus(18, 2);
		Vehicle XXX = new Lorry(2, 3);
		Vehicle jupiter = new Bicycle(4);
		Vehicle jupiter1 = new Bicycle(5);
		Vehicle jupiter2 = new Bicycle(6);

		Passenger munish = new Passenger("Nitin");
		ferry.embark(munish);
		ferry.embark(XXX);
		ferry.embark(myCar);
		ferry.embark(XXXXXX);
		ferry.embark(jupiter);
		ferry.embark(jupiter1);
		ferry.embark(jupiter2);

		Vehicle YYYYYY = new Bus(18, 9);
		ferry.embark(YYYYYY);
		System.out.println(ferry.countVehicleSpace());
		System.out.println(ferry.countPassengers());
		System.out.println(ferry.countMoney());
		Passenger rashed = new Passenger("Adam");
		System.out.println(ferry.hasRoomFor(rashed));
		ferry.embark(rashed);
		Vehicle YYY = new Lorry(2, 10);
		System.out.println(ferry.hasSpaceFor(YYY));
		ferry.embark(YYY);

		System.out.println(ferry.toString());
	}
}
