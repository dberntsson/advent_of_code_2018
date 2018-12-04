import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Guard {
	private String id;
	private List<Integer> summarySleep;
	private List<String> registeredSleepTimes;
	private Integer maxSleepMinuteCount = 0;
	private Integer maxSleepMinute = 0;
	private Integer totalSleepHours = 0;
	
	public Guard (String id, List<String> registeredSleepTimes) {
		this.id = id;
		this.registeredSleepTimes = registeredSleepTimes;
		summarize();
	}

	private void summarize() {
		List<Integer> summary = generateNoSleep();
		Integer total = 0;
		if (registeredSleepTimes != null) {
			for (Iterator<String> iter = registeredSleepTimes.iterator(); iter.hasNext();) {
				final String sleepTime = iter.next();
				for (int i = 0; i < sleepTime.length(); i++) {
					if (sleepTime.charAt(i) == '#') {
						Integer slept = summary.get(i);
						Integer newCount = slept + 1;
						if (newCount > this.getMaxSleepMinuteCount()) {
							this.maxSleepMinuteCount = newCount;
							this.maxSleepMinute = i;
						}
						summary.set(i, newCount);
						total++;
					}
				}
			}
			this.totalSleepHours = total;
		}
		this.summarySleep = summary;
	}

	private List<Integer> generateNoSleep() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 60; i++) {
			list.add(0);
		}
		return list;
	}

	public String getId() {
		return id;
	}

	public List<Integer> getSummarySleep() {
		return summarySleep;
	}

	public Integer getMaxSleepMinuteCount() {
		return maxSleepMinuteCount;
	}

	public Integer getMaxSleepMinute() {
		return maxSleepMinute;
	}

	public Integer getTotalSleepHours() {
		return totalSleepHours;
	}
}
