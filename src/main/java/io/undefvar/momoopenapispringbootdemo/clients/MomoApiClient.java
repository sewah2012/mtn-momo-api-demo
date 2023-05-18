package io.undefvar.momoopenapispringbootdemo.clients;

import io.undefvar.momoopenapispringbootdemo.config.MomoApiConfig;
import io.undefvar.momoopenapispringbootdemo.dto.AccountBalanceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "open-api-client",
        url = "https://sandbox.momodeveloper.mtn.com/remittance",
        configuration = MomoApiConfig.class

)
public interface MomoApiClient {

    @GetMapping("/v1_0/account/balance")
    AccountBalanceDto getAccountBalance();
}
