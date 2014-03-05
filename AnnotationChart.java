package com.miljan.project.shared;

import com.google.gwt.ajaxloader.client.ArrayHelper;
import com.google.gwt.ajaxloader.client.JsDate;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.Element;
import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.AbstractDrawOptions;
import com.google.gwt.visualization.client.DateRange;
import com.google.gwt.visualization.client.Selection;
import com.google.gwt.visualization.client.visualizations.Visualization;

import java.util.Date;
import java.util.Map;


/**
 * Annotation Chart visualization. May be loaded by calling: <code>
 * google.load("visualization", "1.1", {packages:["annotationchart"]});
 * </code>
 * 
 * 
 * @see <a
 *      href="https://developers.google.com/chart/interactive/docs/gallery/annotationchart"
 *      > Annotation Chart Visualization Reference. </a>
 *
 */
public class AnnotationChart extends Visualization<AnnotationChart.Options> {

	/**
	   * Where to put the colored legend with respect to the date.
	   */
  public static enum AnnotatedLegendPosition {
    /**
     * Put the colored legend on a new row.
     */
    NEW_ROW,

    /**
     * Put the colored legend on the same row as the date.
     */
    SAME_ROW;

    @Override
    public String toString() {
      switch (this) {
        case SAME_ROW:
          return "sameRow";
        case NEW_ROW:
          return "newRow";
        default:
          // unreachable
          assert false;
      }
      // unreachable
      return null;
    }
  }

  /**
   * Options for drawing the chart.
   * 
   */
  public static class Options extends AbstractDrawOptions {
    public static Options create() {
      return JavaScriptObject.createObject().cast();
    }

    protected Options() {
    }

    public final native void setAllowHtml(boolean allowHtml) /*-{
      this.allowHtml = allowHtml;
    }-*/;

    public final native void setAllValuesSuffix(String suffix) /*-{
      this.allValuesSuffix = suffix;
    }-*/;

    public final native void setAnnotationsWidth(int width) /*-{
      this.annotationsWidth = width;
    }-*/;

    public final native void setColors(JsArrayString colors) /*-{
      this.colors = colors;
    }-*/;

    public final void setColors(String... colors) {
      setColors(ArrayHelper.toJsArrayString(colors));
    }

    public final native void setDateFormat(String dateFormat) /*-{
      this.dateFormat = dateFormat;
    }-*/;

    public final native void setDisplayAnnotations(boolean display) /*-{
      this.displayAnnotations = display;
    }-*/;

    public final native void setDisplayAnnotationsFilter(boolean display) /*-{
      this.displayAnnotationsFilter = display;
    }-*/;

    public final native void setDisplayDateBarSeparator(boolean display) /*-{
      this.displayDateBarSeparator = display;
    }-*/;

    public final native void setDisplayExactValues(boolean display) /*-{
      this.displayExactValues = display;
    }-*/;

    public final native void setDisplayLegendDots(boolean display) /*-{
      this.displayLegendDots = display;
    }-*/;

    public final native void setDisplayLegendValues(boolean display) /*-{
      this.displayLegendValues = display;
    }-*/;

    public final native void setDisplayRangeSelector(boolean display) /*-{
      this.displayRangeSelector = display;
    }-*/;

    public final native void setDisplayZoomButtons(boolean display) /*-{
      this.displayZoomButtons = display;
    }-*/;

    public final native void setFill(int fill) /*-{
      this.fill = fill;
    }-*/;

    public final void setLegendPosition(AnnotatedLegendPosition position) {
      setLegendPosition(position.toString());
    }

    public final native void setMax(int max) /*-{
      this.max = max;
    }-*/;

    public final native void setMin(int min) /*-{
      this.min = min;
    }-*/;

    public final native void setNumberFormat(String numberFormat) /*-{
      this.numberFormats = numberFormat;
    }-*/;

    public final void setNumberFormats(Map<Integer, String> numberFormats) {
      resetNumberFormats();
      for (Integer key : numberFormats.keySet()) {
        String numberFormat = numberFormats.get(key);
        setNumberFormats(key, numberFormat);
      }
    }

    public final void setScaleColumns(int... scaleColumns) {
      setScaleColumns(ArrayHelper.toJsArrayInteger(scaleColumns));
    }

    public final native void setScaleColumns(JsArrayInteger scaleColumns) /*-{
      this.scaleColumns = scaleColumns;
    }-*/;

    public final native void setScaleFormat(String scaleFormat) /*-{
      this.scaleFormat = scaleFormat;
    }-*/;

    public final void setScaleType(ScaleType type) {
      setScaleType(type.getParameter());
    }

    public final native void setThickness(int thickness) /*-{
      this.thickness = thickness;
    }-*/;

    public final void setZoomEndTime(Date endTime) {
      setZoomEndTime(endTime.getTime());
    }

