package io.undefvar.momoopenapispringbootdemo.config;

import feign.RequestInterceptor;
import io.undefvar.momoopenapispringbootdemo.Props.MomoApiConfigProps;
import io.undefvar.momoopenapispringbootdemo.services.AccessTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MomoApiConfig {
    private final AccessTokenProvider provider;
    private final MomoApiConfigProps props;

    @Bean
    RequestInterceptor requestInterceptor(){
        return requestTemplate -> requestTemplate
                .header("Authorization", "Bearer "+ provider.getAccessToken())
                .header("X-Target-Environment", props.getTargetEnvironment())
                .header("Ocp-Apim-Subscription-Key", props.getOcpApimSubscriptionKey());
    }
}
