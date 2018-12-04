import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LogEntry implements Comparable<LogEntry> {

	static final int WAKES_UP = 1;
	static final int FALLS_ASLEEP = 2;
	static final int BEGIN_SHIFT = 3;

	private Date eventDate;
	private String event;
	
	public LogEntry(String logRow) {
		super();
		this.eventDate = identifyDate(logRow);
		this.event = identifyEvent(logRow);
	}

	private String identifyEvent(String logRow) {
		return logRow.split("]")[1].strip();
	}

	private Date identifyDate(String logRow) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.ENGLISH);
		try {
			return format.parse(logRow.split("]")[0].replace("[", "").replace("1518", "2018").strip());
		} catch (ParseException e) {
			return null;
		}
	}

	public Date getEventDate() {
		return eventDate;
	}

	public String getEvent() {
		return event;
	}

	public Integer getEventType() {
		if (this.event == null)
			return null;
		else if (this.event.contains("wakes up"))
			return WAKES_UP;
		else if (this.event.contains("falls asleep"))
			return FALLS_ASLEEP;
		else if (this.event.contains("begins shift"))
			return BEGIN_SHIFT;
		return null;
	}

	@Override
	public int compareTo(LogEntry o) {
		if (o != null && this.getEventDate() != null && o.getEventDate().before(this.eventDate))
			return 1;
		if (o != null && this.getEventDate() != null && o.getEventDate().after(this.eventDate))
			return -1;
		return 0;
	}
}
