package com.tdd.online_ddketang.service;

import com.tdd.online_ddketang.mapper.PlayRecordMapper;
import com.tdd.online_ddketang.model.pojo.PlayRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayRecordServiceImpl implements PalyRecordService {

    @Autowired
    PlayRecordMapper playRecordMapper;

    @Override
    public int save(PlayRecord playRecord) {
        return playRecordMapper.save(playRecord);
    }
}
