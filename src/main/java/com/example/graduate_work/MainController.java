package com.example.graduate_work;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.Chart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

public class MainController implements Initializable{
    @FXML
    private MenuItem hi10;

    @FXML
    private Text hiValue;

    @FXML
    private Button printButton;

    @FXML
    private LineChart<Number, Number> mainChart;

    @FXML
    private AnchorPane mainPage;

    @FXML
    private MenuItem nu6;

    @FXML
    private Text nuValue;

    @FXML
    private Text pValue;

    @FXML
    private MenuButton selectA;

    @FXML
    private TextField hiField;

    @FXML
    private TextField nuField;


    @FXML
    private TextField bettaField;

    @FXML
    private Text bettaValue;

    @FXML
    private Button P0hi;

    @FXML
    private Button P0nu;

    @FXML
    private Button P11hi;

    @FXML
    private Button T0hi;

    @FXML
    private Button T0nu;

    @FXML
    private Button T11hi;

    @FXML
    private TextField lx;

    private double doubleLX = -10;

    private double doubleUX = 0;

    private double doubleLY = -2;

    private double doubleUY = 2;

    @FXML
    private TextField ly;

    @FXML
    private TextField ux;

    @FXML
    private TextField uy;


    @FXML
    private Button changeAxis;


    private double betta;

    private final double g = 9.8;

    private double tempNu;

    private double tempHi;

    private String type;

    private int zoomCount;

    @FXML
    void clickOn6nu(ActionEvent event) {
        selectA.setText(nu6.getText());
        P11hi.setVisible(false);
        T11hi.setVisible(false);
        P0hi.setVisible(false);
        T0hi.setVisible(false);
        T0nu.setVisible(true);
        P0nu.setVisible(true);

        P0nu.setOnAction(actionEvent -> {
            type = "P0nu";
            printButton.setDisable(false);
            P0nu.setStyle("-fx-background-color: white; -fx-text-fill: black");
            T0nu.setStyle("-fx-background-color: black; -fx-text-fill: white");
            P0hi.setStyle("-fx-background-color: black; -fx-text-fill: white");
            T0hi.setStyle("-fx-background-color: black; -fx-text-fill: white");
            P11hi.setStyle("-fx-background-color: black; -fx-text-fill: white");
            T11hi.setStyle("-fx-background-color: black; -fx-text-fill: white");

        });

        T0nu.setOnAction(actionEvent -> {
            type = "T0nu";
            printButton.setDisable(false);
            P0nu.setStyle("-fx-background-color: black; -fx-text-fill: white");
            T0nu.setStyle("-fx-background-color: white; -fx-text-fill: black");
            P0hi.setStyle("-fx-background-color: black; -fx-text-fill: white");
            T0hi.setStyle("-fx-background-color: black; -fx-text-fill: white");
            P11hi.setStyle("-fx-background-color: black; -fx-text-fill: white");
            T11hi.setStyle("-fx-background-color: black; -fx-text-fill: white");
        });
    }

    @FXML
    void onClick10hi(ActionEvent event) {
        selectA.setText(hi10.getText());
        P11hi.setVisible(true);
        T11hi.setVisible(true);
        P0hi.setVisible(true);
        T0hi.setVisible(true);
        T0nu.setVisible(false);
        P0nu.setVisible(false);

        P11hi.setOnAction(actionEvent -> {
            type = "P11hi";
            printButton.setDisable(false);
            P0nu.setStyle("-fx-background-color: black; -fx-text-fill: white");
            T0nu.setStyle("-fx-background-color: black; -fx-text-fill: white");
            P0hi.setStyle("-fx-background-color: black; -fx-text-fill: white");
            T0hi.setStyle("-fx-background-color: black; -fx-text-fill: white");
            P11hi.setStyle("-fx-background-color: white; -fx-text-fill: black");
            T11hi.setStyle("-fx-background-color: black; -fx-text-fill: white");
        });

        P0hi.setOnAction(actionEvent -> {
            type = "P0hi";
            printButton.setDisable(false);
            P0nu.setStyle("-fx-background-color: black; -fx-text-fill: white");
            T0nu.setStyle("-fx-background-color: black; -fx-text-fill: white");
            P0hi.setStyle("-fx-background-color: white; -fx-text-fill: black");
            T0hi.setStyle("-fx-background-color: black; -fx-text-fill: white");
            P11hi.setStyle("-fx-background-color: black; -fx-text-fill: white");
            T11hi.setStyle("-fx-background-color: black; -fx-text-fill: white");
        });

        T11hi.setOnAction(actionEvent -> {
            type = "T11hi";
            printButton.setDisable(false);
            P0nu.setStyle("-fx-background-color: black; -fx-text-fill: white");
            T0nu.setStyle("-fx-background-color: black; -fx-text-fill: white");
            P0hi.setStyle("-fx-background-color: black; -fx-text-fill: white");
            T0hi.setStyle("-fx-background-color: black; -fx-text-fill: white");
            P11hi.setStyle("-fx-background-color: black; -fx-text-fill: white");
            T11hi.setStyle("-fx-background-color: white; -fx-text-fill: black");
        });

        T0hi.setOnAction(actionEvent -> {
            type = "T0hi";
            printButton.setDisable(false);
            P0nu.setStyle("-fx-background-color: black; -fx-text-fill: white");
            T0nu.setStyle("-fx-background-color: black; -fx-text-fill: white");
            P0hi.setStyle("-fx-background-color: black; -fx-text-fill: white");
            T0hi.setStyle("-fx-background-color: white; -fx-text-fill: black");
            P11hi.setStyle("-fx-background-color: black; -fx-text-fill: white");
            T11hi.setStyle("-fx-background-color: black; -fx-text-fill: white");
        });

    }

