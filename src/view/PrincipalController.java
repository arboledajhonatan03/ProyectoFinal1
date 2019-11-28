package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Cliente;
import model.Empresa;
import model.Producto;
import model.RepetitiveException;

public class PrincipalController implements Initializable {
	
	private Empresa empresa;
	private Stage stage;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		empresa = new Empresa();
		stage = new Stage();
		
	}
	
	public void registrarCliente(Event event) {
		AnchorPane root = new AnchorPane();
		VBox vbox1 = new VBox();
		VBox vbox2 = new VBox();
		Label l1 = new Label("Digite el nombre del cliente: ");
		TextField t1 = new TextField();
		Label l2 = new Label("Digite el id del cliente: ");
		TextField t2 = new TextField();
		root.getChildren().add(vbox1);
		root.getChildren().add(vbox2);
		vbox1.setLayoutX(50);
		vbox1.setLayoutY(50);
		vbox2.setLayoutX(250);
		vbox2.setLayoutY(50);
		vbox1.getChildren().add(l1);
		vbox1.getChildren().add(l2);
		vbox2.getChildren().add(t1);
		vbox2.getChildren().add(t2);
		Cliente c = new Cliente(t1.getText(), t2.getText());
		Button b1 = new Button();
		b1.setText("Registrar");
		b1.setOnAction(e -> {
			try {
				empresa.addCliente(c);
			} catch (RepetitiveException eevent) {
				// TODO Auto-generated catch block
				eevent.printStackTrace();
			}
			stage.close();
		});
		root.getChildren().add(b1);
		b1.setLayoutX(210);
		b1.setLayoutY(150);
		Scene scene = new Scene(root, 460,300);
		stage.setScene(scene);
		stage.show();
	}
	
	public void añadirProducto(Event event) {
		AnchorPane root = new AnchorPane();
		Label l1 = new Label("Digite el nombre del producto: ");
		Label l2 = new Label("Digite el precio del producto: ");
		Label l3 = new Label("Digite el id del cliente: ");
		TextField t1 = new TextField();
		TextField t2 = new TextField();
		TextField t3 = new TextField();
		VBox vbox1 = new VBox();
		VBox vbox2 = new VBox();
		root.getChildren().add(vbox1);
		root.getChildren().add(vbox2);
		vbox1.setLayoutX(50);
		vbox1.setLayoutY(50);
		vbox2.setLayoutX(250);
		vbox2.setLayoutY(50);
		vbox1.getChildren().add(l1);
		vbox1.getChildren().add(l2);
		vbox1.getChildren().add(l3);
		vbox2.getChildren().add(t1);
		vbox2.getChildren().add(t2);
		vbox2.getChildren().add(t3);
		Producto p = new Producto(t1.getText(), Double.parseDouble(t2.getText()));
		Button b1 = new Button();
		b1.setText("Añadir");
		b1.setOnAction(e -> {
			empresa.addProduct(p, t3.getText());
			stage.close();
		});
		root.getChildren().add(b1);
		b1.setLayoutX(210);
		b1.setLayoutY(150);
		Scene scene = new Scene(root, 460,300);
		stage.setScene(scene);
		stage.show();
	}
	
	
}