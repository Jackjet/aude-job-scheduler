package spring;

/**
 * Created by lrkin on 2016/11/26.
 */
public class JobBeanConfig {
    private AudeJob ref;
    private String name;
    private String description;

    public AudeJob getRef() {
        return ref;
    }

    public void setRef(AudeJob ref) {
        this.ref = ref;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
