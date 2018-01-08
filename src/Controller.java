import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controller extends Application {
	
	/**
	 * Declaration of GUI elements
	 */
	
    @FXML
    private TabPane tabPane;

    @FXML
    private Tab tabListe;

    @FXML
    private AnchorPane anchorPaneListe;

    @FXML
    private HBox hboxListe;

    @FXML
    private VBox vboxLabels;

    @FXML
    private Label labelTitel;

    @FXML
    private Label labelDtTitel;

    @FXML
    private Label labelRegie;

    @FXML
    private Label labelGenre;

    @FXML
    private Label labelStudio;

    @FXML
    private Label labelLaenge;

    @FXML
    private VBox vboxTextFields;

    @FXML
    private TextField textFieldTitel;

    @FXML
    private TextField textFieldDtTitel;

    @FXML
    private TextField textFieldRegie;

    @FXML
    private TextField textFieldGenre;

    @FXML
    private TextField textFieldStudio;

    @FXML
    private TextField textFieldLaenge;

    @FXML
    private VBox vboxButtons;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonDelete;

    @FXML
    private ListView<?> listView;

    @FXML
    private Tab tabTabelle;

    @FXML
    private AnchorPane anchorPaneTab;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> columnTitel;

    @FXML
    private TableColumn<?, ?> columnDtTitel;

    @FXML
    private TableColumn<?, ?> columnRegie;

    @FXML
    private TableColumn<?, ?> columnGenre;

    @FXML
    private TableColumn<?, ?> columnStudio;

    @FXML
    private TableColumn<?, ?> columnFsk;

    @FXML
    private TableColumn<?, ?> columnLaenge;
    
    
	private Stage stage;
	

    
    
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		this.stage = primaryStage;
		Parent root = FXMLLoader.load(getClass().getResource("Gui.fxml"));
		primaryStage.setTitle("Filmregister");
	    primaryStage.setScene(new Scene(root, 800, 600));
	    primaryStage.show();
	}
	

	public static void main(String[] args) {
        launch(args);
	}
}