    @FXML
    void clickPrintButton(ActionEvent event) {
        tempHi = Double.parseDouble(hiField.getText()) * Math.pow(10, -5);
        betta = Double.parseDouble(bettaField.getText())* Math.pow(10, -5);
        tempNu = Double.parseDouble(nuField.getText()) * Math.pow(10, -5);
        nuValue.setText("ν = " + nuField.getText() + " * 10⁻⁵");
        pValue.setText("Pᵣ = " + String.format("%.3f", tempNu / tempHi));
        hiValue.setText("χ = " + hiField.getText() + " * 10⁻⁵");
        bettaValue.setText("β = " + bettaField.getText() + " * 10⁻⁵");
        printChart();
    }




    private void printChart() {

        XYChart.Series<Number, Number> series = new XYChart.Series<>();

        double result;
        switch (type) {
            case "P0nu":
                for (double z = doubleLX; z < doubleUX; z += 0.01) {
                    result = ((-12) * (tempNu / Math.pow(z, 2))) -
                            ((g * betta * Math.pow(Math.abs(z), 2 - 6 * tempNu / tempHi) * tempHi) / (
                                    ((2 - 6 * tempNu / tempHi) * (6 * tempNu - tempHi))
                            ));
                    //series.getData().add(new XYChart.Data<>(String.format("%.2f",z), result));
                    series.getData().add(new XYChart.Data<>(z, result));
                }
                break;
            case "T0nu":
                for (double z = doubleLX; z < doubleUX; z += 0.01) {
                    result = Math.pow(Math.abs(z), 1 - 6 * tempNu / tempHi)
                            / (1 - 6 * tempNu / tempHi);
                    //series.getData().add(new XYChart.Data<>(String.format("%.2f",z), result));
                    series.getData().add(new XYChart.Data<>(z, result));
                }

                break;
            case "P11hi":
                for (double z = doubleLX; z < doubleUX; z += 0.01) {
                    result = (-60 * tempNu * tempHi / Math.pow(z, 4))
                            + (g * betta / (8 * Math.pow(z, 8)));
                    //series.getData().add(new XYChart.Data<>(String.format("%.2f",z), result));
                    series.getData().add(new XYChart.Data<>(z, result));

                }

                break;
            case "P0hi":
                for (double z = doubleLX; z < doubleUX; z += 0.01) {
                    result = 1 / 9 * ((-10 * tempHi * (-3 * tempNu - 5 * tempHi)) / Math.pow(z, 2)
                            + ((g * betta) / (8 * Math.pow(z, 8))));
                    //series.getData().add(new XYChart.Data<>(String.format("%.2f",z), result));
                    series.getData().add(new XYChart.Data<>(z, result));

                }

                break;
            case "T11hi":
                for (double z = doubleLX; z < doubleUX; z += 0.01) {
                    result = (80 * (3 * tempNu - 5 * tempHi) * tempHi)
                            / (g * betta * Math.pow(z, 5));
                    //series.getData().add(new XYChart.Data<>(String.format("%.2f",z), result));
                    series.getData().add(new XYChart.Data<>(z, result));

                }

                break;
            case "T0hi":
                for (double z = doubleLX; z < doubleUX; z += 0.01) {
                    result = ((40 * (3 * tempNu - 5 * tempHi) * tempHi)
                            / (9 * g * betta * Math.pow(z, 5)))
                            - 1 / (9 * Math.pow(z, 9));
                    //series.getData().add(new XYChart.Data<>(String.format("%.2f",z), result));
                    series.getData().add(new XYChart.Data<>(z, result));

                }

                break;
        }
        mainChart.setData(FXCollections.observableArrayList(Collections.singleton(series)));

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        final StackPane chartContainer = new StackPane();
        final NumberAxis xAxis = (NumberAxis)mainChart.getXAxis();
        xAxis.setLowerBound(-10);
        xAxis.setUpperBound(0);
        final NumberAxis yAxis = (NumberAxis)mainChart.getYAxis();
        yAxis.setLowerBound(-2);
        yAxis.setUpperBound(2);
        chartContainer.getChildren().add(mainChart);

        final Rectangle zoomRect = new Rectangle();
        zoomRect.setManaged(false);
        zoomRect.setFill(Color.LIGHTSEAGREEN.deriveColor(0, 1, 1, 0.5));
        chartContainer.getChildren().add(zoomRect);

        setUpZooming(zoomRect, mainChart);

        final HBox controls = new HBox(10);
        controls.setPadding(new Insets(40));
        controls.setAlignment(Pos.CENTER);

        final Button zoomButton = new Button("Zoom");
        zoomButton.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-font-family: 'Times New Roman'");
        final Button resetButton = new Button("Reset");
        resetButton.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-font-family: 'Times New Roman'");
        zoomButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                zoomCount+=1;
                doZoom(zoomRect, mainChart);
            }
        });
        resetButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final NumberAxis xAxis = (NumberAxis)mainChart.getXAxis();
                xAxis.setLowerBound(-10);
                xAxis.setUpperBound(0);
                final NumberAxis yAxis = (NumberAxis)mainChart.getYAxis();
                yAxis.setLowerBound(-2);
                yAxis.setUpperBound(2);
                zoomCount=0;
                zoomRect.setWidth(0);
                zoomRect.setHeight(0);
                doubleLX = -10;
                doubleUX = 0;
                doubleLY = -2;
                doubleUY = 2;
            }
        });
        final BooleanBinding disableControls =
                zoomRect.widthProperty().lessThan(5)
                        .or(zoomRect.heightProperty().lessThan(5));
        zoomButton.disableProperty().bind(disableControls);
        controls.getChildren().addAll(zoomButton, resetButton);

        final BorderPane root = new BorderPane();
        root.setCenter(chartContainer);
        root.setBottom(controls);
        root.setLayoutX(263);
        root.setLayoutY(83);
        mainPage.getChildren().add(root);

    }

    private void setUpZooming(final Rectangle rect, final Node zoomingNode) {
        final ObjectProperty<Point2D> mouseAnchor = new SimpleObjectProperty<>();
        zoomingNode.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mouseAnchor.set(new Point2D(event.getX(), event.getY()));
                rect.setX(event.getX());
                rect.setY(event.getY());
                rect.setWidth(0);
                rect.setHeight(0);
            }
        });

        zoomingNode.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double x = event.getX();
                double y = event.getY();
                rect.setX(Math.min(x, mouseAnchor.get().getX()));
                rect.setY(Math.min(y, mouseAnchor.get().getY()));
                rect.setWidth(Math.abs(x - mouseAnchor.get().getX()));
                rect.setHeight(Math.abs(y - mouseAnchor.get().getY()));
            }
        });
    }


    private void doZoom(Rectangle zoomRect, LineChart<Number, Number> chart) {
        final NumberAxis xAxis = (NumberAxis) chart.getXAxis();
        final NumberAxis yAxis = (NumberAxis) chart.getYAxis();

        // Преобразование координат прямоугольника в координаты сцены
        Point2D zoomTopLeftScene = new Point2D(zoomRect.getX(), zoomRect.getY());
        Point2D zoomBottomRightScene = new Point2D(zoomRect.getX() + zoomRect.getWidth(), zoomRect.getY() + zoomRect.getHeight());

        // Преобразование координат из сцены в локальные координаты графика
        Point2D localTopLeft = chart.sceneToLocal(chart.localToScene(zoomTopLeftScene));
        Point2D localBottomRight = chart.sceneToLocal(chart.localToScene(zoomBottomRightScene));

        // Получение значений по осям для верхнего левого и нижнего правого углов прямоугольника
        double newLowerX = xAxis.getValueForDisplay(localTopLeft.getX()).doubleValue() - 0.3/zoomCount;
        double newUpperX = xAxis.getValueForDisplay(localBottomRight.getX()).doubleValue() - 0.3/zoomCount;
        double newLowerY = yAxis.getValueForDisplay(localBottomRight.getY()).doubleValue() + 0.4/zoomCount;
        double newUpperY = yAxis.getValueForDisplay(localTopLeft.getY()).doubleValue() + 0.4/zoomCount;

        // Обновление границ осей
        xAxis.setLowerBound(newLowerX);
        xAxis.setUpperBound(newUpperX);
        yAxis.setLowerBound(newLowerY);
        yAxis.setUpperBound(newUpperY);

        // Очистка прямоугольника выделения
        zoomRect.setWidth(0);
        zoomRect.setHeight(0);
        System.out.println("New Axis Bounds: X[" + newLowerX + ", " + newUpperX + "], Y[" + newLowerY + ", " + newUpperY + "]");

    }


    @FXML
    void onClickChangeAxis(ActionEvent event) {
        final NumberAxis xAxis = (NumberAxis)mainChart.getXAxis();
        if (!lx.getText().isEmpty()){
            xAxis.setLowerBound(Double.parseDouble(lx.getText()));
            doubleLX = Double.parseDouble(lx.getText());}
        if (!ux.getText().isEmpty()){
            xAxis.setUpperBound(Double.parseDouble(ux.getText()));
            doubleUX = Double.parseDouble(ux.getText());}
        final NumberAxis yAxis = (NumberAxis)mainChart.getYAxis();
        if (!ly.getText().isEmpty()){
            yAxis.setLowerBound(Double.parseDouble(ly.getText()));
            doubleLY = Double.parseDouble(ly.getText());}
        if (!uy.getText().isEmpty()){
            yAxis.setUpperBound(Double.parseDouble(uy.getText()));
            doubleUY = Double.parseDouble(uy.getText());}


    }





}
