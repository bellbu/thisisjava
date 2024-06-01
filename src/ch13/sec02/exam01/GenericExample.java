package ch13.sec02.exam01;

public class GenericExample {

	public static void main(String[] args) {
		Product<Tv, String> product1 = new Product<>();
		
		product1.setKind(new Tv());
		product1.setModel("스마트Tv");
		
		Tv tv = product1.getKind();
		System.out.println("tv : "+new Tv());
		String tvModel = product1.getModel();
		System.out.println("tvModel : " + tvModel);
		
	}

}
