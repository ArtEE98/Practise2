package inventory.model.impl;

import inventory.model.Device;
import java.util.Date;

public abstract class AbstractDevice implements Device {
    protected int in = 0;

    public int getIn() {
        return  in;
    }

    public void setIn(int in) {
        if (this.in != 0) {
            System.err.println("Индекс уже был изменен. Изменение невозможно.");
        }
        else if(in <= 0) {
            System.err.println("Индекс меньше либо равен 0.Изменение невозможно.");
        }
        else {
            this.in = in;
        }
    }

    protected String type;

    public String getType() {
        return  type;
    }

    public void setType(String type) {
        this.type = type;
    }

    protected String manufacturer;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    protected String model;

    public String getModel() {
        return  model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    protected Date productionDate;

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

}
