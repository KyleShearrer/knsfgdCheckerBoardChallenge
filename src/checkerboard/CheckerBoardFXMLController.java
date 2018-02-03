/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Kyle Shearrer KNSFGD 14260725 <kyleshearrer@gmail.com>
 */
public class CheckerBoardFXMLController implements Initializable, Startable{
    private Stage stage;

    private int numRows = 8;
    private int numCols = 8;
    
    private double boardWidth;
    private double boardHeight;
    
    private Color lightColor = Color.RED;
    private Color darkColor = Color.BLACK;
    
    private Scene scene;

  
    @FXML private AnchorPane anchorPane;
    @FXML private MenuBar menuBar;
    @FXML private Menu gridMenu;
    @FXML private Menu colorsMenu;
    @FXML private MenuItem defaultItem;
    @FXML private MenuItem blueItem;
    @FXML private MenuItem x16Item;
    @FXML private MenuItem x10Item;
    @FXML private MenuItem x8Item;
    @FXML private MenuItem x3Item;
    
    
    @FXML private VBox vBox;
    @FXML private VBox anchorPaneVbox;
    
    @Override
    public void start(Stage stage) {
        this.stage=stage;
        
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            setBoard();
        };

        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);

        setBoard();
    }
    
    @FXML 
    private void changeColor(ActionEvent event){
        MenuItem menuItem = (MenuItem)(event.getSource());
        
        switch(menuItem.getId()){
            case "blueItem":
                lightColor=Color.SKYBLUE;
                darkColor=Color.DARKBLUE; 
                break;
            case "defaultItem":
                lightColor=Color.RED;
                darkColor=Color.BLACK;
                break;
            default:
                lightColor=Color.RED;
                darkColor=Color.BLACK;
                break;
        }
        setBoard();
    }

    public void setBoard() { 
        
        boardWidth=vBox.getWidth();
        boardHeight=(vBox.getHeight()-menuBar.getHeight());
        
        CheckerBoard checkerBoard = new CheckerBoard(numRows, numCols, boardWidth, boardHeight, lightColor, darkColor);
        AnchorPane board = checkerBoard.build();
        
        anchorPane.getChildren().clear();
        
        anchorPane.getChildren().addAll(board); 
    }
    
    @FXML 
    private void setSize(ActionEvent event){
        MenuItem menuItem = (MenuItem)(event.getSource());
        switch(menuItem.getId()){
            case"x16Item":
                numRows=16;
                numCols=16;
                break;
            case"x10Item":
                numRows=10;
                numCols=10;
                break;
            case"x8Item":
                numRows=8;
                numCols=8;
                break;
            case"x3Item":
                numRows=3;
                numCols=3;
                break;
            default:
                numRows=8;
                numCols=8;
                break;
        }
        setBoard();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {}
}
