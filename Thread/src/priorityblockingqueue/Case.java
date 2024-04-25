package priorityblockingqueue;

public class Case implements Comparable{

    private String type;
    private Integer priority;

    public Case(String type, Integer priority) {
        this.type = type;
        this.priority = priority;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(Object o) {
        return -this.getPriority().compareTo(((Case)o).getPriority());
    }
}
