package de.berlin.fu.client;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.VisualizationUtils;
import com.google.gwt.visualization.client.visualizations.LineChart;
import com.google.gwt.visualization.client.visualizations.LineChart.Options;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.tab.events.TabSelectedEvent;
import com.smartgwt.client.widgets.tab.events.TabSelectedHandler;

import de.berlin.fu.data.dto.Event;
import de.berlin.fu.data.dto.EventType;
import de.berlin.fu.data.dto.Property;
import de.berlin.fu.data.dto.PropertyType;
import de.berlin.fu.data.dto.Sensor;
import de.berlin.fu.shared.MyServer;
import de.berlin.fu.shared.MyServerAsync;

public class TelproGWT implements EntryPoint {

	private final MyServerAsync server = GWT.create(MyServer.class);

	private ListGrid eventTable;

	ListBox sensorBox;

	private HashMap<String, Sensor> sensors;

	private HashMap<Integer, PropertyType> propTypes;
	private HashMap<Integer, EventType> eventTypes;

	private HashMap<Integer, LineChart> lineCharts;
	private LineChart temperature;
	private LineChart humidity;
	private LineChart tilt;
	private LineChart roll;

	private Panel panel;

	private boolean firstClick = true;

	private Label textSelectednode;
	private Label eventLabelHeader;

	private final DateTimeFormat formatter = DateTimeFormat
			.getFormat("HH:mm:ss");

	private TabSet tabBar;

	@Override
	public void onModuleLoad() {
		sensors = new HashMap<String, Sensor>();
		propTypes = new HashMap<Integer, PropertyType>();
		eventTypes = new HashMap<Integer, EventType>();
		lineCharts = new HashMap<Integer, LineChart>();

		panel = RootPanel.get();

		getAllPropertyTypes();
		getAllEventTypes();

		createTabMenu();
		createSensorSelection();
		updateSensorSelection();

	}

	private void createTabMenu() {
		tabBar = new TabSet();
		tabBar.setTabBarPosition(Side.TOP);
		tabBar.setTabBarAlign(Side.LEFT);
		tabBar.setWidth(400);
		tabBar.setHeight(200);

	}

	/**
	 * Save all PropertyTypes in a HashMap, because we need the types several
	 * times
	 */
	private void getAllPropertyTypes() {
		server.getPropertyTypes(new AsyncCallback<List<PropertyType>>() {

			@Override
			public void onSuccess(List<PropertyType> result) {
				for (PropertyType type : result) {
					propTypes.put(type.getIdPropertyType(), type);
				}

			}

			@Override
			public void onFailure(Throwable caught) {
				SC.say("Error",
						"Ups.. you have no access to database. Please reload the page! Propertytype");

			}
		});
	}

