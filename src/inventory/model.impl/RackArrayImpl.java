package inventory.model.impl;

import inventory.model.Device;
import inventory.model.Rack;

public class RackArrayImpl implements Rack {



    protected int size;
    protected Device[] devicesarray;
    public RackArrayImpl(int size) {
        if (size < 0) {
            this.size = 0;
            System.err.println("Количество слотов не должно быть меньше 0");
        }
        else
            this.size = size;
        devicesarray = new Device[this.size];
    }

    public int getSize() {
        return size;
    }

    public int getFreeSize() {
        int result = 0;
        for (Device d:devicesarray) {
            if (d == null)
                result++;
        }
        return result;
    }

    public Device getDevAtSlot(int index) {
        Device result = null;
        if (isCorrectIndex(index) == false) {
            result = null;
        }
        else if(devicesarray[index] != null)
            result = devicesarray[index];
        return result;
    }


    public boolean insertDevToSlot(Device device, int index) {
        boolean result = false;
        if (isCorrectIndex(index) == false) {
            result = false;
        }
        else if (device.getIn() == 0) {
            System.err.println("Индекс устройства не присвоен");
        }
        else if (getFreeSize() == 0) {
            System.err.println("Нет свободных слотов для вставки");
        }
        else {
            devicesarray[index] = device;
            result = true;
        }
        return result;
    }

    public Device removeDevFromSlot(int index) {
        Device result = null;
        if (isCorrectIndex(index) == false) {
            result = null;
        }
        else if (devicesarray[index] != null) {
            result = devicesarray[index];
            devicesarray[index] = null;
        }
        return result;
    }

    public Device getDevByIN(int in) {
        Device result = null;
        for (Device d: devicesarray) {
            if (d.getIn() == in) {
                result = d;
                break;
            }
        }
        return  result;
    }

    private Boolean isCorrectIndex(int index) {
        boolean result = true;
        if (index < 0 || index >= devicesarray.length) {
            System.err.println("Индекс вне границ массива");
            result = false;
        }
        return result;
    }
}
