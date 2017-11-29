package pokemon;

public class Pokemon {

	private int level;
	private int hp;
	private String name;
	private boolean poisoned;
	
	public Pokemon(String name, int lvl) {
		this.name = name;
		this.level = lvl;
		this.hp = 100;
		this.poisoned = false;
	}
	
	public void iChooseYou() {
		System.out.println(name+", "+name+"!");
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String getName() {
		return name;
	}

	public void setPoisoned(boolean poisoned) {
		this.poisoned = poisoned;
	}
	
	public void lapse() {
		if (poisoned) {
			hp = hp-15;
		}
		if (hp<0)
			hp = 0;
	}
	
	public void attack(Pokemon target, Attack attack){
		 if(Math.random() < .9){
		 attack.attack(target);
		 System.out.println("The attack hit");
		 }else{
		 System.out.println("The attack missed");
		 }
	}
	public void levelUp(Effect e) {
		this.level++;
		e.happens();
	}
}
