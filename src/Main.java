
public class Main {

	public static void main(String[] args) {
		Mattress m = new Mattress("SearBed");
		m.setSize("TWIN");
		Layer topper = new Layer(2.5, "gel infused memory foam", m.getSize());
		Layer base = new Layer(7.5, "conventional white foam", m.getSize());
		OuterCover searcover = new OuterCover("30% Tencent", m.getHeight()-1, m.getSize());
		m.addLayer(topper);
		m.addLayer(base);
		m.addOuterCover(searcover);
		
		System.out.println(topper.getPrice());
		System.out.println(base.getPrice());
		System.out.println(searcover.getPrice());
		System.out.println(m.calPrice());
	}

}
