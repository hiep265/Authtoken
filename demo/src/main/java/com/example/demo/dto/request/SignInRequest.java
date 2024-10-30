package com.example.demo.dto.request;

import com.example.demo.until.Platform;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.apache.logging.log4j.message.Message;

import java.io.Serializable;
@Getter
public class SignInRequest implements Serializable {
    @NotBlank(message = "user must not null")
    private String username;
    @NotBlank(message = "password must not blank")
    private String password;
    @NotNull(message = "platform must not null")
    private Platform platform;
    private String deviceToken;
    private String version;
}
