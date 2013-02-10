package com.demo.asm_api.services.device.impl;

import com.demo.asm_api.model.device.Device;
import com.demo.asm_api.repository.asm.device.DeviceRepository;
import com.demo.asm_api.services.device.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service("deviceService")
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceRepository repository;

    @Override
    public Device getById(int id) {
        return repository.get(Device.class, id);
    }

    @Override
    public List<Device> getAll() {
        return repository.getAll(Device.class);
    }

    @Override
    public void save(Device toSave) {
        repository.save(toSave);
    }

    @Override
    public void delete(Device toDelete) {
        repository.delete(toDelete);
    }

}
