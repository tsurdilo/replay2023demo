package io.temporal.replaydemo.business.model;

import javax.persistence.*;

@Entity
@Table(name = "resources")
public class RegisteredResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String kind;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String taskqueue;

    public RegisteredResource() {}

    public RegisteredResource(Integer id, String kind, String type, String taskqueue) {
        this.id = id;
        this.kind = kind;
        this.type = type;
        this.taskqueue = taskqueue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTaskqueue() {
        return taskqueue;
    }

    public void setTaskqueue(String taskqueue) {
        this.taskqueue = taskqueue;
    }
}
