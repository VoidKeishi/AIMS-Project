package hust.soict.hedspi.aims.screen.customer.controller;

import java.util.Optional;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {
	private Media media;
	private Cart cart;
    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;
    
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;
    
	public void setData(Media media,Cart cart){
		this.media = media;
		this.cart = cart;
		lblTitle.setText(media.getTitle());
		lblCost.setText(media.getCost()+" $");
		if(media instanceof Playable) {
			btnPlay.setVisible(true);
		}
		else {
			btnPlay.setVisible(false);
			HBox.setMargin(btnAddToCart, new Insets(0,0,0,60));
		}
	}


    @FXML
    void btnAddToCartClicked(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Add media");
		alert.setHeaderText("Do you want to add this media to cart? ");
		alert.setContentText(media.toString());
		Optional<ButtonType> result = alert.showAndWait();
		if(result.get() == ButtonType.OK) {
			try {
			    cart.addMedia(media);
				Alert alert1 = new Alert(AlertType.INFORMATION);
			    alert1.setTitle("Add media ");
			    alert1.setHeaderText("Status: ");
			    alert1.setContentText("Success");
			    alert1.showAndWait();
			}catch(LimitExceededException | IllegalArgumentException e) {
				Alert alert1 = new Alert(AlertType.ERROR);
			    alert1.setTitle("Error ");
			    alert1.setHeaderText("Error: ");
			    alert1.setContentText(e.getMessage());
			    alert1.showAndWait();
			}
		}

    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
		try {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Play media");
			alert.setHeaderText("Playing " + media.getTitle());
			alert.setContentText(((Playable)media).playMedia());
			alert.showAndWait();
		} catch (PlayerException e) {
			Alert alert1 = new Alert(AlertType.ERROR);
			alert1.setTitle("Error");
			alert1.setHeaderText(e.getMessage());
			alert1.showAndWait();
		}
    }

}
