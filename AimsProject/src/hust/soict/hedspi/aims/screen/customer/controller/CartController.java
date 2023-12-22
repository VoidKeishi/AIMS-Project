package hust.soict.hedspi.aims.screen.customer.controller;

import java.io.IOException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
	private Cart cart;
	private Store store;
	
	
	public CartController(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
	}
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;
    
    @FXML
    private TextField tfFilter;
    
    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;
	
	public void initialize() {
		colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		if(cart.getItemsOrdered() != null)
			tblMedia.setItems(this.cart.getItemsOrdered());
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>(){
			@Override
			public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
				updateButtonBar(newValue);
			}
		});
		tfFilter.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				showFilteredMedia(newValue);
			}
		});
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
	
	// Update
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
	private void updateCostLabel() {
		float cost = 0;
		for (Media media:cart.getItemsOrdered()) {
			cost += media.getCost();
		}
		costLabel.setText("" + cost);
	}
	
	@FXML
    void btnPlayPressed(ActionEvent event) {
		
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
    		final String STORE_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Store.fxml";
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

}
