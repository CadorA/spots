package systems.ab4.workshop.spots;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table

public class Location {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name = "id" , unique=true , nullable =false )
    private Long id;

    @Column
    @NotNull
    private String name;

    @ManyToOne
    private Location parent;

    @Enumerated(EnumType.STRING)
    private LocationType type;

    protected Location() {
    }

    public Location(String name, Location parent, LocationType type) {
        this.name = name;
        this.parent = parent;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Location getParent() {
        return parent;
    }

    public LocationType getType() {
        return type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParent(Location parent) {
        this.parent = parent;
    }

    public void setType(LocationType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parent=" + parent +
                ", type=" + type +
                '}';
    }
}
