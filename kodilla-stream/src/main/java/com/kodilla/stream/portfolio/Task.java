package com.kodilla.stream.portfolio;

import java.time.LocalDate;

public class Task {

    private final String title;
    private final String description;
    private final User assignedUser;
    private final User creator;
    private final LocalDate created;
    private final LocalDate deadline;

    public Task(final String title,final String description,final User assignedUser,final User creator,final LocalDate created,final LocalDate deadline) {
        this.title = title;
        this.description = description;
        this.assignedUser = assignedUser;
        this.creator = creator;
        this.created = created;
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public User getCreator() {
        return creator;
    }

    public LocalDate getCreated() {
        return created;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Task{");
        sb.append("title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", assignedUser=").append(assignedUser);
        sb.append(", creator=").append(creator);
        sb.append(", created=").append(created);
        sb.append(", deadline=").append(deadline);
        sb.append('}');
        return sb.toString();
    }
}
