package io.undefvar.momoopenapispringbootdemo.services;

import io.undefvar.momoopenapispringbootdemo.Props.MomoApiConfigProps;
import io.undefvar.momoopenapispringbootdemo.clients.MomoApiAuthClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccessTokenProvider {
    private final MomoApiAuthClient authClient;
    private final MomoApiConfigProps props;

    public String getAccessToken(){
        String header = Base64.getEncoder().encodeToString(String.format("%s:%s", props.getApiUserId(), props.getApiKey()).getBytes()
        );

        var authResponse = authClient.getAccessToken("Basic "+header, props.getOcpApimSubscriptionKey());

        log.info("access token: " + authResponse.accessToken());
        return authResponse.accessToken();

    }
}
