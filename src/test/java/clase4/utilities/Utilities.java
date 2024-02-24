package clase4.utilities;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.io.InputStream;

public class Utilities {
	public static void createDocxFile(WebDriver driver, String nombreArchivo, String rutaImagen) throws IOException, InvalidFormatException {
		File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File imageFile = new File(rutaImagen);
		FileUtils.copyFile(screen, imageFile);
		
		File fichero = new File(nombreArchivo);
		 XWPFDocument docx;
		 if (!fichero.exists()) {
			 docx = new XWPFDocument();
			 
		 } else {
			 FileInputStream ficheroStream = new FileInputStream(fichero);
			 docx = new XWPFDocument(ficheroStream);
			 
		 }
		 XWPFParagraph paragraph = docx.createParagraph();
		 XWPFRun run = paragraph.createRun();
		 
		 run.setText("Evidencia de pruebas");
		 run.setFontSize(13);
		 
		 InputStream pic = new FileInputStream(rutaImagen);
		 run.addPicture(pic, Document.PICTURE_TYPE_PNG, rutaImagen,
		 Units.toEMU(500), Units.toEMU(200));
		 pic.close();

		 FileOutputStream out = new FileOutputStream(nombreArchivo);
		 docx.write(out);
		 out.flush();
		 out.close();
		 docx.close();
 
    }
	public static void takeScreenshot(WebDriver driver, String imgPath) throws IOException, InvalidFormatException {
		File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File (imgPath));
		
	}
}
