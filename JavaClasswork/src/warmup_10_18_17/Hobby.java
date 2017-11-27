package warmup_10_18_17;

public class Hobby extends Thing{

	public Hobby(String description) {
		super(description);
	}

	public static Hobby randomHobby() {
		Hobby[] someHobbies = {new Hobby ("Programming"), new Hobby("Dancing"), new Hobby("playing video games")};
		return someHobbies[(int)(Math.random() * someHobbies.length)];
	}

	
}
