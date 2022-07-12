package com.july.cloud.framework.front;

import com.july.cloud.common.core.domain.R;
import com.july.cloud.framework.front.model.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId = "remoteUserService", value = "july-framework-backend", path = "/framework/sys/user")
public interface RemoteUserService {


    @GetMapping("/username")
    R<String> findUsername(@RequestParam(required = false) String email, @RequestParam(required = false) String phone);

    @GetMapping("/names/{username}")
    R<UserInfo> findInfoByUsername(@PathVariable("username") String username);
}
