package converterfx;

import java.awt.Button;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * Class Controller UI
 * 
 * @author Pittayut Sothanakul
 *
 */
public class ConverterController {
	@FXML
	TextField textField1;
	@FXML
	TextField textField2;
	@FXML
	Button convertBontton;
	@FXML
	Button cleartBontton;
	@FXML
	ComboBox<Length> comboBox1;
	@FXML
	ComboBox<Length> comboBox2;

	/**
	 * Calculate value from textField to another textField.
	 * 
	 * @param event
	 *            calculate when user press enter or clicked on button convert.
	 */
	public void handleConvert(ActionEvent event) {
		String text = textField1.getText().trim();
		String text2 = textField2.getText().trim();
		Length unit1 = comboBox1.getValue();
		Length unit2 = comboBox2.getValue();
		if (!textField1.getText().isEmpty()) {
			double left = 0;
			try {
				left = Integer.parseInt(text);
				double unit1To2 = unit1.getValue() / unit2.getValue();
				System.out.println("handleConvert");
				textField2.setText(String.format("%.4g", left * unit1To2));
				textField1.setStyle("-fx-text-box-border: blue;");

			} catch (NumberFormatException e) {
				textField1.setText("");
				textField1.setStyle("-fx-text-box-border: red;");
				textField2.setText("");

			}
		} else if (!text2.equals("")) {
			double right = 0;
			try {
				right = Integer.parseInt(text2);
				double unit2to1 = unit2.getValue() / unit1.getValue();
				textField1.setText(String.format("%.4g", right * unit2to1));
				textField2.setStyle("-fx-text-box-border: blue;");
			} catch (NumberFormatException e) {
				textField2.setText("");
				textField2.setStyle("-fx-text-box-border: red;");
				textField1.setText("");

			}
		}

	}

	/**
	 * Clear all textField.
	 * 
	 * @param event
	 *            clear when user clicked clear button.
	 */
	public void handleClear(ActionEvent event) {
		textField1.setText("");
		textField2.setText("");
	}

	/**
	 * JavaFX calls the initialize() method of your controller when it creates
	 * the UI form, after the components have been created and @FXML annotated
	 * attributes have been set.
	 *
	 * This is a hook to initialize anything your controller or UI needs.
	 */
	@FXML
	public void initialize() {

		System.out.println("Running initialize");
		if (comboBox1 != null) {
			comboBox1.getItems().addAll(Length.values());
			comboBox1.getSelectionModel().select(0); // select an item to show
		}
		if (comboBox2 != null) {
			comboBox2.getItems().addAll(Length.values());
			comboBox2.getSelectionModel().select(1); // select an item to show
		}
	}
}
