package inventory.service.impl;

import inventory.model.Device;
import inventory.service.Service;

import java.util.ArrayList;

public class ServiceImpl implements Service {
    /**
     * Sort array of Device-s by identification number.
     *
     * @param devices - array of Device-s, that need to be sorted
     */

    public void sortByIN(Device[] devices) {
        ArrayList<Device> zeroIndexDevices = new ArrayList<Device>();
        ArrayList<Device> otherDevices = new ArrayList<Device>();
        for (Device d:devices) {
            if (d == null)
                continue;
            else if (d.getIn() == 0)
                zeroIndexDevices.add(d);
            else
                otherDevices.add(d);
        }

        for (int i = 0; i < otherDevices.size()-1; i++)
            for (int j = i+1; j < otherDevices.size(); j++)
                if (otherDevices.get(i).getIn() < otherDevices.get(j).getIn() ) {
                    Device temp = otherDevices.get(i);
                    otherDevices.set(i , otherDevices.get(j));
                    otherDevices.set(j , temp);
                }
        for (int i = 0; i<devices.length; i++) {
            if (i < otherDevices.size()) {
                devices[i] = otherDevices.get(i);
            }
            else if (i  < (zeroIndexDevices.size() + otherDevices.size()))
                devices[i] = zeroIndexDevices.get(i);
            else
                devices[i] = null;
        }

    }

    public void filtrateByType(Device[] devices, String type) {
        for (Device d:devices) {
            if(d.getType() != type) {
                d = null;
            }
        }

    }
}
