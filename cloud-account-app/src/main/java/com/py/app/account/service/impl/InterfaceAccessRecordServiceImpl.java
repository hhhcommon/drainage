package com.py.app.account.service.impl;

import java.util.Date;

import com.py.app.account.mysql.entities.CLInterfaceAccessRecord;
import com.py.app.account.mysql.mapper.CLInterfaceAccessRecordMapper;
import com.py.app.account.service.InterfaceAccessRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by jzl on 17/12/14.
 */
@Service
public class InterfaceAccessRecordServiceImpl implements InterfaceAccessRecordService {
    private static Logger logger = LoggerFactory.getLogger(InterfaceAccessRecordServiceImpl.class);
    @Autowired
    private CLInterfaceAccessRecordMapper interfaceAccessRecordMapper;

    @Override
    public void insertRecord(String merchantCode, String method, int type) {
        CLInterfaceAccessRecord record = new CLInterfaceAccessRecord();
        record.setInterfaceMethod(method);
        record.setInterfaceType(type);
        record.setMerchantCode(merchantCode);
        record.setCreateTime(new Date());
        record.setAccessTime(new Date());

        interfaceAccessRecordMapper.insertSelective(record);
    }
}
