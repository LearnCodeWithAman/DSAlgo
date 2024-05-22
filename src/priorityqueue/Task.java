package priorityqueue;

class Task {
    int value;
    int priority;

    public Task(int value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "value= " + value + ", priority= " + priority;
    }
}