    public final void setZoomStartTime(Date startTime) {
      setZoomStartTime(startTime.getTime());
    }

    private native void resetNumberFormats() /*-{
      this.numberFormats = {};
    }-*/;

    private native void setLegendPosition(String position) /*-{
      this.legendPosition = position;
    }-*/;

    private native void setNumberFormats(int key, String numberFormat) /*-{
      this.numberFormats[key] = numberFormat;
    }-*/;

    private native void setScaleType(String type) /*-{
      this.scaleType = type;
    }-*/;

    private native void setZoomEndTime(double endTime) /*-{
      this.zoomEndTime = new $wnd.Date(endTime);
    }-*/;

    private native void setZoomStartTime(double startTime) /*-{
      this.zoomStartTime = new $wnd.Date(startTime);
    }-*/;
  }

  /**
   * Scale type for the chart.
   * 
   * When ALLFIXED or ALLMAXIMIZE are used, it makes sense to set the
   * scaleColumns option as well, otherwise some of the series will be displayed
   * in a scale that is not the displayed one.
   */
  public static enum ScaleType {
    /**
     * Set the range of the values axis to be from 0 to the maximal value in
     * each series.
     */
    ALLFIXED("allfixed"),

    /**
     * Set the range of the values axis to be from the minimal value of each
     * series to the maximal value of each series.
     */
    ALLMAXIMIZE("allmaximize"),

    /**
     * Set the range of the values axis to be from 0 to the maximal value in the
     * input DataTable.
     */
    FIXED("fixed"),

    /**
     * Set the range of the values axis to be from the minimal value in the
     * input DataTable to the maximal value in the input DataTable.
     */
    MAXIMIZE("maximize");

    private final String parameter;

    ScaleType(String parameter) {
      this.parameter = parameter;
    }

    /**
     * Get the String representation of the ScaleType.
     * 
     * @return the String representation of the ScaleType.
     */
    public String getParameter() {
      return parameter;
    }
  }

  public static final String PACKAGE = "annotationchart";

  /**
   * 
   * @param data data to visualize
   * @param options Optional parameters for the visualization
   * @param width the CSS specifier for the width of the visualization
   * @param height the CSS specifier for the height of the visualization
   */
  public AnnotationChart(AbstractDataTable data, Options options, String width, String height) {
    super(data, options);
    setSize(width, height);
  }

  /**
   * 
   * @param width the CSS specifier for the width of the visualization
   * @param height the CSS specifier for the height of the visualization
   */
  public AnnotationChart(String width, String height) {
    super();
    setSize(width, height);
  }

  public final JsArray<Selection> getSelections() {
    return Selection.getSelections(this);
  }

  public final DateRange getVisibleChartRange() {
    JsArray<JsDate> dates = getVisibleChartRange(getJso());
    if (dates == null) {
      return null;
    }

    Date start = JsDate.toJava(dates.get(0));
    Date end = JsDate.toJava(dates.get(1));
    return new DateRange(start, end);
  }

  public final void hideDataColumns(int... columnIndexes) {
    hideDataColumns(ArrayHelper.toJsArrayInteger(columnIndexes));
  }

  public final void hideDataColumns(JsArrayInteger columnIndexes) {
    this.hideDataColumns(getJso(), columnIndexes);
  };

  public final void setVisibleChartRange(Date startTime, Date endTime) {
    this.setVisibleChartRange(getJso(), startTime.getTime(), endTime.getTime());
  }

  public final void showDataColumns(int... columnIndexes) {
    showDataColumns(ArrayHelper.toJsArrayInteger(columnIndexes));
  }

  public final void showDataColumns(JsArrayInteger columnIndexes) {
    this.showDataColumns(getJso(), columnIndexes);
  };

  @Override
  protected native JavaScriptObject createJso(Element parent) /*-{
    return new $wnd.google.visualization.AnnotationChart(parent);
  }-*/;

  private native JsArray<JsDate> getVisibleChartRange(JavaScriptObject jso) /*-{
    var dates = jso.getVisibleChartRange();
    if (dates == null) {
      return null;
    }
    return [dates['start'], dates['end']];
  }-*/;

  private native void hideDataColumns(JavaScriptObject jso,
      JsArrayInteger columnIndexes) /*-{
    jso.hideDataColumns(columnIndexes);
  }-*/;

  private native void setVisibleChartRange(JavaScriptObject jso,
      double startTime, double endTime) /*-{
    jso.setVisibleChartRange(new $wnd.Date(startTime), 
        new $wnd.Date(endTime));
  }-*/;

  private native void showDataColumns(JavaScriptObject jso,
      JsArrayInteger columnIndexes) /*-{
    jso.showDataColumns(columnIndexes);
  }-*/;
}
