package com.demo.asm_api.services.device;

import com.demo.asm_api.model.device.Device;

import java.util.List;

public interface DeviceService {

    public Device getById(int id);

    public List<Device> getAll();

    public void save(Device toSave);

    public void delete(Device toDelete);

}
