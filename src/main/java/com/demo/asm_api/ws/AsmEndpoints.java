package com.demo.asm_api.ws;

import com.demo.asm_api.model.device.Device;
import com.demo.asm_api.services.device.DeviceService;
import generatedSoapApi.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

/**
 * This class is used for publish methods that can be used to start an endpoint,
 * at which point it starts accepting incoming requests.
 *
 * @author Ignas Nikolajev
 */

@Endpoint
public class AsmEndpoints {

    private static final String ENDPOINT_NAMESPACE = "http://asm_api/schemas";

    @Autowired
    private DeviceService deviceService;


    /**
     * This method is used to get the device details
     *
     */
    @PayloadRoot(localPart = "getDeviceRequest", namespace = ENDPOINT_NAMESPACE)
    @ResponsePayload
    public GetDeviceResponse handleGetDeviceRequest(
            @RequestPayload GetDeviceRequest request) {
        GetDeviceResponse response = new GetDeviceResponse();
        StatusResponse tmpStatusResponse = new StatusResponse();
        DeviceInfo tmpDeviceInfo = new DeviceInfo();
        int requestDeviceId = request.getId();
        Device tmpDevice;
        if (requestDeviceId == 0)
        {
            tmpStatusResponse.setId(0);
            tmpStatusResponse.setDescription("Please send device id");
            response.setStatus(tmpStatusResponse);
            return response;
        }  else  {
            try {
                tmpDevice = deviceService.getById(requestDeviceId);
            } catch (Exception e) {
                tmpStatusResponse.setId(0);
                tmpStatusResponse.setDescription(e.getMessage());
                response.setStatus(tmpStatusResponse);
                return response;
            }
        }
        if (tmpDevice != null){
            tmpDeviceInfo.setId(tmpDevice.getId());
            tmpDeviceInfo.setName(tmpDevice.getName());
            response.setDeviceInfo(tmpDeviceInfo);
        }  else {
            tmpStatusResponse.setId(0);
            tmpStatusResponse.setDescription("No device found for this Id");
            response.setStatus(tmpStatusResponse);
            return response;
        }

        tmpStatusResponse.setId(1);
        response.setStatus(tmpStatusResponse);
        return response;
    }

    /**
     * This method is used to get the device list
     *
     */
    @PayloadRoot(localPart = "getDeviceListRequest", namespace = ENDPOINT_NAMESPACE)
    @ResponsePayload
    public GetDeviceListResponse handleGetDeviceListRequest(
            @RequestPayload GetDeviceListRequest request) {
        GetDeviceListResponse response = new GetDeviceListResponse();
        List<Device> deviceList = deviceService.getAll();
        DeviceList tmpDeviceList = new DeviceList();
        for(Device device: deviceList){
            DeviceInfo deviceInfo = new DeviceInfo();
            deviceInfo.setId(device.getId());
            deviceInfo.setName(device.getName());
            tmpDeviceList.getDeviceInfo().add(deviceInfo);
        }

        response.setDeviceList(tmpDeviceList);
        return response;
    }

    /**
     * This method is used to get create the device or update device details
     *
     */
    @PayloadRoot(localPart = "createOrUpdateDeviceRequest", namespace = ENDPOINT_NAMESPACE)
    @ResponsePayload
    public CreateOrUpdateDeviceResponse handleCreateOrUpdateDeviceRequest(
            @RequestPayload CreateOrUpdateDeviceRequest request) {
        CreateOrUpdateDeviceResponse response = new CreateOrUpdateDeviceResponse();
        StatusResponse tmpStatusResponse = new StatusResponse();
        int requestDeviceId = request.getId();
        String requestDeviceName = request.getName();
        Device tmpDevice;
        if (requestDeviceId == 0)
        {
            tmpStatusResponse.setId(0);
            tmpStatusResponse.setDescription("Please send device id");
            response.setStatus(tmpStatusResponse);
            return response;
        }  else  {
            try {
                tmpDevice = deviceService.getById(requestDeviceId);
            } catch (Exception e) {
                tmpStatusResponse.setId(0);
                tmpStatusResponse.setDescription(e.getMessage());
                response.setStatus(tmpStatusResponse);
                return response;
            }
        }
        if (tmpDevice != null){
            tmpDevice.setName(requestDeviceName);
            try {
                deviceService.save(tmpDevice);
            } catch (Exception e) {
                tmpStatusResponse.setId(0);
                tmpStatusResponse.setDescription(e.getMessage());
                response.setStatus(tmpStatusResponse);
                return response;
            }
            tmpStatusResponse.setId(1);
            tmpStatusResponse.setDescription("Device updated successfully");
            response.setStatus(tmpStatusResponse);
            return response;
        }  else {
            tmpDevice = new Device();
            tmpDevice.setId(requestDeviceId);
            tmpDevice.setName(requestDeviceName);
            try {
                deviceService.save(tmpDevice);
            } catch (Exception e) {
                tmpStatusResponse.setId(0);
                tmpStatusResponse.setDescription(e.getMessage());
                response.setStatus(tmpStatusResponse);
                return response;
            }
            tmpStatusResponse.setId(1);
            tmpStatusResponse.setDescription("Device created successfully");
            response.setStatus(tmpStatusResponse);
            return response;
        }

    }

    /**
     * This method is used to delete the device details
     *
     */
    @PayloadRoot(localPart = "deleteDeviceRequest", namespace = ENDPOINT_NAMESPACE)
    @ResponsePayload
    public DeleteDeviceResponse handleDeleteDeviceRequest(
            @RequestPayload DeleteDeviceRequest request) {
        DeleteDeviceResponse response = new DeleteDeviceResponse();
        StatusResponse tmpStatusResponse = new StatusResponse();
        int requestDeviceId = request.getId();

        Device tmpDevice;
        if (requestDeviceId == 0)
        {
            tmpStatusResponse.setId(0);
            tmpStatusResponse.setDescription("Please send device id");
            response.setStatus(tmpStatusResponse);
            return response;
        }  else  {
            try {
                tmpDevice = deviceService.getById(requestDeviceId);
                deviceService.delete(tmpDevice);
            } catch (Exception e) {
                tmpStatusResponse.setId(0);
                tmpStatusResponse.setDescription(e.getMessage());
                response.setStatus(tmpStatusResponse);
                return response;
            }
        }
            tmpStatusResponse.setId(1);
            tmpStatusResponse.setDescription("Device deleted successfully");
            response.setStatus(tmpStatusResponse);
            return response;
        }
}
