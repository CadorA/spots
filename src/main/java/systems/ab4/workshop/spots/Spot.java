package systems.ab4.workshop.spots;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table

public class Spot {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name = "id" , unique=true , nullable=false )
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @NotNull
    private Location location;

    public Spot() {
    }

    public Spot(String name, Location location) {
        this.name = name;
        this.location = location;
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