	private void getAllEventTypes() {
		server.getEventTypes(new AsyncCallback<List<EventType>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(List<EventType> result) {
				for (EventType etype : result) {
					eventTypes.put(etype.getIdEventType(), etype);
				}

			}
		});

	}

	private Options createChartOptions(String title) {
		Options options = Options.create();
		options.setWidth(600);
		options.setHeight(240);
		options.setTitle(title);
		return options;
	}

	private AbstractDataTable createTable(List<Property> list, String title) {

		DataTable data = DataTable.create();
		data.addColumn(ColumnType.STRING, "Time");
		data.addColumn(ColumnType.NUMBER, title);
		int i = 0;
		if (list != null) {
			data.addRows(list.size());
			for (Property p : list) {
				Date time = p.getTimestamp();
				data.setValue(i, 0, formatter.format(time));
				data.setValue(i, 1, p.getValue());
				i++;
			}
		}

		return data;
	}

	private void drawCharts() {
		// add Charts
		Runnable onLoadCallback = new Runnable() {
			@Override
			public void run() {
				for (final Integer pType : propTypes.keySet()) {
					final String properyTypeName = propTypes.get(pType)
							.getName();
					final Tab propTab = new Tab(properyTypeName);

					propTab.addTabSelectedHandler(new TabSelectedHandler() {

						@Override
						public void onTabSelected(TabSelectedEvent event) {
							HLayout chartLayout = new HLayout();
							chartLayout.setHeight(400);
							chartLayout.setWidth(1000);
							chartLayout.setMembersMargin(20);
							chartLayout.setLayoutMargin(10);

							LineChart chart = new LineChart(createTable(null,
									properyTypeName),
									createChartOptions(properyTypeName));
							lineCharts.put(pType, chart);

							chartLayout.addMember(chart);

							propTab.setPane(chartLayout);

						}
					});

					tabBar.addTab(propTab);
					// int counter =0;
					// HLayout chartLayout;
					// if(counter==0){
					// //create HLayout (one HLayout for
					// chartLayout = new HLayout();
					// chartLayout.setHeight(400);
					// chartLayout.setWidth(1000);
					// chartLayout.setMembersMargin(20);
					// chartLayout.setLayoutMargin(10);
					//
					// counter++;
					// }else if(counter==1){
					//
					// }
					//
					// String properyTypeName = propTypes.get(pType).getName();
					// LineChart chart = new LineChart(createTable(null,
					// properyTypeName),
					// createChartOptions(properyTypeName));
					// lineCharts.put(pType, chart);
					//
					// chartLayout.addMember(chart);

				}
				panel.add(tabBar);
				// HLayout tempAndHum = new HLayout();
				// tempAndHum.setHeight(400);
				// tempAndHum.setWidth(1000);
				// tempAndHum.setMembersMargin(20);
				// tempAndHum.setLayoutMargin(10);
				//
				// temperature = new LineChart(createTable(null, "Temperature"),
				// createChartOptions("Temperature"));
				// humidity = new LineChart(createTable(null, "Humidity"),
				// createChartOptions("Humidity"));
				// tempAndHum.addMember(temperature);
				// tempAndHum.addMember(humidity);
				//
				// HLayout tiltAndRoll = new HLayout();
				// tiltAndRoll.setHeight(400);
				// tiltAndRoll.setWidth(1000);
				// tiltAndRoll.setMembersMargin(20);
				// tiltAndRoll.setLayoutMargin(10);
				//
				// tilt = new LineChart(createTable(null, "Tilt"),
				// createChartOptions("Tilt"));
				// roll = new LineChart(createTable(null, "Roll"),
				// createChartOptions("Roll"));
				//
				// tiltAndRoll.addMember(tilt);
				// tiltAndRoll.addMember(roll);
				//
				// panel.add(tempAndHum);
				// panel.add(tiltAndRoll);
			}
		};

		// Load the visualization api, passing the onLoadCallback to be called
		// when loading is done.
		VisualizationUtils.loadVisualizationApi(onLoadCallback,
				LineChart.PACKAGE);
	}

	private void createSensorSelection() {
		HLayout boxWithLayer = new HLayout();
		boxWithLayer.setMembersMargin(20);
		boxWithLayer.setLayoutMargin(10);
		boxWithLayer.setHeight(200);

		VLayout sensorBoxWithButton = new VLayout();
		sensorBoxWithButton.setShowEdges(true);
		sensorBoxWithButton.setEdgeSize(3);
		sensorBoxWithButton.setHeight(200);
		sensorBoxWithButton.setWidth(600);
		sensorBoxWithButton.setMembersMargin(20);
		sensorBoxWithButton.setLayoutMargin(10);

		sensorBox = new ListBox();

		textSelectednode = new Label();
		textSelectednode.setContents("<h4>Please select a sensor node! </h4>");

		Button showDia = new Button("Show Diagrams");
		addClickhandlerToShowDia(showDia);

		boxWithLayer.addMember(sensorBox);
		boxWithLayer.addMember(textSelectednode);

		sensorBoxWithButton.addMember(boxWithLayer);
		sensorBoxWithButton.addMember(showDia);

		sensorBoxWithButton.setDefaultLayoutAlign(Alignment.CENTER);

		panel.add(sensorBoxWithButton);

	}

	/**
	 * Get the Sensor-ID from Database and add the ID's to the ListBox
	 */
	private void updateSensorSelection() {

		server.getSensors(new AsyncCallback<List<Sensor>>() {

			@Override
			public void onFailure(Throwable caught) {
				SC.say("Error",
						"Ups.. you have no access to database. Please reload the page! Sensor");

			}

			@Override
			public void onSuccess(List<Sensor> result) {
				for (Sensor s : result) {
					// save the Sensors, because we need the nodes later
					String sensorID = s.getIdSensor();
					sensors.put(sensorID, s);

					sensorBox.addItem(sensorID);

				}

			}

		});

	}

	/**
	 * If the user click the Button, he get the selected node and load the
	 * diagrams of this node
	 * 
	 * @param showDia
	 *            Button
	 */
	private void addClickhandlerToShowDia(Button showDia) {
		showDia.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String sensorID = "";
				try {
					int selectedItemIndex = sensorBox.getSelectedIndex();
					sensorID = sensorBox.getValue(selectedItemIndex);

					if (firstClick) {
						drawCharts();
						drawEventTable();
						firstClick = false;
					}
					textSelectednode
							.setContents("<h4>Diagrams from node: </h4>"
									+ sensorID);
					// failure here... think, the diagrams are not ready
					// getProperties(sensorID, "temperature");
					// getProperties(sensorID, "humidity");
					startTimer(sensorID);

					showEvents(sensorID);
				} catch (NullPointerException ex) {
					SC.say("Error", "Please select a sensor node!");
				}
			}
		});

	}

	private void getProperties(String sensorID, final String type) {
		Sensor sensor = sensors.get(sensorID);

		PropertyType proType = propTypes.get(type);

		server.getProperty(sensor, proType, 30,
				new AsyncCallback<List<Property>>() {

					@Override
					public void onSuccess(List<Property> result) {
						AbstractDataTable table = createTable(result, type);
						if (type.equals("temperature")) {
							temperature.draw(table);
						} else if (type.equals("humidity")) {
							humidity.draw(table);
						} else if (type.equals("tilt")) {
							tilt.draw(table);
						} else {
							roll.draw(table);
						}

					}

					@Override
					public void onFailure(Throwable caught) {
						SC.say("Error",
								"Ups.. you have no access to database. Please reload the page! Property");
					}
				});

	}

	private void startTimer(final String sensorID) {
		Timer t = new Timer() {
			@Override
			public void run() {

				// getProperties(sensorID, "temperature");
				// getProperties(sensorID, "humidity");
				// getProperties(sensorID, "tilt");
				// getProperties(sensorID, "roll");
			}
		};

		// get all 5 sec new properties
		// t.scheduleRepeating(5000);
		t.schedule(5000);

	}

	private void drawEventTable() {
		VLayout eventTableLayout = new VLayout();
		eventTableLayout.setShowEdges(true);
		eventTableLayout.setEdgeSize(3);
		eventTableLayout.setHeight(300);
		eventTableLayout.setWidth(600);
		eventTableLayout.setMembersMargin(10);
		eventTableLayout.setLayoutMargin(10);

		eventLabelHeader = new Label();
		eventTableLayout.addMember(eventLabelHeader);

		eventTable = new ListGrid();
		ListGridField timestamp = new ListGridField("timestamp", "Timestamp");
		ListGridField eventtype = new ListGridField("eventtype", "Event type");
		ListGridField eventdecription = new ListGridField("eventdecription",
				"Description type");
		ListGridField sensorId = new ListGridField("sensorId", "Sensor ID");
		eventTable.setFields(timestamp, eventtype, eventdecription, sensorId);

		eventTableLayout.addMember(eventTable);
		panel.add(eventTableLayout);
	}

	private void showEvents(String sensorID) {
		eventLabelHeader.setContents("<h3>Events from sensor node: " + sensorID
				+ "</h3>");
		// remove old records in table
		ListGridRecord[] records = eventTable.getRecords();
		for (int i = 0; i < records.length; i++) {
			eventTable.removeData(records[i]);
		}
		server.getEventList(new AsyncCallback<List<Event>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(List<Event> result) {
				for (Event e : result) {
					ListGridRecord eventInfo = new ListGridRecord();
					eventInfo.setAttribute("timestamp", e.getTimestamp()
							.toString());
					EventType eventType = eventTypes.get(e
							.getEventtypeIdeventtype());
					eventInfo.setAttribute("eventtype", eventType.getName());
					eventInfo.setAttribute("eventdecription",
							eventType.getDescription());
					eventInfo.setAttribute("sensorId", e.getSensorIdsensor());
					eventTable.addData(eventInfo);
				}

			}
		});

	}
}
