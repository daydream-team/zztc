package com.daydream.console.dao.impl;

import com.daydream.console.dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdminMongoDao implements AdminDao {

    @Autowired
    protected MongoTemplate mongoTemplate;

    private static final String COLLECTION_NAME = "admin";


}
