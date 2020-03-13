package rq222ah_Assign1;

import java.util.ArrayList;
import java.util.List;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;

public class SinMain {

	public static void main(String[] args) {

		org.knowm.xchart.XYChart chart = new XYChartBuilder().width(800).height(600).build();
		chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Line);
		chart.getStyler().setMarkerSize(1);

		List<Double> xValues = new ArrayList<Double>();
		List<Double> yValues = new ArrayList<Double>();

		double downLimit = 0.0;
		double upLimit = 2 * Math.PI;
		double xIs = downLimit;

		while ((xIs += 0.01) <= upLimit) {
			xValues.add(xIs);
			yValues.add(getY(xIs));
		}

		chart.addSeries("Cosine curve", xValues, yValues);

		new SwingWrapper(chart).displayChart();
	}

	private static double getY(double x) {
		return (1 + x / Math.PI) * Math.cos(x) * Math.cos(40 * x);
	}

}
