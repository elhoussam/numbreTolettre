package application;

import static me.elhoussam.mvn.generator.NumToLet.print;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import me.elhoussam.mvn.generator.*; 

public class SampleController implements Initializable {
	@FXML    
	private TextField TxtInput;
	
	@FXML    
	private TextArea  TxtOutput ;
	
	@FXML    
	private RadioButton  BtnAr ,BtnInd , BtnEn , Btnfr ;
	@FXML    
	private Label  lblar ,lblind , lblen , lblfr ;

	@FXML 
	protected void GeneratorAr() {
		Generator("Ar");
	}
	@FXML 
	protected void GeneratorFr() {
		Generator("Fr");
	}
	@FXML 
	protected void GeneratorEn() {
		Generator("En");
	}

	@FXML 
	protected void GeneratorInd() {
		Generator("Ind");
	}
	
	
	protected void Generator(String Id){
		String InputNumber = TxtInput.getText().trim() ;
	// Check the input number 
	if (  (InputNumber.matches("\\d{1,18}")) ) {
		String output = "";
		NumToLet obj = null ;
		print(Id+" : ");
		if( Id.contains("Ar") ) {
			obj = new GenAr(); TxtOutput.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
		}else { TxtOutput.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
			if( Id.contains("En") ) 	 obj = new GenEn();
			else if( Id.contains("Fr") )	 obj = new GenFr();
			else if ( Id.contains("Ind") )	 obj = new GenInd();
			
		}
		print("\n");
		output = obj.Generate( Long.parseLong(InputNumber) );
		TxtOutput.setText( output );
	}else{
		TxtOutput.setText("Minimum = 0  \nMaximum = 9,223,372,036,854,775,807");
	}
	 
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		lblar.setGraphic(getImageView("icon/ar.png")  ); 
		lblfr.setGraphic(getImageView("icon/fr.png")  );
		lblind.setGraphic(getImageView("icon/ind.png")  );
		lblen.setGraphic(getImageView("icon/en.png")  );
		
	}
	/*
	 * This main functionality of 
	 * this method to show the picture
	 * when i export the RunnableJar file  
	 * */
	private ImageView getImageView( String path ) {
		
		// i used only the path = "icon/mypic.png"
		// because i refer to the parent folder as resource in eclipse settings
		ImageView   a = new ImageView();
		Image img = new Image( getClass().getClassLoader().getResource(path).toString() );
		a.setImage(img);
		return a ;
	}
}
