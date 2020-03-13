package rq222ah_Assign3;

public class NorseGod {
	private String Name = "";
	private String Race = "";
	private String Desc = "";

	public NorseGod() {

	}

	public NorseGod(String name, String race, String desc) {
		Name = name;
		Race = race;
		Desc = desc;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getRace() {
		return Race;
	}

	public void SetRace(String race) {
		Race = race;
	}

	public String getDesc() {
		return Desc;
	}

	public void setDesc(String desc) {
		Desc = desc;
	}
}