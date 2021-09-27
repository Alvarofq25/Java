package com.alvaro.rext.token.model.api;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@Builder
public class TokenDTO {

    @NotNull
    private UUID userToken;

}
