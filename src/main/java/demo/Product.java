package demo;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.HashMap;
import java.util.Map;

@Entity
@TypeDefs({@TypeDef(name = "JsonObject", typeClass = demo.Custom.class),
        @TypeDef(name = "JsonMapTypeHash", typeClass = com.bazarnazar.pgjson.JsonMapType.class),
        @TypeDef(name = "JsonMapTypeMy", typeClass = demo.JsonMapType.class)})
public class Product {

    @Id
    @GeneratedValue
    public Integer id;

    private Custom custom;

    @Type(type = "JsonObject")
    public Custom getCustom() {
        return custom;
    }

    private HashMap<String, Custom> namedCustoms;

    @Transient
    private Map<String, Custom> namedCustomsMap;

    @Type(type = "JsonMapTypeHash")
    public HashMap<String, Custom> getNamedCustoms() {
        return namedCustoms;
    }

    /**
     * Unclear how to configure right
     */
//    @Type(type = "JsonMapTypeMy")
    public Map<String, Custom> getNamedCustomsMap() {
        return namedCustomsMap;
    }

    public void setNamedCustomsMap(Map<String, Custom> namedCustomsMap) {
        this.namedCustomsMap = namedCustomsMap;
    }

    public void setNamedCustoms(HashMap<String, Custom> namedCustoms) {
        this.namedCustoms = namedCustoms;
    }

    public void setCustom(Custom custom) {
        this.custom = custom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}