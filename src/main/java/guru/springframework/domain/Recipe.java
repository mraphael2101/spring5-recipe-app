package guru.springframework.domain;

import javax.persistence.*;
import java.util.Set;

// As per the ERD, Recipe class is a parent of several derived classes
@Entity
public class Recipe {

    @Id // IDENTITY WILL SUPPORT AUTO GENERATION OF A SEQUENCE FOR RDBMS
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer prepTime, cookTime, servings;
    private String source, url, directions;
    // private Difficulty difficulty;   // to do

    // Cascade Type ensures that this entity will own the relationship with Ingredient
    // mappedBy specifies that the set of ingredients will be stored on the child class property -> 'recipe'
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients;

    @Lob // Allows JPA to create a blob (binary large object) in the database
    private Byte[] image;

    // JPA Cascade Types control how state changes are cascaded from parent objects to child objects
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }
}
