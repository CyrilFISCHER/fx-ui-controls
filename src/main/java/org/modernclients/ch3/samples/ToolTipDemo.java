package org.modernclients.ch3.samples;

import java.util.function.Consumer;

import org.modernclients.ch3.Sample;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * @author Cyril FISCHER <contact@CyrilFischer.fr>
 */
public class ToolTipDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {

        Rectangle rectangle = new Rectangle(120, 120, Color.RED);
        Tooltip rectangleTooltip = new Tooltip("A Red Square (size : 120px)");
        Tooltip.install(rectangle, rectangleTooltip);
        Circle circle = new Circle(50, Color.BLUE);

        Button hoverButton = new Button("Hover over me");
        Tooltip buttonTootlip = new Tooltip("A button \n"
                + "Tooltip on control can be added with a convenient method");
        hoverButton.setTooltip(buttonTootlip);

        Tooltip circleTooltip = new Tooltip("A Blue Circle (radius : 50px)");
        Tooltip.install(circle, circleTooltip);

        layoutDemo(rectangle, hoverButton, circle, container);
    }

    private void layoutDemo(Rectangle rectangle, Button hoverButton, Circle circle, Pane container) {
	        
        Text instructionText = new Text("Hover over nodes");
        instructionText.setStyle("-fx-font-size: 18;");
        GridPane.setHalignment(instructionText, HPos.CENTER);

        final GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-hgap: 3em; -fx-vgap: 3em");
        gridPane.add(instructionText, 0, 0, 3, 1);
        gridPane.add(rectangle, 0, 1);
        gridPane.add(hoverButton, 1, 1);
        gridPane.add(circle, 2, 1);
        container.getChildren().add(gridPane);
        
        
    }
}
