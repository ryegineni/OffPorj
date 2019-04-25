package SampleProg;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class JourneyTest {

	public static void main(String[] args) {

		JourneyTest journyTest = new JourneyTest();
		journyTest.setAppType("AND");
		journyTest.setInitialJourneyLegOnly(false);
		journyTest.setVersionNumber("3.2.0");
		journyTest.setReservableAccomodationOptions("ALL");

		JourneyRequest journeyRequest = new JourneyRequest();
		journeyRequest.setType("OW");

		List<JourneyLegRequest> journeyLegRequests = new ArrayList<>();
		JourneyLegRequest journeyLegRequest = new JourneyLegRequest();
		journeyLegRequest.setDestination(new Destination("CHI"));

		Origin origin = new Origin();
		origin.setCode("ABQ");
		Schedule schedule = new Schedule();
		schedule.setDepartureDateTime("2019-03-01T00:00:00");
		origin.setSchedule(schedule);
		journeyLegRequest.setOrigin(origin);

		List<Passenger> passengers = new ArrayList<>();
		Passenger passenger = new Passenger();
		passenger.setId("P1");
		passenger.setType("F");
		passengers.add(passenger);

		journeyLegRequest.setPassengers(passengers);

		journeyLegRequests.add(journeyLegRequest);

		journeyRequest.setJourneyLegRequests(journeyLegRequests);

		journyTest.setJourneyRequest(journeyRequest);

		System.out.println(new Gson().toJson(journyTest));
	}

	private String reservableAccomodationOptions;
	private JourneyRequest journeyRequest;

	private boolean initialJourneyLegOnly;
	private String versionNumber;
	private String appType;

	public String getReservableAccomodationOptions() {
		return reservableAccomodationOptions;
	}

	public void setReservableAccomodationOptions(String reservableAccomodationOptions) {
		this.reservableAccomodationOptions = reservableAccomodationOptions;
	}

	public JourneyRequest getJourneyRequest() {
		return journeyRequest;
	}

	public void setJourneyRequest(JourneyRequest journeyRequest) {
		this.journeyRequest = journeyRequest;
	}

	public boolean isInitialJourneyLegOnly() {
		return initialJourneyLegOnly;
	}

	public void setInitialJourneyLegOnly(boolean initialJourneyLegOnly) {
		this.initialJourneyLegOnly = initialJourneyLegOnly;
	}

	public String getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}
}

class JourneyRequest {

	private String type;
	private List<JourneyLegRequest> journeyLegRequests;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<JourneyLegRequest> getJourneyLegRequests() {
		return journeyLegRequests;
	}

	public void setJourneyLegRequests(List<JourneyLegRequest> journeyLegRequests) {
		this.journeyLegRequests = journeyLegRequests;
	}
}

class JourneyLegRequest {

	private Origin origin;
	private Destination destination;
	private List<Passenger> passengers;

	public Origin getOrigin() {
		return origin;
	}

	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
}

class Destination {
	private String code;

	public Destination(String code) {
		super();
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}

class Origin {
	private String code;
	private Schedule schedule;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
}

class Schedule {
	private String departureDateTime;

	public String getDepartureDateTime() {
		return departureDateTime;
	}

	public void setDepartureDateTime(String departureDateTime) {
		this.departureDateTime = departureDateTime;
	}
}

class Passenger {
	private String type;
	private String id;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
