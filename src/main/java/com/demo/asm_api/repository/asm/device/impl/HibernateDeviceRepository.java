package com.demo.asm_api.repository.asm.device.impl;

import com.demo.asm_api.repository.asm.device.DeviceRepository;
import com.demo.asm_api.repository.impl.HibernateBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateDeviceRepository extends HibernateBaseRepository implements DeviceRepository {

}
