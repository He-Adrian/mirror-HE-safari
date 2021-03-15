package ch.hearc.spring.todo.model;

/**
 * Enum that defines a priority for the todo
 * @author javaee
 *
 */
public enum TodoPriority {
	
	
	LOW("Priorité basse"),
    MEDIUM("Priorité moyenne"),
    HIGH("Priorité haute"),
    WHOCARES("Quelle priorité ?");

    private String description;
    
    TodoPriority(final String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return this.description;
    }
}
