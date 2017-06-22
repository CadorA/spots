package systems.ab4.workshop.spots;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

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

    @OneToMany(mappedBy = "parent" ,fetch = FetchType.EAGER)
    private List<Location> children;

    @Enumerated(EnumType.STRING)
    private LocationType type;

    @OneToMany(mappedBy = "location")
    private List<Spot> spots;

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

    public void setChildren(List<Location> children) {
        this.children = children;
    }

    public void setSpots(List<Spot> spots) {
        this.spots = spots;
    }

    public List<Location> getChildren() {

        return children;
    }

    public List<Spot> getSpots() {
        return spots;
    }

    public void setType(LocationType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("Location[id=%d,name='%s', parent='%s' ,type='%s' , childrenSize='%s']",
                id ,name,parent,type,(children != null ? children.size() : 0) );
    }
}
