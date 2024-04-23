package delayqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedMission implements Delayed {

    private String mission;
    private long duration;

    public DelayedMission(String mission, long delayInMilliseconds) {
        this.mission = mission;
        this.duration = System.currentTimeMillis() + delayInMilliseconds;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(duration - System.currentTimeMillis(),TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
