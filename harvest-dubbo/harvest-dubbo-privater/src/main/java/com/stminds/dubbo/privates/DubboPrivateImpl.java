package com.stminds.dubbo.privates;

import com.stminds.dubbo.api.DubboTest;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@Service
@DubboService
public class DubboPrivateImpl implements DubboTest {

    @Override
    public String sayHi() {
        return "hello====================================================";
    }
}
