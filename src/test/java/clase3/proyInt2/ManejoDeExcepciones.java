package clase3.proyInt2;

import org.testng.annotations.Test;

public class ManejoDeExcepciones {
	@Test
	public void divisionTest() {
		
		int a = 6;
		int b = 3;
		//int b = 0; //utilizar esta linea para entrar al catch.
		
		try {
			double div = a / b;
			System.out.println(div);
		}catch(ArithmeticException e) {
			System.out.println("No se puede dividir por cero");
		}

		
	}
}
