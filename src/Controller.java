import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ListIterator;
import java.util.ResourceBundle;

public class Controller extends Application implements Initializable {

    Filmregister register;
    ListIterator<Film> iterator;

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
    private Label labelJahr;

    @FXML
    private Label labelFSK;

    @FXML
    private Label labelSprache;

    @FXML
    private Label labelLaenge;

    @FXML
    private Label labelDarsteller;

    @FXML
    private VBox vboxTextFields;

    @FXML
    private TextField textFieldTitel;

    @FXML
    private TextField textFieldDtTitel;

    @FXML
    private TextField textFieldJahr;

    @FXML
    private TextField textFieldFSK;

    @FXML
    private TextField textFieldSprache;

    @FXML
    private TextField textFieldLaenge;

    @FXML
    private TextField textFieldDarsteller;

    @FXML
    private VBox vboxButtons;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonDelete;

    @FXML
    private Button buttonPrevious;

    @FXML
    private Button buttonNext;

    @FXML
    private ListView<?> listView;

    @FXML
    private Tab tabTabelle;

    @FXML
    private AnchorPane anchorPaneTab;

    @FXML
    private TableView<Film> tableView;

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
    public void initialize(URL location, ResourceBundle resources) {
        try {
            register = new Filmregister();
            setupListeners();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void eraseTextFields(){
        for (Node tf : vboxTextFields.getChildren()){
            TextField tff = (TextField) tf;
            tff.clear();
        }
    }

    private void setupListeners(){

        this.textFieldFSK.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    textFieldFSK.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        this.textFieldJahr.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    textFieldJahr.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        this.textFieldLaenge.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    textFieldLaenge.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        this.buttonNext.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    if (iterator == null) {
                        iterator = register.getAllFilms().listIterator();
                    }

                    if (iterator.hasNext()){
                        Film currentFilm = iterator.next();
                        setTextFieldValues(currentFilm);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        this.buttonPrevious.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    if (iterator == null){
                        iterator = register.getAllFilms().listIterator(register.getAllFilms().size());
                    }
                    if ( iterator.hasPrevious() ){
                        Film currentFilm = iterator.previous();
                        setTextFieldValues(currentFilm);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        this.buttonAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!textFieldTitel.getText().isEmpty()) {
                    try {
                        if (inputsCorrect()){
                            register.saveFilm(createFilmObjectFromInputFields());
                            iterator = register.getAllFilms().listIterator();
                            iterator.previous();
                        }
                    } catch (FilmDatenException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        this.buttonDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    register.deleteFilm(createFilmObjectFromInputFields());
                    eraseTextFields();
                } catch (FilmDatenException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        this.tabPane.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Tab>() {
                    @Override
                    public void changed(ObservableValue<? extends Tab> observable, Tab oldValue, Tab newValue) {
                        if (newValue.getId().contains("tabTabelle")){
                            try {
                                loadTableContent();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            loadFormContent();
                        }
                    }
                }
        );
    }

    private void loadFormContent() {
        try {
            iterator = register.getAllFilms().listIterator();
            if (iterator.hasNext()){
                Film currentFilm = iterator.next();
                setTextFieldValues(currentFilm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadTableContent() throws Exception {
        ObservableList<Film> data = FXCollections.observableArrayList();
        for (Film film : register.getAllFilms()){
            data.add(film);
        }
        System.out.println(data);
        tableView.setItems(data);
    }


    private void setTextFieldValues(Film currentFilm) {
        textFieldTitel.setText(currentFilm.getTitelEN());
        textFieldDtTitel.setText(currentFilm.getTitelDE());
        textFieldJahr.setText(String.valueOf(currentFilm.getJahr()));
        textFieldFSK.setText(String.valueOf(currentFilm.getFsk()));
        textFieldSprache.setText(String.valueOf(currentFilm.getSprache()));
        textFieldLaenge.setText(String.valueOf(currentFilm.getLaenge()));
        textFieldDarsteller.setText(String.valueOf(currentFilm.getDarsteller()));
    }

    private boolean inputsCorrect() {
        if (textFieldTitel.getText().isEmpty()){
            System.out.println("Englischer Titel darf nicht leer sein.");
            return false;
        }

        if (textFieldDtTitel.getText().isEmpty()){
            System.out.println("Deutscher Titel darf nicht leer sein");
            return false;
        }
        return true;
    }

    private Film createFilmObjectFromInputFields() throws FilmDatenException {
        boolean jahrIncorrect = textFieldJahr.getText().isEmpty();
        boolean fskIncorrect = textFieldFSK.getText().isEmpty();
        boolean laengeIncorrect = textFieldLaenge.getText().isEmpty();

        if (jahrIncorrect && fskIncorrect && laengeIncorrect){
            return new Film(
                    textFieldDtTitel.getText(),
                    textFieldTitel.getText(),
                    0,
                    0,
                    0,
                    textFieldSprache.getText(),
                    textFieldDarsteller.getText());
        }

        if (jahrIncorrect && fskIncorrect){
            return new Film(
                    textFieldDtTitel.getText(),
                    textFieldTitel.getText(),
                    0,
                    0,
                    Integer.parseInt(textFieldLaenge.getText()),
                    textFieldSprache.getText(),
                    textFieldDarsteller.getText());
        }

        if (jahrIncorrect && laengeIncorrect){
            return new Film(
                    textFieldDtTitel.getText(),
                    textFieldTitel.getText(),
                    0,
                    Integer.parseInt(textFieldFSK.getText()),
                    0,
                    textFieldSprache.getText(),
                    textFieldDarsteller.getText());
        }

        if (fskIncorrect && laengeIncorrect){
            return new Film(
                    textFieldDtTitel.getText(),
                    textFieldTitel.getText(),
                    Integer.parseInt(textFieldJahr.getText()),
                    0,
                    0,
                    textFieldSprache.getText(),
                    textFieldDarsteller.getText());
        }

        return new Film(
                textFieldDtTitel.getText(),
                textFieldTitel.getText(),
                Integer.parseInt(textFieldJahr.getText()),
                Integer.parseInt(textFieldFSK.getText()),
                Integer.parseInt(textFieldLaenge.getText()),
                textFieldSprache.getText(),
                textFieldDarsteller.getText());
    }


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
