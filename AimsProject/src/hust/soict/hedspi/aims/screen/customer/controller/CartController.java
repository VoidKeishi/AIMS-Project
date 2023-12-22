package hust.soict.hedspi.aims.screen.customer.controller;

import java.io.IOException;
import java.util.Optional;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
	private Cart cart;
	private Store store;

	@FXML
	private TableView<Media> tblMedia;
	
	@FXML
	private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;
    
	@FXML
	private TableColumn<Media, Integer> colMediaId;

	@FXML
	private TableColumn<Media, String> colMediaCategory;
	
	@FXML
	private TableColumn<Media, Float> colMediaCost;
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TextField tfFilter;

    @FXML
    private ToggleGroup filterCategory;

	public CartController(Store store, Cart cart) {
		this.cart = cart;
		this.store = store;
	}
	
	@FXML
	private void initialize() {
		colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		if (cart.getItemsOrdered().size() != 0){
			tblMedia.setItems( this.cart.getItemsOrdered());
			tblMedia.getSelectionModel().select(cart.getItemsOrdered().get(0));
			btnRemove.setVisible(true);
			if(cart.getItemsOrdered().get(0) instanceof Playable) {
				btnPlay.setVisible(true);
			}
			else {
				btnPlay.setVisible(false);
			}
		}
		else{
			tblMedia.setItems( this.cart.getItemsOrdered());
			btnPlay.setVisible(false);
			btnRemove.setVisible(false);
		}
		tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>(){
			@Override
			public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
				updateButtonBar(newValue);
			}
		});
		updateCostLabel();
		updateBtnPlaceOrder();
		tfFilter.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				showFilteredMedia(newValue);
			}
		});
		filterCategory.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
    	    public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
    	    	showFilteredMedia(tfFilter.getText());
    	    }
    	});

    	
	}
	private void updateBtnPlaceOrder() {
		if (cart.getItemsOrdered().size() == 0) {
    		btnPlaceOrder.setDisable(true);
    	}
	}
	private void showFilteredMedia(String newValue) {
		FilteredList<Media> filteredData = new FilteredList<>(cart.getItemsOrdered());
		if (((RadioButton) filterCategory.getSelectedToggle()).getText().equals(radioBtnFilterTitle.getText())) {
			filteredData.setPredicate(media -> {
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase().trim();
				if(media.getTitle().toLowerCase().trim().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else {
					return false;
				}
				
			});
		}
		else {
			filteredData.setPredicate(media -> {
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseId = newValue.toLowerCase();
				if(String.valueOf(media.getId()).toLowerCase().indexOf(lowerCaseId.trim()) != -1) {
					return true;
				}
				else {
					return false;
				}
				
			});
		}
		SortedList<Media> sortedData = new SortedList<>(filteredData);
		sortedData.comparatorProperty().bind(tblMedia.comparatorProperty());
		tblMedia.setItems(sortedData);
	}

	private void updateCostLabel() {
		float cost = 0;
		for (Media media:cart.getItemsOrdered()) {
			cost += media.getCost();
		}
		costLabel.setText("" + String.format("%.2f$", cost));
	}
	private void updateButtonBar(Media media) {
		if(media == null) {
			btnPlay.setVisible(false);
			btnRemove.setVisible(false);
		}
		else {
			btnRemove.setVisible(true);
			if(media instanceof Playable) {
				btnPlay.setVisible(true);
			}
			else {
				btnPlay.setVisible(false);
			}
		}
	}
    @FXML
    void btnPlayPressed(ActionEvent event) {
    	try {
	    	Media media = tblMedia.getSelectionModel().getSelectedItem();
	    	Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Play media");
			alert.setHeaderText("Playing " + media.getTitle());
			
			if (media instanceof Playable) {
    			alert.setContentText(((Playable)media).playMedia());
    			alert.showAndWait();
    		} else {
    			throw new ClassCastException("This media is not playable!");
    		}
    	}catch (PlayerException | ClassCastException e) {
			Alert alert1 = new Alert(AlertType.ERROR);
			alert1.setTitle("Error");
			alert1.setHeaderText(e.getMessage());
			alert1.showAndWait();
		}
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    	updateCostLabel();
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
    	try {
    		final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
    		fxmlLoader.setController(new ViewStoreController(store,cart));
    		Parent root = fxmlLoader.load();
    		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
    		stage.setScene(new Scene(root));
    		stage.setTitle("Store");
    		stage.show();
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Place order");
		alert.setHeaderText("Do you want to place order? ");
		alert.setContentText(cart.printCart());
		Optional<ButtonType> result = alert.showAndWait();
		if(result.get() == ButtonType.OK) {
			Alert alert1 = new Alert(AlertType.INFORMATION);
		    alert1.setTitle("Place Order ");
		    alert1.setHeaderText("Status: ");
		    alert1.setContentText("Success");
		    alert1.showAndWait();
		    cart.emptyCart();
		    btnPlaceOrder.setDisable(true);
		    updateBtnPlaceOrder();
		}
    }
}