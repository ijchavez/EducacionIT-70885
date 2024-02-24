package clase5.dataProvider;

import org.testng.annotations.DataProvider;

import clase5.utilities.Utilities;

public class DataProviderExample {
	@DataProvider(name="usuariosInvalidos")
	public Object[][] usuariosInvalidos(){
		//email------------------password
		return new Object[][]{
			{"invalidEmail@email.com", "pasdsda"},
			{"mailmail.com", "asdpasdsda"},
			{"invalidEmail@", "pasdsda"}
			
		};
	}
	@DataProvider(name="usuariosInvalidosExcel")
	public Object[][] usuariosInvalidosExcel() throws Exception{
		return Utilities.readFromExcelFile("D:\\EducacionIT-70885\\ProyectoIntegrador\\src\\test\\resources\\inicioSesionInvalido.xlsx", "Hoja1");
	}
	
}
