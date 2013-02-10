package com.demo.asm_api.services.device;

import com.demo.asm_api.model.device.Device;

import java.util.List;

/**
 * This class is used to execute the business logic for the device
 * and as connection between controllers and repositories
 *
 * @author Ignas Nikolajev
 */
public interface DeviceService {

    /**
     * Returns the device model that is found by its Id
     *
     * @param id Device ID
     * @return device model
     */
    public Device getById(int id);

    /**
     * Returns the list of all device models
     *
     * @return List of all device models
     */
    public List<Device> getAll();

    /**
     * Saves the device object in the database
     *
     */
    public void save(Device toSave);

    /**
     * Removes the device object from the database
     *
     */
    public void delete(Device toDelete);

}
