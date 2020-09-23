


import de.gsi.chart.marker.Marker;
import de.gsi.chart.plugins.*;
import de.gsi.chart.XYChart;
import de.gsi.chart.axes.spi.DefaultNumericAxis;

import de.gsi.chart.renderer.ErrorStyle;
import de.gsi.chart.renderer.LineStyle;
import de.gsi.chart.renderer.spi.ErrorDataSetRenderer;
import de.gsi.chart.ui.geometry.Side;
import de.gsi.dataset.AxisDescription;
import de.gsi.dataset.spi.DefaultErrorDataSet;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;


public class BarChart extends XYChart  {

    final ErrorDataSetRenderer errorRenderer2 = new ErrorDataSetRenderer();
    private DefaultNumericAxis yAxes;
    private DefaultNumericAxis xAxes;

    public BarChart() {

        super(new DefaultNumericAxis(50, 2, 5), new DefaultNumericAxis(" "));

        yAxes = getYAxis();
        xAxes = getXAxis();
//        yAxes.setAutoRangePadding(0.2);
//        yAxes.setAutoRanging(false); // don't automatically change the range if points exceed the min/max values
//        xAxes.setAutoRanging(false);
//        getPlugins().add(new ParameterMeasurements());
//        getPlugins().add(new Panner());
//        getPlugins().add(new Zoomer());
//        getPlugins().add(new TableViewer());
        setHorizontalGridLinesVisible(false);
        setVerticalGridLinesVisible(false);
        setPrefHeight(150);
        setLegendVisible(false);
        setPrefHeight(150);
        xAxes.setUnit(null);
        yAxes.setUnit(null);
        xAxes.set(20.0, 0.0);
        yAxes.set(0.0, 200.0);
        xAxes.invertAxis(true);
        xAxes.invertAxisProperty().setValue(true);
        VBox.setVgrow(this, Priority.ALWAYS);
        HBox.setHgrow(this, Priority.ALWAYS);


        final DefaultErrorDataSet dataSet_Default = new DefaultErrorDataSet("dataSet_Default");
        final DefaultErrorDataSet dataSet_Normalised = new DefaultErrorDataSet("dataSet_Normalised");
        final DefaultErrorDataSet dataSet_Valid = new DefaultErrorDataSet("dataSet_Valid");
        dataSet_Default.setStyle("-fx-stroke: rgb(0, 0, 0)");
        dataSet_Normalised.setStyle("-fx-stroke: rgb(3, 103, 219)");
        dataSet_Valid.setStyle("-fx-stroke: grey");


        for (int i = 0; i < 200; i++) {
            if(i/5 == 0){
                dataSet_Default.add(i, i*2);
            }else if (i/10==0){
                dataSet_Normalised.add(i, i*2);
            }else {
                dataSet_Valid.add(i, i*2);
            }
        }

        dataSet_Default.add(21, 0);
        errorRenderer2.getDatasets().addAll(dataSet_Default, dataSet_Normalised, dataSet_Valid);
        errorRenderer2.setPolyLineStyle(LineStyle.NONE);
        errorRenderer2.setBarWidth(20);

        errorRenderer2.setAllowNaNs(false);
        errorRenderer2.setDrawBubbles(false);
        errorRenderer2.setShowInLegend(false);
//        errorRenderer2.setPointReduction(false);
//        errorRenderer2.setDrawChartDataSets(false);
        setStyle("-fx-stroke: blue;");

        errorRenderer2.setDrawBars(true);
        errorRenderer2.setBarWidth(20);
        errorRenderer2.setDrawMarker(false);
        errorRenderer2.drawMarkerProperty().setValue(false);
        errorRenderer2.markerSizeProperty().setValue(0);
        errorRenderer2.markerSizeProperty().set(0);
        errorRenderer2.setDrawBubbles(false);
        errorRenderer2.setDrawChartDataSets(false);
        errorRenderer2.setDashSize(0);
        errorRenderer2.setDrawMarker(false);
        errorRenderer2.setDrawChartDataSets(false);
        errorRenderer2.setIntensityFading(0);
        errorRenderer2.setMarkerSize(0);
        errorRenderer2.setDashSize(0);

        this.getRenderers().setAll(errorRenderer2);
    }

    @Override
    public DefaultNumericAxis getXAxis() {
        return (DefaultNumericAxis) super.getXAxis();
    }

    @Override
    public DefaultNumericAxis getYAxis() {
        return (DefaultNumericAxis) super.getYAxis();
    }
}
