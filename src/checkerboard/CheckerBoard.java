/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Kyle Shearrer KNSFGD 14260725 <kyleshearrer@gmail.com>
 */
public class CheckerBoard {
    private int numRows;
    private int numCols;
    private double boardWidth;
    private double boardHeight;
    
    private Color lightColor;
    private Color darkColor;
    
    private double rectangleWidth;
    private double rectangleHeight;
    private AnchorPane checkerBoard=null;
    
    private CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight){
        
        this.numRows=numRows;
        this.numCols=numCols;
        this.boardWidth=boardWidth;
        this.boardHeight=boardHeight;
    }
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor) {
        
        this(numRows, numCols, boardWidth, boardHeight);
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
    public AnchorPane build(){
        
        double rectangleWidth = Math.ceil(boardWidth / numCols);
        double rectangleHeight = Math.ceil(boardHeight / numRows);
        
        checkerBoard = new AnchorPane();                       
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                
                Rectangle rectangle = new Rectangle();
                
                rectangle.setHeight(rectangleHeight);
                rectangle.setWidth(rectangleWidth);      
                
                rectangle.setY(rectangleHeight*row);
                rectangle.setX(rectangleWidth*col);
                
                if ( (row % 2) == (col % 2) ){
                    rectangle.setFill(lightColor);
                }
                else{
                    rectangle.setFill(darkColor);
                }
                checkerBoard.getChildren().add(rectangle);
            }
        }
        return checkerBoard;
    }    
    
    public AnchorPane getBoard() {
        return checkerBoard;
    }
    
    public Color getLightColor() {
        return lightColor;
    }
    
    public Color getDarkColor() {
        return darkColor;
    }
    public int getNumRows(){
        return numRows;
    }
    public int getNumCols(){
        return numCols;
    } 
    public double getWidth(){
        return boardWidth;
    }
    public double getHeight(){
        return boardHeight;
    }
    public double getRectangleWidth(){
        return rectangleWidth;
    }
    public double getRectangleHeight(){
        return rectangleHeight;
    }

}
