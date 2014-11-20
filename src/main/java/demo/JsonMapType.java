package demo;

import com.bazarnazar.pgjson.PgJsonCollection;
import org.codehaus.jackson.type.TypeReference;

import java.util.Map;

public class JsonMapType extends PgJsonCollection {

    @Override
    protected TypeReference getReturnedTypeReference() {
        return new TypeReference<Map<String, Custom>>() {
        };
    }
}
