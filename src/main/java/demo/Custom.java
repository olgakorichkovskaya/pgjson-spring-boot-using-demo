package demo;

import com.bazarnazar.pgjson.PGJsonObject;

import java.util.List;

public class Custom extends PGJsonObject {

    private String name = "Def new";
    private List<Price> priceList;

    public Custom() {
    }

    public Custom(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Price> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<Price> priceList) {
        this.priceList = priceList;
    }
}
