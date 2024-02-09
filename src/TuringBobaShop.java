
public class TuringBobaShop {
	
	public static void main(String[] args) {
		MilkteaDirector director = new MilkteaDirector(new SignatureMilkteaBuilder());
		director.makeMilktea();
		director.changeBuilder(new OolongMilkteaBuilder());
		director.makeMilktea();
		director.make("signature");
		director.make("oolong");
		
		CustomizedMilkteaBuilder builder = new CustomizedMilkteaBuilder();
		builder.reset();
		builder.addTopping("boba");
		builder.addTea("Oolong");
		builder.addSugerLevel(10);
		builder.getProduct();		
	}
}