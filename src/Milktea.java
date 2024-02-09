
public class Milktea {

	double price;
	String topping = "boba";
	String tea = "regularMilktea";
	Integer sugar = 100;
	
	public Milktea() {
		this.price = 7.0;
	}
	
	public double getPrice() {
		return this.price;
	}
}

class SignatureMilktea extends Milktea {
	
	public SignatureMilktea() {
		this.price = 5.7;
	}
}

class OolongMilktea extends Milktea {
	
	public OolongMilktea() { 
		this.price = 4.5;
	}
}

// we need the builder to create our products
interface MilkteaBuilder { // define the basic methods
	void reset();
	void addTopping();
	void addTea();
	void addSugarLevel();
	Milktea getProduct();
}

// two contret builders
class SignatureMilkteaBuilder implements MilkteaBuilder {
	
	private SignatureMilktea product;
	
	@Override
	public void reset() {
		this.product = new SignatureMilktea();
	}
	
	@Override
	public void addTea() {
		product.topping = "boba";
	}
	
	@Override
	public void addTopping() {
		product.tea = "signature tea";		
	}
	
	@Override
	public void addSugarLevel() {
		product.sugar = 100;
	}
	
	@Override
	public Milktea getProduct() {
		System.out.format("Signature milktea: %s, %s, %s\n", this.product.topping, this.product.tea, this.product.sugar);
		return this.product;
	}
}

class OolongMilkteaBuilder implements MilkteaBuilder {
	
	private OolongMilktea product;
	
	@Override
	public void reset() {
		this.product = new OolongMilktea();
	}
	
	@Override
	public void addTopping() {
		product.topping = "grass jelly";
	}
	
	@Override
	public void addTea() {
		product.tea = "oolong";		
	}
	
	@Override
	public void addSugarLevel() {
		product.sugar = 50;
	}
	
	@Override
	public Milktea getProduct() {
		System.out.format("Oolong Milktea: %s, %s, %s\n", this.product.topping, this.product.tea, this.product.sugar);
		return this.product;
	}
}

// a special builder for customization
class CustomizedMilkteaBuilder {
	
	private Milktea product;
	
	public void reset() {
		this.product = new Milktea();
	}
	
	public void addTopping(String boba) {
		product.topping = boba;
	}
	
	public void addTea(String tea) {
		product.tea = tea;		
	}

	public void addSugerLevel(Integer sugar) {
		product.sugar = sugar;
	}
	
	public Milktea getProduct() {
		System.out.format("Customized Milktea: %s, %s, %s\n", this.product.topping, this.product.tea, this.product.sugar);
		return this.product;
	}
}

// Director class to simplfy the process of create Milktea
class MilkteaDirector {
	
	private MilkteaBuilder milkteaBuilder;
	
	public MilkteaDirector(MilkteaBuilder builder) {
		this.milkteaBuilder = builder;
	}
	
	public void changeBuilder(MilkteaBuilder builder) {
		this.milkteaBuilder = builder;
	}
	
	// referencing the MilkteaBuilder to create all processes of building a milk tea
	public Milktea makeMilktea() { 
		this.milkteaBuilder.reset();
		this.milkteaBuilder.addTopping();
		this.milkteaBuilder.addTea();
		this.milkteaBuilder.addSugarLevel();
		return this.milkteaBuilder.getProduct();
	}
	
	public Milktea make(String type) {
		
		if (type == "signature") {
			this.changeBuilder(new SignatureMilkteaBuilder());
		} else if (type == "oolong" ) {
			this.changeBuilder(new OolongMilkteaBuilder());
		}
		
		return this.makeMilktea();
	}
}



