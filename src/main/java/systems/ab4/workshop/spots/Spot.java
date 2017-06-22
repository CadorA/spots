package systems.ab4.workshop.spots;

import javax.activity.ActivityCompletedException;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table

public class Spot {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name = "id" , unique=true , nullable=false )
    private Long id;

    @Column
    private String name;

    @Column
    @NotNull
    private Date startSeason;

    @Column
    @NotNull
    private Date endSeason;

    public Date getStartSeason() {
        return startSeason;
    }

    public Date getEndSeason() {
        return endSeason;
    }

    public void setStartSeason(Date startSeason) {
        this.startSeason = startSeason;
    }

    public void setEndSeason(Date endSeason) {
        this.endSeason = endSeason;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }

    public Double getCost() {
        return cost;
    }

    public Set<Activity> getActivities() {
        return activities;
    }

    @Column
    @NotNull
    private Double cost;

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @ManyToOne
    @NotNull

    private Location location;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @NotNull
    private Set<Activity> activities;


    public Spot() {
    }

    public Spot(String name, Date startSeason, Date endSeason, Double cost, Location location, Set<Activity> activities) {
        this.name = name;
        this.startSeason = startSeason;
        this.endSeason = endSeason;
        this.cost = cost;
        this.location = location;
        this.activities = activities;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Spot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location=" + location +
                '}';
    }
}
