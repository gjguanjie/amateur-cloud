package com.cloud.mapper;

import com.cloud.domain.TestVO;

import java.util.Map;

public interface TestMapper  {

    public TestVO queryUser(Map<String,Object> paramMap);

}
