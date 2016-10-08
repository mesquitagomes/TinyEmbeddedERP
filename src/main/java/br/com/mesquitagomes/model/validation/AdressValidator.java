package main.java.br.com.mesquitagomes.model.validation;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public class AdressValidator {

	public static MaskFormatter getZipcodeMaskFormatter() {

		MaskFormatter maskFormatter = new MaskFormatter();
		try {
			maskFormatter.setMask("#####-###");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return maskFormatter;
	}

	public static MaskFormatter getNumberMaskFormatter() {

		MaskFormatter maskFormatter = new MaskFormatter();
		try {
			maskFormatter.setMask("##########");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return maskFormatter;
	}

}
